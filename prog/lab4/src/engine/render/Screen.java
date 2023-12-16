package engine.render;
import lombok.*;
import engine.structs.IntVector2;

@Getter
public class Screen {
    @Setter
    private IntVector2 resolution;

    private char[][] Canvas;

    private int Frame = 0;

    public Screen(IntVector2 resolution) {
        this.resolution = resolution;
        Canvas = new char[resolution.Y][resolution.X];
    }

    public void clear() {
        Canvas = new char[resolution.Y][resolution.X];

        for (int x = 0; x < resolution.X; x++) {
            for (int y = 0; y < resolution.Y; y++) {
                Canvas[y][x] = ' ';
            }
        }
    }

    public void updateFrameCounter() {
        Frame+=1;
    }
}
