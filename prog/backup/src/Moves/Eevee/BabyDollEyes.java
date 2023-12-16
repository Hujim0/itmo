package Moves.Eevee;

import ru.ifmo.se.pokemon.*;

public class BabyDollEyes extends StatusMove {

    public BabyDollEyes(double pow, double acc) {
        super(Type.FAIRY, pow, acc);

        super.priority = 1;
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.ATTACK, -1);
    }

    @Override
    public String describe() {
        return "Eevee stares at the target with its baby-doll eyes, which lowers its Attack stat. This move always goes first.";
    }
}
