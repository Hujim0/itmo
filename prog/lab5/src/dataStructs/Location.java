package dataStructs;

import annotations.BuilderParameter;
import exceptions.ValueIsNullException;
import lombok.*;

@Data
@AllArgsConstructor
public class Location {
    @NonNull
    private Integer x; //Поле не может быть null
    @NonNull
    private Float y; //Поле не может быть null
    @NonNull
    private String name; //Поле может быть null

    public Location build(
            @BuilderParameter("x") Integer x,
            @BuilderParameter("y") Float y,
            @BuilderParameter("name") String name
    ) throws ValueIsNullException {
        if (x == null) {
            throw new ValueIsNullException(Location.class, "x");
        }

        return new Location(x,y,name);
    }
}