package engine.scene.nodes;

public class NodeNotReadyException extends RuntimeException {
    public NodeNotReadyException(Node node, String error) {
        System.out.println(node);

        System.out.println("Is not have been initialised for " + error);
    }
}
