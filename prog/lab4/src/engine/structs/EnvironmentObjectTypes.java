package engine.structs;

import lombok.Getter;

public enum EnvironmentObjectTypes {
    TREES("Деревья"),
    FOG("Туман"),
    WATER("Вода"),
    RAIN("Дождь"),
    BUSHES("Кусты");
    @Getter
    final String description;
    EnvironmentObjectTypes(String description) {
        this.description = description;
    }


}
