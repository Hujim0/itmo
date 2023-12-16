package Moves.Nidorina;

import ru.ifmo.se.pokemon.*;

public class Bite extends PhysicalMove {

    public Bite(double pow, double acc) {
        super(Type.DARK, pow, acc);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (new Effect().chance(0.3).success()) {
            Effect.flinch(pokemon);
        }
    }

    @Override
    protected String describe() {
        return "The target is bitten with viciously sharp fangs. It may make the target flinch.";
    }
}
