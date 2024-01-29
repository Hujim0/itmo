package application.sceneNodes;

import engine.scene.nodes.Node;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class Sandwich extends Node {

    private String madeBy;

    public Sandwich(String name, String madeBy) {
        this.madeBy = madeBy;
        setName(name);
    }
}
