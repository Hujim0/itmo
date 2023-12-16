package engine.structs;

import lombok.AllArgsConstructor;
import lombok.Data;
import engine.interfaces.Action;
import engine.scene.nodes.Node;

@Data
@AllArgsConstructor
public class ActionData {
    Node caller;

    Action<Node> action;

    public void invoke() {
        action.invoke(caller);
    }
}
