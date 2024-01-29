package engine.scene;

import engine.structs.EnvironmentObjectTypes;
import engine.scene.nodes.Node;
import lombok.Data;
import lombok.EqualsAndHashCode;
import engine.structs.EnvironmentTemperature;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Environment extends Node {

    private List<EnvironmentObjectTypes> environmentObjects = new ArrayList<>();

    private EnvironmentTemperature temperature;

    public Environment addObjects(EnvironmentTemperature temperature, EnvironmentObjectTypes...obj) {
        environmentObjects.addAll(List.of(obj));
        this.temperature = temperature;
        return this;
    }

    public Environment addObject(EnvironmentObjectTypes obj) {
        environmentObjects.add(obj);

        return this;
    }

    public abstract String describeView() throws EnvironmentEmptyException;
    public abstract String describeViewFully() throws EnvironmentEmptyException;
}
