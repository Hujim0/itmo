package main.scene;

import lombok.Getter;
import main.scene.enums.EnvironmentProperties;
import main.scene.enums.EnvironmentTemperature;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Environment {
    private List<EnvironmentProperties> objects = new ArrayList<>();

    private EnvironmentTemperature temperature;

    public Environment addObjects(EnvironmentTemperature temperature, EnvironmentProperties...obj) {
        objects.addAll(List.of(obj));
        this.temperature = temperature;
        return this;
    }

    public Environment addObject(EnvironmentProperties obj) {
        objects.add(obj);

        return this;
    }

    public String describeView() {
        String out = "Вокруг видно: ";

        for (int i =0; i < objects.size(); i++) {
            out += objects.get(i).description;
            if (i != objects.size() - 1) {
                out += ", ";
            }
        }

        return out;
    }
}
