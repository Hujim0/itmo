package engine.structs;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpriteData {
    IntVector2 Resolution = new IntVector2(0,0);
    char[][] CurrentSprite = null;
}
