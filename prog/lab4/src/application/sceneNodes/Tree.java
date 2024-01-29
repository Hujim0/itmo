package application.sceneNodes;

import engine.Debug;
import lombok.AllArgsConstructor;
import engine.structs.IntVector2;
import application.extensions.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.logging.Level;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
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
        Debug.log(Level.FINEST, "Падают лепестки с дерева...");
    }
}
