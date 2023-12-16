package main;

import main.scene.enums.*;
import main.render.*;
import main.render.structs.*;
import main.scene.*;
import main.scene.characters.*;
import main.scene.nodes.Node;

import java.util.logging.Level;
import java.util.logging.Logger;
/*
Деревья, туман, вода. А дома нет. Дом исчез, а их с Муми-троллем бросили на произвол судьбы.
На мгновение фрекен Снорк утратила дар речи. Затем, наклонившись, начала осторожно трясти Муми-тролля.
Кругом капало. Кап-кап-кап -- печально падали капли, разбиваясь о темную воду.
За ночь опали лепестки цветов на деревьях. Было холодно. Прижавшись друг к другу,
они долго сидели не двигаясь, фрекен Снорк тихо плакала, уткнувшись в перину.
Наконец Муми-тролль встал с постели и машинально снял с ветки корзинку с едой.
*/

public class Application {
    public static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static SceneTree currentSceneTree = new SceneTree();
    static public void run() {

        LOGGER.setLevel(Level.FINEST);

        System.out.println(new Node().hashCode());

        currentSceneTree.getEnvironment().addObjects(
                EnvironmentTemperature.COLD_TEMREATURE,
                EnvironmentProperties.TREES,
                EnvironmentProperties.FOG,
                EnvironmentProperties.WATER);

        currentSceneTree.getRoot()
            .addAction(0, (obj) -> {
                System.out.println(obj.getSceneTree().getEnvironment().describeView());

                System.out.println("Их бросили на произвол судьбы.");
            })
            .addChild(new Forest(new IntVector2(0, 0))
                .addAction(1, (object) -> {
                    LOGGER.log(Level.FINE, String.format("Action in frame %d: %s", 1, ((Forest)object).getClass()));

                    object.forAllChildren((child) -> {
                        child.setActive(false);
                    });
                })
                .addAction(2, (object) -> {
                    LOGGER.log(Level.FINE, String.format("Action in frame %d: %s", 1, ((Forest)object).getClass()));

                    object.queueFree();
                    System.out.println("За ночь опали лепестки цветов на деревьях.");

                })
                .forAllChildren((tree) -> {
                    ((Tree)tree).dropFlowerPetals();
                }))
            .addChild(new SnorkAndMuminTrollSprites(new IntVector2(40, 10))
                .addAction(1, (obj) -> {
                    SnorkAndMuminTrollSprites instance = (SnorkAndMuminTrollSprites) obj;
                    LOGGER.log(Level.FINE, String.format("Action in frame %d: %s", 1, instance.getClass()));

                    instance.setSprite(SnorkAndMuminTrollSprites.SPRITE_2);
                    instance.setLocalPosition(new IntVector2(0, 0));
                })
                .addAction(2, (obj) -> {
                    SnorkAndMuminTrollSprites instance = (SnorkAndMuminTrollSprites) obj;

                    LOGGER.log(Level.FINE, String.format("Action in frame %d: %s", 2, instance.getClass()));

                    instance.setSprite(SnorkAndMuminTrollSprites.SPRITE_3);
                })
                    .addAction(3, (obj) -> {
                        obj.setActive(false);
                    }))
                .addChild(new Snork()
                    .addAction(
                    0, (obj) -> {
                        Snork instance = (Snork) obj;
                        LOGGER.log(Level.FINE, String.format("Action in frame %d: %s", 0, instance.getClass()));

                        instance.changeState(SnorkState.LOST_SPEECH, "на мгновение утратила дар речи.");
                    })
                    .addAction(1, (obj) -> {
                        Snork instance = (Snork) obj;
                        LOGGER.log(Level.FINE, String.format("Action in frame %d: %s", 1, instance.getClass()));

                        instance.changeState(SnorkState.LEANED_OVER, "наклонилась. И начала трясти Муми-тролля");

                    })
                    .addAction(2, (obj) -> {
                        Snork instance = (Snork) obj;
                        LOGGER.log(Level.FINE, String.format("Action in frame %d: %s", 2, instance.getClass()));

                        instance.changeState(SnorkState.HUGGING_AND_CRYING, "и Муми-Троль долго сидели прижавшись друг к другу.");
                        instance.reactToEnvironment(instance.getSceneTree().getEnvironment());


                    }))
                .addChild(new MuminTroll()
                    .addAction(2, (obj) -> {
                        MuminTroll instance = (MuminTroll) obj;

                        Environment currentEnvironment = obj.getSceneTree().getEnvironment();

                        instance.reactToEnvironment(currentEnvironment);

                    })
                    .addAction(3, (obj) -> {
                        Node foodBasket = null;

                        for (Node sibling : obj.getParentNode().getChildNodes())  {
                            if (sibling instanceof FoodBasket) {
                                foodBasket = sibling;
                                break;
                            }
                        }

                        if (foodBasket == null)
                            return;

                        foodBasket.queueMoveToChild(obj);

                        System.out.println("Наконец Муми-тролль встал и машинально снял с ветки корзинку с едой.");
                    }))

                .addChild(new Rain().addAction(1, (obj) -> {
                    ((Rain)obj).describe();
                    obj.getSceneTree().getEnvironment().addObject(EnvironmentProperties.RAIN);
                }))
                .addChild(new FoodBasket());

        currentSceneTree.sortDrawables();

        Renderer renderer = new Renderer(new IntVector2(16 * 5, 10 * 5), currentSceneTree, 4);

        renderer.render();
    }
}
