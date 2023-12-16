package Moves.Togedemaru;
import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {

    public Rest(double pow, double acc) {
        super(Type.PSYCHIC, pow, acc);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.restore();

        pokemon.addEffect(new Effect().turns(2).condition(Status.SLEEP));
    }

    @Override
    protected String describe() {
        return "Togedemaru goes to sleep for two turns. It fully restores the user’s HP and heals any status problem.";
    }
}
