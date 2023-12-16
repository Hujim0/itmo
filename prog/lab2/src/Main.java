import Pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        Pokemon togedemaru = new Togedemaru("togedemaru", 1);
        Pokemon eevee = new Eevee("eevee", 1);
        Pokemon umbreon = new Umbreon("umbreon", 1);
        Pokemon nidoranF = new NidoranF("nidoranF", 1);
        Pokemon nidorina = new Nidorina("nidorina", 1);
        Pokemon nidoqueen = new Nidoqueen("nidoqueen", 1);

        battle.addAlly(togedemaru);
        battle.addAlly(eevee);
        battle.addAlly(umbreon);

        battle.addFoe(nidoranF);
        battle.addFoe(nidorina);
        battle.addFoe(nidoqueen);

        battle.go();
    }
}
