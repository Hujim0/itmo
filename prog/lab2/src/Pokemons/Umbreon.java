package Pokemons;

import Moves.Umbreon.DreamEater;
import ru.ifmo.se.pokemon.Type;

public class Umbreon extends Eevee {

    public Umbreon(String name, int level) {
        super(name, level);

        super.setType(Type.DARK);
        super.setStats(95, 65, 110, 60, 130, 65);

        DreamEater dreamEater = new DreamEater(100, 100);

        super.addMove(dreamEater);
    }
}
