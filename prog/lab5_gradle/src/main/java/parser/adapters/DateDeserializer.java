package parser.adapters;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateDeserializer implements JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            return Date.from(Instant.parse(jsonElement.getAsString()));
        } catch (DateTimeParseException e) {
            throw new JsonParseException(e.getMessage());
        }
    }
}
