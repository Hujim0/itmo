package commandDatabaseBridge.databaseCommands;

import commands.CommandArgument;
import commands.exceptions.CommandException;
import commands.exceptions.IllegalCommandSyntaxException;
import commands.nativeCommands.OverloadedCommand;
import dataStructs.exceptions.IllegalValueException;
import database.Database;

public class AddIfMin<T> implements OverloadedCommand {

    private final Database<T> database;

    public AddIfMin(Database<T> database) {
        this.database = database;
    }

    @Override
    public String execute(String args) throws CommandException {
        try {
            if (!database.addIfMin(database.createElementFromInput())) {
                throw new CommandException("not found min!");
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalCommandSyntaxException(e.getMessage(),this);
        }

        return "";
    }

    @Override
    public String getDescription() {
        return "Compares the elements by Students count and add if the element you created has student count lower than any other element.";
    }

    @Override
    public CommandArgument[] getArguments() {
        return new CommandArgument[] {
                new CommandArgument("element", "element that would be added and compared.", false)
        };
    }
}
