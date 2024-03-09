package database;

import lombok.AllArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
public class EntityBuilder<T> {

    private builderFromString<T> builderFromString;
    private builderFromInput<T> builderFromInput;

    public T buildFromString(String input) {
        return builderFromString.build(input);
    }
    public T buildFromInput() {
        return builderFromInput.build();
    }

    @FunctionalInterface
    public interface builderFromString<T> {
        T build(String input);
    }

    @FunctionalInterface
    public interface builderFromInput<T> {
        T build();
    }
}
