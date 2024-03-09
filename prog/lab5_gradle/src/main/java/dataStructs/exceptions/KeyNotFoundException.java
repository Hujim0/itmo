package dataStructs.exceptions;

import dataStructs.exceptions.IllegalValueException;

public class KeyNotFoundException extends IllegalValueException {
    public KeyNotFoundException(String key) {
        super("The key \"" + key + "\" is not found.");
    }
}
