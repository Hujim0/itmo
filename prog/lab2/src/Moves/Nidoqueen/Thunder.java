package Moves.Nidoqueen;

import ru.ifmo.se.pokemon.*;

public class Thunder extends SpecialMove {

    public Thunder(double pow, double acc) {
        super(Type.ELECTRIC, pow, acc);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (new Effect().chance(0.3).success()) {
            Effect.paralyze(pokemon);
        }
    }

    @Override
    protected String describe() {
        return "A wicked thunderbolt is dropped on the target to inflict damage. It may also leave the target with paralysis.";
    }
}
