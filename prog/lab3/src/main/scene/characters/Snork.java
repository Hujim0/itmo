package main.scene.characters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import main.scene.enums.EnvironmentTemperature;
import main.scene.enums.SnorkState;
import main.scene.interfaces.Sensible;
import main.scene.nodes.Node;
import main.scene.Environment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Snork extends Node implements Sensible {

    SnorkState state = SnorkState.DEFAULT;
    public void changeState(SnorkState state, String message) {
        this.state = state;

        System.out.println("Снорк " + message);
    }

    @Override
    public void reactToEnvironment(Environment environment) {
        if (environment.getTemperature() == EnvironmentTemperature.COLD_TEMREATURE) {
            System.out.println("Фрекен Снорк тихо плакала, уткнувшись в перину.");
        }
    }
}
