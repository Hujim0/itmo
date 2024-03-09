package commands.nativeCommands;

import commands.exceptions.CommandException;

public interface Command {
    String execute(String args) throws CommandException;
    String getDescription();

    default String getArgumentsSyntax() {
        return "no arguments.";
    }
}
