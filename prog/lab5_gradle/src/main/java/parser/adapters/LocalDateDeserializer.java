package parser.adapters;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LocalDateDeserializer implements JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            return LocalDate.parse(jsonElement.getAsString());
        } catch (DateTimeParseException e) {
            throw new JsonParseException(e.getMessage());
        }
    }
}
