package exceptions;

public class CommandDoesntExistsException extends Exception {
    public CommandDoesntExistsException(String s) {
        super("Command \"" + s + "\" doesn't exists.");
    }

}
