package dataStructs.exceptions;

public class ValueIsNullException extends IllegalValueException {
    public ValueIsNullException(Class<?> clazz, String valueName) {
        super("Value \"" + valueName + "\" is null in " + clazz.getName());
    }

}
