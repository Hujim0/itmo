package Moves.Togedemaru;

import ru.ifmo.se.pokemon.*;

public class WorkUp extends StatusMove {

    public WorkUp(double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.ATTACK, 1);
        pokemon.setMod(Stat.SPECIAL_ATTACK, 1);
    }

    @Override
    protected String describe() {
        return "Togedemaru is roused, and its Attack and Sp. Atk stats increase.";
    }
}
