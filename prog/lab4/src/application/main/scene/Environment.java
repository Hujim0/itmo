package application.main.scene;

import application.extensions.EnvironmentEmptyException;
import application.main.scene.enums.EnvironmentObjectTypes;
import engine.scene.nodes.Node;
import lombok.Data;
import lombok.EqualsAndHashCode;
import application.main.scene.enums.EnvironmentTemperature;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Environment extends Node {

    private List<EnvironmentObjectTypes> objects = new ArrayList<>();

    private EnvironmentTemperature temperature;

    public Environment addObjects(EnvironmentTemperature temperature, EnvironmentObjectTypes...obj) {
        objects.addAll(List.of(obj));
        this.temperature = temperature;
        return this;
    }

    public Environment addObject(EnvironmentObjectTypes obj) {
        objects.add(obj);

        return this;
    }

    public String describeView() throws EnvironmentEmptyException {
        if (objects.size() == 0) {
            throw new EnvironmentEmptyException();
        }

        String out = "Вокруг видно: ";

        for (int i =0; i < objects.size(); i++) {
            out += objects.get(i).getDescription();
            if (i != objects.size() - 1) {
                out += ", ";
            }
        }

        return out;
    }
}
