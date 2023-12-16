import Pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        Battle battle = new Battle();
        Pokemon togedemaru = new Togedemaru("Тогедемару", 1);
        Pokemon eevee = new Eevee("Иви", 1);
        Pokemon umbreon = new Umbreon("Умбреон", 1);
        Pokemon nidoranF = new NidoranF("Нидоран", 1);
        Pokemon nidorina = new Nidorina("Нидорина", 1);
        Pokemon nidoqueen = new Nidoqueen("Нидокьин", 1);

        battle.addAlly(togedemaru);
        battle.addAlly(eevee);
        battle.addAlly(umbreon);

        battle.addFoe(nidoranF);
        battle.addFoe(nidorina);
        battle.addFoe(nidoqueen);

        battle.go();
    }
}