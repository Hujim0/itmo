package engine.scene.nodes;

import lombok.*;
import engine.structs.ActionData;
import engine.interfaces.*;
import engine.structs.ActionOnFrame;
import engine.scene.SceneTree;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class Node {

    private List<ActionOnFrame<Node>> ActionOnFrames = new ArrayList<>();

    private List<Node> childNodes = new ArrayList<>();
    private Node parentNode;

    @Setter(AccessLevel.PROTECTED)
    private SceneTree sceneTree;

    @Setter
    private boolean Active =true;

    public Node(SceneTree tree) {
        sceneTree = tree;
    }
    public Node addAction(int Frame, Action<Node> callable) {
        ActionOnFrames.add(new ActionOnFrame<>(Frame, callable));

        return this;
    }

    public Node addChild(Node child) {
        child.setParentNode(this);
        child.setSceneTree(this.sceneTree);

        childNodes.add(child);

        child.start();

        return this;
    }

    public void queueMoveToChild(Node node) {
        getSceneTree().getActionQueue().add(new ActionData(node, (obj) -> {
            obj.getParentNode().getChildNodes().remove(obj);
            getParentNode().getChildNodes().add(obj);
            obj.setParentNode(this);
        }));
    }

    public void start() {}

    public Node forAllChildren(Action<Node> callable) {
        for (Node child : getChildNodes()) {
            callable.invoke(child);
        }

        return this;
    }

    public void queueFree() {
        sceneTree.getActionQueue().add(new ActionData(this, (obj) -> obj.free()));
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
        while (i < ActionOnFrames.size()) {
            if (ActionOnFrames.get(i).getActionFrame() == currentFrame) {
                ActionOnFrames.get(i).invoke(this);
                ActionOnFrames.remove(i);
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
