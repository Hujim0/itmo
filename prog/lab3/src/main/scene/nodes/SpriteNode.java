package main.scene.nodes;

import lombok.*;
import main.render.Screen;
import main.render.structs.IntVector2;
import main.render.structs.SpriteData;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpriteNode extends DrawableNode {

    SpriteData sprite;

    public void renderToScreen(Screen screen) {
        if (!isVisible|| sprite == null) return;

        IntVector2 resolution = sprite.getResolution();
        IntVector2 screenBoundaries = screen.getResolution();

        IntVector2 globalPosition = getGlobalPosition();

        char[][] screenCanvas = screen.getCanvas();

        for (int x = 0; x < resolution.X; x++) {
            for (int y = 0; y < resolution.Y; y++) {
                char currentChar = sprite.getCurrentSprite()[y][x];

                if (currentChar == ' ') {
                    continue;
                }
                if (globalPosition.Y + y < 0 ||
                        globalPosition.X + x < 0 ||
                        globalPosition.Y + y >= screenBoundaries.Y ||
                        globalPosition.X + x >= screenBoundaries.X) {
                    continue;
                }

                screenCanvas[globalPosition.Y + y][globalPosition.X + x] = currentChar;
            }
        }
    }
}
