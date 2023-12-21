package application.main.scene;

import application.extensions.EnvironmentEmptyException;
import application.main.scene.enums.EnvironmentObjectTypes;
import application.main.scene.enums.EnvironmentTemperature;
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

        addAction(0, (obj) -> {
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
