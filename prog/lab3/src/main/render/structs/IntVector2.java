package main.render.structs;

import lombok.*;

@ToString(includeFieldNames = true)
@AllArgsConstructor
public class IntVector2 {
    public int X;
    public int Y;


    public IntVector2 plus(IntVector2 other) {
        return new IntVector2(this.X + other.X, this.Y + other.Y);
    }
    public boolean equals(IntVector2 other) {
        return this.X == other.X && this.Y == other.Y;
    }
}
