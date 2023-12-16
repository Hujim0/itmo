package Moves.Umbreon;

import ru.ifmo.se.pokemon.*;

public class DreamEater extends SpecialMove {

    public DreamEater(double pow, double acc) {
        super(Type.PSYCHIC, pow, acc);
    }

    @Override
    protected void applyOppDamage(Pokemon pokemon, double damage) {
        if (pokemon.getCondition() != Status.SLEEP) return;

        pokemon.setMod(Stat.HP, (int) Math.round(damage));
    }

    @Override
    protected void applySelfDamage(Pokemon pokemon, double damage) {
        pokemon.setMod(Stat.HP, -(int) Math.round(damage / 2));
    }

    @Override
    public String describe() {
        return "Umbreon eats the dreams of a sleeping target. It absorbs half the damage caused to heal the user’s HP.";
    }
}
