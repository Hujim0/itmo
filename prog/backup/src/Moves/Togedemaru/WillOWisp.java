package Moves.Togedemaru;
import ru.ifmo.se.pokemon.*;

public class WillOWisp extends StatusMove {

    public WillOWisp(double dmg, double acc) {
        super(Type.FIRE, dmg, acc);
    }
    @Override
    public void applyOppEffects(Pokemon pokemon) {
        Effect.burn(pokemon);
    }

    @Override
    protected String describe() {
        return "Togedemaru shoots a sinister, bluish-white flame at the target to inflict a burn.";
    }
}
