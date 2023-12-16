package Moves;

import ru.ifmo.se.pokemon.*;
import java.util.Set;

public class Facade extends PhysicalMove {

    static final Set<Status> doubleDamageConditions = Set.of(Status.BURN, Status.PARALYZE, Status.POISON);

    public Facade(double pow, double acc, Pokemon attackingPokemon) {
        super(Type.NORMAL, pow, acc);

        if (doubleDamageConditions.contains(attackingPokemon.getCondition())) {
            super.power = pow * 2;
        }
    }

    @Override
    public String describe() {
        return "An attack move that doubles its power if the user is poisoned, burned, or has paralysis.";
    }
}
