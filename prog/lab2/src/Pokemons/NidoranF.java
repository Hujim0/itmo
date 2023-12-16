package Pokemons;

import Moves.Facade;
import Moves.NidoranF.DoubleKick;
import ru.ifmo.se.pokemon.*;

public class NidoranF extends Pokemon {

    public NidoranF(String name, int level) {
        super(name, level);

        super.setType(Type.POISON);
        super.setStats(55, 47, 52, 40, 40, 41);

        Facade facade = new Facade(70, 100, this);
        DoubleKick doubleKick = new DoubleKick(30, 100);

        super.setMove(facade, doubleKick);
    }
}
