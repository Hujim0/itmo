package application.extensions;

import engine.scene.Environment;
import engine.scene.EnvironmentEmptyException;
import engine.structs.EnvironmentObjectTypes;

public class FoggyForestEnvironment extends Environment {

    public String describeView() throws EnvironmentEmptyException {
        if (getEnvironmentObjects().isEmpty()) {
            throw new EnvironmentEmptyException();
        }

        String out = "Вокруг видно: ";

        for (int i = 0; i < getEnvironmentObjects().size(); i++) {
            out += getEnvironmentObjects().get(i).getDescription();
            if (i != getEnvironmentObjects().size() - 1) {
                out += ", ";
            }
        }

        return out;
    }
    public String describeViewFully() throws EnvironmentEmptyException {
        if (getEnvironmentObjects().isEmpty()) {
            throw new EnvironmentEmptyException();
        }

        if (getEnvironmentObjects().contains(EnvironmentObjectTypes.FOG)
                && getEnvironmentObjects().contains(EnvironmentObjectTypes.TREES)) {
            return "Между деревьями клубился туман, и чуть подальше уже ничего нельзя было разглядеть в его серой густой пелене. ";
        }

        throw new RuntimeException("Not implemented");
    }
}
