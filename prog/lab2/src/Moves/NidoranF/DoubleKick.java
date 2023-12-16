package Moves.NidoranF;

import ru.ifmo.se.pokemon.*;

public class DoubleKick extends PhysicalMove {
    public DoubleKick(double pow, double acc) {
        super(Type.FIGHTING, pow, acc, 0, 2);
    }

    @Override
    public String describe() {
        return "The target is quickly kicked twice in succession using both feet.";
    }
}
