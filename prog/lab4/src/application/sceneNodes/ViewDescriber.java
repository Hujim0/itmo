package application.sceneNodes;

import engine.scene.EnvironmentEmptyException;
import engine.structs.EnvironmentObjectTypes;
import engine.structs.EnvironmentTemperature;
import engine.scene.nodes.Node;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ViewDescriber extends Node {

    public void treeEnter() {
        getSceneTree().getEnvironment().addObjects(EnvironmentTemperature.COLD_TEMREATURE,
                EnvironmentObjectTypes.TREES,
                EnvironmentObjectTypes.FOG,
                EnvironmentObjectTypes.WATER);

        addAction(4, (obj) -> {
            try {
                System.out.println(obj.getSceneTree().getEnvironment().describeView());
            }
            catch (EnvironmentEmptyException e) {
                System.out.println("Вокруг ничего не видно...");
            }
            finally {
                System.out.println("Их бросили на произвол судьбы.");
            }
        });
    }
}
