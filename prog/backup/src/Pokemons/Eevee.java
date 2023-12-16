package Pokemons;
import Moves.Eevee.*;
import Moves.Facade;
import ru.ifmo.se.pokemon.*;

public class Eevee extends Pokemon {
    public Eevee(String name, int level) {
        super(name, level);

        super.setType(Type.NORMAL);
        super.setStats(55, 55, 50, 45, 65, 55);

        Facade facade = new Facade(70, 100, this);
        ShadowBall shadowBall = new ShadowBall(80, 100);
        BabyDollEyes babyDollEyes = new BabyDollEyes(0, 100);

        super.setMove(facade, shadowBall, babyDollEyes);
    }
}