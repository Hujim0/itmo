package Moves.Togedemaru;
import ru.ifmo.se.pokemon.*;

public class Bulldoze extends PhysicalMove {
    public Bulldoze(double pow, double acc) {
        super(Type.GROUND, pow, acc);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.SPEED, -1);
    }

    @Override
    protected String describe() {
        return "Togedemaru stomps down on the ground and attacks everything in the area. Hit Pokémon’s Speed stat is reduced.";
    }
}
