package main.scene.enums;

public enum EnvironmentProperties {
    TREES("Деревья"),
    FOG("Туман"),
    WATER("Вода"),
    RAIN("Дождь"),
    BUSHES("Кусты");
    public final String description;
    EnvironmentProperties(String description) {
        this.description = description;
    }


}
