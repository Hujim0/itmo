package Pokemons;
import Moves.Togedemaru.*;
import ru.ifmo.se.pokemon.*;

public class Togedemaru extends Pokemon {
    public Togedemaru(String name, int level) {
        super(name, level);

        super.setType(Type.ELECTRIC, Type.STEEL);
        super.setStats(65, 98, 63, 40, 73, 96);

        Bulldoze bulldoze = new Bulldoze(60, 100);
        Rest rest = new Rest(0, 0);
        WillOWisp willOWisp = new WillOWisp(0, 85);
        WorkUp workUp = new WorkUp(0, 0);

        super.setMove(bulldoze, rest, willOWisp, workUp);
    }
}
