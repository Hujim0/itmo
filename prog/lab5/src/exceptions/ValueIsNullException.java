package exceptions;

import parser.Tag;

public class ValueIsNullException extends Exception{
    public ValueIsNullException(Class<?> clazz, String valueName) {
        super("Value \"" + valueName + "\" is null in " + clazz.getName());
    }

}
