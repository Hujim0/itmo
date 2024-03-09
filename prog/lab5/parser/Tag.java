package parser;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class Tag {

    private List<Tag> childTags = new ArrayList<>();

    private String key;

    private String stringValue;

    private ValueType type;

    public Integer tryParseInt() {
        return Integer.valueOf(stringValue);
    }
    public Double tryParseDouble() {
        return Double.valueOf(stringValue);
    }
    public Long tryParseLong() {
        return Long.valueOf(stringValue);
    }

    public <T> T as(Class<? extends T> clazz) {
        if (clazz.isAssignableFrom(Number.class)) {
            if (clazz == Integer.class) {
                return (T)Integer.valueOf(stringValue);
            }
            else if (clazz == Long.class) {
                return (T)Long.valueOf(stringValue);
            }
            else if (clazz == Double.class) {
                return (T)Double.valueOf(stringValue);
            }
            else {
                throw new RuntimeException("Can't parse \"" + stringValue + "\" to " + clazz.getName());
            }
        }
        else if (clazz == String.class) {
            return (T)stringValue;
        }
//        else if (clazz.isAssignableFrom(SerializableObject.class)) {
//            return SerializableObject::de
//        }
        return null;
    }
    public enum ValueType {
        NUMBER,
        STRING,
        OBJECT;
    }
}
