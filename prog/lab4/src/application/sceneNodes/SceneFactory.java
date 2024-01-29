package application.sceneNodes;

import application.characters.MuminTroll;
import application.characters.Snork;
import application.extensions.FoggyForestEnvironment;
import engine.scene.SceneTree;
import engine.structs.IntVector2;

public class SceneFactory {
    public static SceneTree createScene1() {
        SceneTree tree = new SceneTree();

        tree.setEnvironment(new FoggyForestEnvironment());

        tree.getRoot()
                .addChild(new ViewDescriber())
                .addChild(new Forest(new IntVector2(0, 0)))
                .addChild(new SnorkAndMuminTrollSprites(new IntVector2(40, 10)))
                .addChild(new Snork())
                .addChild(new MuminTroll())
                .addChild(new Rain())
                .addChild(new FoodBasket());

        return tree;
    }
}
