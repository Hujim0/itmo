package application.sceneNodes;

import application.extensions.CanBeDescribed;
import engine.structs.EnvironmentObjectTypes;
import engine.scene.nodes.Node;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class Rain extends Node implements CanBeDescribed {

    public final static String description = "Кругом капало. Кап-кап-кап -- печально падали капли, разбиваясь о темную воду.";

    public String describe() {
        System.out.println(description);

        return description;
    }

    @Override
    public void treeEnter() {
        addAction(5, (obj) -> {
            ((CanBeDescribed) obj).describe();
            obj.getSceneTree().getEnvironment().addObject(EnvironmentObjectTypes.RAIN);
        });
    }
}
