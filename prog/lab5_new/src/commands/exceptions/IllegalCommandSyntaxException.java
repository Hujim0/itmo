package commands.exceptions;

import commands.nativeCommands.Command;

public class IllegalCommandSyntaxException extends CommandException{
    /**
     * Wrong syntax exception. Generates a message with expected syntax.
     *
     * @param message exception massage.
     */
    public IllegalCommandSyntaxException(String message, Command command) {
        super(message + "\nExpected: " + command.getArgumentsSyntax());
    }
}
