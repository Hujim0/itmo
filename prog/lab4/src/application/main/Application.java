package application.main;

import application.extensions.Screen;
import application.main.scene.SceneFactory;
import engine.Debug;
import engine.scene.SceneTree;
import engine.render.*;
import engine.scene.nodes.DrawableNode;
import engine.structs.*;
import engine.scene.nodes.Node;

import java.util.logging.Level;
/*
Деревья, туман, вода. А дома нет. Дом исчез, а их с Муми-троллем бросили на произвол судьбы.
На мгновение фрекен Снорк утратила дар речи. Затем, наклонившись, начала осторожно трясти Муми-тролля.
Кругом капало. Кап-кап-кап -- печально падали капли, разбиваясь о темную воду.
За ночь опали лепестки цветов на деревьях. Было холодно. Прижавшись друг к другу,
они долго сидели не двигаясь, фрекен Снорк тихо плакала, уткнувшись в перину.
Наконец Муми-тролль встал с постели и машинально снял с ветки корзинку с едой.
*/

public class Application {
    static SceneTree currentSceneTree = new SceneTree();
    static public void run() {

        Debug.LOGGER.setLevel(Level.INFO);

        System.out.println(new Node().hashCode());

        currentSceneTree = SceneFactory.createScene1();

        currentSceneTree.sortDrawables();
        Renderer renderer = new Renderer(5) {
            public void showSceneObjects() {
                Screen screen = new Screen(new IntVector2(15 * 5, 10 * 5));

                for (DrawableNode drawableNode : currentSceneTree.getDrawableNodesRenderQueue()) {
                    drawableNode.renderToScreen(screen);
                }

                for(int i = 0; i < screen.getResolution().Y; i++) {
                    String out = new String(screen.getCanvas()[i]);
                    if (out.isBlank()) {
                        continue;
                    }
                    System.out.println(out);
                }
            }
        };

        Debug.log(Level.FINEST, currentSceneTree.printTree());

        renderer.setCurrentSceneTree(currentSceneTree);

        renderer.render();
    }
}