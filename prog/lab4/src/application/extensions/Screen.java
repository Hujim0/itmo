package application.extensions;
import lombok.*;
import engine.structs.IntVector2;

@Getter
public class Screen {
    @Setter
    private IntVector2 resolution;

    private char[][] canvas;

    public Screen(IntVector2 resolution) {
        this.resolution = resolution;
        canvas = new char[resolution.Y][resolution.X];

        clear();
    }

    public void clear() {
        canvas = new char[resolution.Y][resolution.X];

        for (int x = 0; x < resolution.X; x++) {
            for (int y = 0; y < resolution.Y; y++) {
                canvas[y][x] = ' ';
            }
        }
    }
}
