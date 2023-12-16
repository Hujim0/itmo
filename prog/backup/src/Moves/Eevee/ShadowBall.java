package Moves.Eevee;

import ru.ifmo.se.pokemon.*;

public class ShadowBall extends SpecialMove {

    public ShadowBall(double pow, double acc) {
        super(Type.GHOST, pow, acc);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.addEffect(new Effect().chance(0.2).stat(Stat.SPECIAL_DEFENSE, -1));
    }

    @Override
    public String describe() {
        return "Eevee hurls a shadowy blob at the target. It may also lower the target’s Sp. Def stat.";
    }
}
