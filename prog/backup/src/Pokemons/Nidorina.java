package Pokemons;

import Moves.Nidorina.Bite;
import ru.ifmo.se.pokemon.*;

public class Nidorina extends NidoranF {
    public Nidorina(String name, int level) {
        super(name, level);

        super.setType(Type.POISON);
        super.setStats(70, 62, 67, 55, 55, 56);

        Bite bite = new Bite(60, 100);

        addMove(bite);
    }
}
