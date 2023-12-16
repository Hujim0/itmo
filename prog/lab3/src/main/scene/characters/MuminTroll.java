package main.scene.characters;

import main.scene.enums.EnvironmentTemperature;
import main.scene.interfaces.Sensible;
import main.scene.nodes.Node;
import main.scene.Environment;

public class MuminTroll extends Node implements Sensible {

    @Override
    public void reactToEnvironment(Environment environment) {
        if (environment.getTemperature() == EnvironmentTemperature.COLD_TEMREATURE) {
            System.out.println("Было " + environment.getTemperature().description);
        }
    }
}
