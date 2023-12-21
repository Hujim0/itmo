package application.characters;

import application.extensions.Sensible;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import application.main.scene.enums.EnvironmentTemperature;
import application.main.scene.enums.SnorkState;
import engine.scene.nodes.Node;
import application.main.scene.Environment;

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

    @Override
    public void treeEnter() {
        addAction(
        0, (obj) -> {
            Snork instance = (Snork) obj;
            instance.changeState(SnorkState.LOST_SPEECH, "на мгновение утратила дар речи.");
        });
        addAction(1, (obj) -> {
            Snork instance = (Snork) obj;
            instance.changeState(SnorkState.LEANED_OVER, "наклонилась. И начала трясти Муми-тролля");

        });
        addAction(2, (obj) -> {
            Snork instance = (Snork) obj;
            instance.changeState(SnorkState.HUGGING_AND_CRYING, "и Муми-Троль долго сидели прижавшись друг к другу.");
            instance.reactToEnvironment(instance.getSceneTree().getEnvironment());


        });
    }
}