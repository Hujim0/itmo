package engine.scene.nodes;

import engine.Debug;
import lombok.*;
import engine.structs.ActionData;
import engine.interfaces.*;
import engine.structs.ActionOnFrame;
import engine.scene.SceneTree;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@Data
@ToString
@NoArgsConstructor
@SuperBuilder
public class Node {

    private List<ActionOnFrame<Node>> actionsOnFrames = new ArrayList<>();

    @ToString.Exclude
    private List<Node> childNodes = new ArrayList<>();
    @ToString.Exclude
    private Node parentNode;

    @ToString.Exclude
    @NonNull
    private String name = toString();

    @Setter(AccessLevel.PROTECTED)
    private SceneTree sceneTree;

    @Setter
    private boolean active = true;

    public Node(SceneTree tree) {
        sceneTree = tree;
    }
    public Node(String name) {
        setName(name);
    }

    public Node(List<ActionOnFrame<Node>> actionsOnFrames, List<Node> childNodes, Node parentNode, String name, SceneTree sceneTree, boolean active) {
        this.actionsOnFrames = actionsOnFrames;
        this.childNodes = childNodes;
        this.parentNode = parentNode;
        this.name = name;
        this.sceneTree = sceneTree;
        this.active = active;
    }

    public Node addAction(int Frame, Action<Node> callable) {
        if (getSceneTree() == null) {
            throw new NodeNotReadyException(this, "Adding actions");
        }


        actionsOnFrames.add(new ActionOnFrame<>(Frame, callable));

        return this;
    }

    public Node addChild(Node child) {
        if (getSceneTree() == null) {
            throw new NodeNotReadyException(this, "Adding child nodes");
        }

        child.setParentNode(this);
        child.setSceneTree(this.sceneTree);

        childNodes.add(child);

        child.treeEnter();

        return this;
    }


    public void queueMoveToChild(Node newParent) {

        getSceneTree().getActionQueue().add(new ActionData(newParent, (parent) -> {
            if (parent.getSceneTree() == null) {
                throw new NodeNotReadyException(parent, "Moving to this node child nodes");
            }

            getParentNode().getChildNodes().remove(this);
            parent.getChildNodes().add(this);
            setParentNode(parent);
        }));
    }

    public void treeEnter() {}

    public Node forAllChildren(Action<Node> callable) {
        for (Node child : getChildNodes()) {
            callable.invoke(child);
        }

        return this;
    }

    public void queueFree() {
        sceneTree.getActionQueue().add(new ActionData(this, Node::free));
    }

    public void free() {
        while (!childNodes.isEmpty()) {
            childNodes.get(0).free();
        }

        parentNode.getChildNodes().remove(this);
    }

    public void update(int currentFrame) {
        if (!isActive()) {
            return;
        }

        int i = 0;
        while (i < actionsOnFrames.size()) {
            if (actionsOnFrames.get(i).getActionFrame() == currentFrame) {
                actionsOnFrames.get(i).invoke(this);
                Debug.log(Level.FINE, String.format("Action in frame %d: %s", currentFrame, this.toString()));
                actionsOnFrames.remove(i);
            }
            else {
                i+=1;
            }
        }

        if (!isActive()) {
            return;
        }

        for (Node child : getChildNodes()) {
            child.update(currentFrame);
        }
    }
}