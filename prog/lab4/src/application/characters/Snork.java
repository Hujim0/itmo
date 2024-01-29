package application.characters;

import application.extensions.CanBeDescribed;
import application.sceneNodes.ViewDescriber;
import engine.scene.EnvironmentEmptyException;
import application.extensions.Sensible;
import engine.scene.SceneTree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import engine.structs.EnvironmentTemperature;
import engine.scene.nodes.Node;
import engine.scene.Environment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Snork extends Node implements Sensible {

    Fringe snorkFringe = new Fringe();

    public static final String dreamDescription = "Ей приснилось, что мордочка у нее совсем маленькая и необыкновенно очаровательная.";

    @Data
    static final class Fringe implements CanBeDescribed {
        FringeState currentState;
        public String describe() {
            return "Её челка была совершенно " + currentState.getDescription();
        }
    }

    @Getter
    enum FringeState {
        DRY("сухая"),
        WET("мокрая");

        private final String description;
        FringeState(String description) {
            this.description = description;
        }
    }

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

    public void wakeUpBy(EnvironmentTemperature temperature) {
        switch (temperature) {
            case COLD_TEMREATURE -> {
                System.out.println("Снорк проснулась от холода");
            }
            case HOT_TEMPERATURE -> {
                System.out.println("Снорк проснулась от жары");
            }
            default -> {
                throw new RuntimeException("Not implemented");
            }
        }
    }

    @Override
    public void treeEnter() {
        snorkFringe.setCurrentState(FringeState.WET);

        addAction(0, (obj) -> {
            Environment environment = obj.getSceneTree().getEnvironment();

            wakeUpBy(environment.getTemperature());

            System.out.println(snorkFringe.describe());

            try {
                System.out.println(environment.describeViewFully());
            } catch (EnvironmentEmptyException e) {
                throw new RuntimeException("env is empty");
            }


            for ()
        });

        addAction(1, (obj) -> {
            Snork instance = (Snork) obj;
            instance.changeState(SnorkState.TRY_TO_WATCH_DREAM_FULLY, "попыталась досмотреть свой приятный сон.");
            System.out.println(dreamDescription);
        });

        addAction(2, (obj) -> {
            Snork instance = (Snork) obj;
            instance.changeState(SnorkState.FEELING_STIRRED, "быстро села и огляделась вокруг.");
        });
        addAction(
        4, (obj) -> {
            Snork instance = (Snork) obj;
            instance.changeState(SnorkState.LOST_SPEECH, "на мгновение утратила дар речи.");
        });
        addAction(5, (obj) -> {
            Snork instance = (Snork) obj;
            instance.changeState(SnorkState.LEANED_OVER, "наклонилась. И начала трясти Муми-тролля");

        });
        addAction(6, (obj) -> {
            Snork instance = (Snork) obj;
            instance.changeState(SnorkState.HUGGING_AND_CRYING, "и Муми-Троль долго сидели прижавшись друг к другу.");
            instance.reactToEnvironment(instance.getSceneTree().getEnvironment());


        });
    }
}