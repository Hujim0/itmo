package dataStructs;
import annotations.BuilderParameter;
import exceptions.StringIsEmptyException;
import lombok.Data;
import lombok.NonNull;

import java.time.*;
@Data
public class Person {
    @NonNull
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NonNull
    private LocalDate birthday; //Поле может быть null
    @NonNull
    private Country nationality; //Поле может быть null
    @NonNull
    private Location location; //Поле не может быть null

    public void setName(String name) throws StringIsEmptyException {
        if (name == null || name.isBlank()) {
            throw new StringIsEmptyException("Имя не может быть пустым!");
        }

        this.name = name;
    }

    public Person(String name, LocalDate birthday, Country nationality, Location location) throws StringIsEmptyException {
        setName(name);
        setBirthday(birthday);
        setNationality(nationality);
        setLocation(location);
    }

    public Person build(
            @BuilderParameter("name") String name,
            @BuilderParameter("birthday") LocalDate birthday,
            @BuilderParameter("nationality") Country nationality,
            @BuilderParameter("location") Location location
    ) {
        try {
            return new Person(name, birthday, nationality, location);
        } catch (StringIsEmptyException e) {
            return null;
        }
    }
}
