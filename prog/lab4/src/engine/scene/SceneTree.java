package engine.scene;

import lombok.Getter;
import lombok.Setter;
import engine.structs.ActionData;
import engine.interfaces.Findable;
import engine.scene.nodes.DrawableNode;
import engine.scene.nodes.Node;

import java.util.*;

@Getter
public class SceneTree {
    private final List<Node> nodes = new ArrayList<>();

    @Setter
    private final Node root;


    private final Queue<ActionData> actionQueue = new ArrayDeque<>();
    private final List<DrawableNode> drawableNodesRenderQueue = new ArrayList<>();
    @Setter
    private Environment environment;

    public SceneTree(Node root)
    {
        this.root = root;
    }

    public SceneTree() {
        root = new Node(this);
    }
    public void sortDrawables() {
        Collections.sort(drawableNodesRenderQueue);
    }
    public void update(int CurrentFrame) {
        root.update(CurrentFrame);
    }
    public void releaseActionQueue() {
        for (int i = 0; i <  actionQueue.size(); i++) {
            actionQueue.remove().invoke();
        }
    }
    public void releaseRenderQueue() {
        drawableNodesRenderQueue.clear();
    }

    public String printTree() {
        StringBuilder builder = new StringBuilder();

        builder.append(" ┖╴root");
        builder.append("\n");
        printChildren("   ", root, builder);

        return builder.toString();
    }

    public Node find(Findable labmda) {
        return findInNodesChildrenRecursively(labmda, root);
    }

    private Node findInNodesChildrenRecursively(Findable lambda, Node parent) {
        for (Node child : parent.getChildNodes()) {
            if (findInNodesChildrenRecursively(lambda, child) == null) {
                continue;
            };

            if (lambda.compare(child))
                return child;
        }

        return null;
    }

    void printChildren(String trail, Node node, StringBuilder builder) {
        List<Node> children = node.getChildNodes();

        int childCount = children.size();

        for (int i = 0; i < childCount; i++) {


            Node child = children.get(i);
            String out;

            if (i == childCount - 1) {
                out = trail +" ┖╴"+ child;
            }
            else {
                out = trail +" ┠╴"+ child;
            }

            builder.append(out);
            builder.append("\n");
            if (!child.getChildNodes().isEmpty()) {
                if (i == childCount - 1) {
                    printChildren(trail + "   ", child, builder);
                }
                else {
                    printChildren(trail + " ┃ ", child, builder);
                }
            }
        }
    }
}
