package main.render.structs;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.scene.interfaces.Action;
import main.scene.nodes.Node;

@Data
@AllArgsConstructor
public class ActionData {
    Node caller;

    Action<Node> action;

    public void invoke() {
        action.invoke(caller);
    }
}
