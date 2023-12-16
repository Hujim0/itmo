package main.scene;

import lombok.AllArgsConstructor;
import main.Application;
import main.scene.nodes.SpriteNode;
import main.render.structs.IntVector2;
import main.render.structs.SpriteData;

import java.util.logging.Level;

@AllArgsConstructor
public class Tree extends SpriteNode {

    public Tree(IntVector2 position) {
        super(new SpriteData(
                new IntVector2(8,5), new char[][] {
                "   /\\   ".toCharArray(),
                "  /~~\\  ".toCharArray(),
                "  /~~\\  ".toCharArray(),
                " /____\\ ".toCharArray(),
                "   ||    ".toCharArray(),
        }));

        setLocalPosition(position);

    }

    public void dropFlowerPetals() {
        Application.LOGGER.log(Level.FINEST, "Падают лепестки с дерева...");
    }
}
