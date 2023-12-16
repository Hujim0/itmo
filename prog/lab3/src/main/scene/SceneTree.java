package main.scene;

import lombok.Getter;
import lombok.Setter;
import main.render.structs.ActionData;
import main.scene.interfaces.Findable;
import main.scene.nodes.DrawableNode;
import main.scene.nodes.Node;

import java.util.*;

@Getter
public class SceneTree {
    private List<Node> nodes = new ArrayList<>();

    @Setter
    private Node root;



    private final Queue<ActionData> actionQueue = new ArrayDeque<>();
    private final List<DrawableNode> drawableNodesRenderQueue = new ArrayList<>();

    private final Environment environment = new Environment();;

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

    public void printTree() {
        System.out.println("root");

        printChildren(0, root);
    }

    public Node find(Findable labmda) {
        return findInNodesChildrenRecursively(labmda, root);
    }

    private Node findInNodesChildrenRecursively(Findable lambda, Node parent) {
        for (Node child : parent.getChildNodes()) {
            findInNodesChildrenRecursively(lambda, child);

            if (lambda.compare(child))
                return child;
        }

        return null;
    }

    void printChildren(int depth, Node node) {
        depth+=1;
        for (Node child : node.getChildNodes()) {
            if (!child.getChildNodes().isEmpty()) {
                String out = new String();

                for (int i = 0; i < depth; i++) {
                    out += "  ";
                }

                out += child.toString() + "\n";
                System.out.println(out);
                printChildren(depth, child);
            }
        }
    }
}
