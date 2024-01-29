package engine.structs;

public enum EnvironmentTemperature {
    HOT_TEMPERATURE("Жарко"),
    WARM_TEMREATURE("Тепло"),
    COLD_TEMREATURE("Холодно");
    public final String description;
    EnvironmentTemperature(String description) {
        this.description = description;
    }
}
