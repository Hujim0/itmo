package application.extensions;
import engine.structs.IntVector2;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpriteData {
    IntVector2 Resolution = new IntVector2(0,0);
    @ToString.Exclude
    char[][] CurrentSprite = null;
}
