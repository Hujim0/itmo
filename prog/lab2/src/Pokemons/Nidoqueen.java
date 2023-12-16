package Pokemons;

import Moves.Nidoqueen.Thunder;
import ru.ifmo.se.pokemon.Type;

public class Nidoqueen extends Nidorina {
    public Nidoqueen(String name, int level) {
        super(name, level);

        super.setType(Type.POISON, Type.GROUND);
        super.setStats(90, 92, 87, 75, 85, 76);

        Thunder thunder = new Thunder(110, 70);

        super.addMove(thunder);
    }
}
