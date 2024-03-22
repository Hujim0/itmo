package commands.exceptions;

public class CommandException extends RuntimeException {
    /**
     * General exception for all command commands.dataStructs.exceptions.
     * @param message exception massage.
     */
    public CommandException(String message) {
        super(message);
    }
}
