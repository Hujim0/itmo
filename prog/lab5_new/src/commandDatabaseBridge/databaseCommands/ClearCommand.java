package commandDatabaseBridge.databaseCommands;

import commands.exceptions.CommandException;
import commands.nativeCommands.Command;
import database.DatabaseDecorator;

public class ClearCommand implements Command {
    private final DatabaseDecorator<?> decorator;

    public ClearCommand(DatabaseDecorator<?> decorator) {
        this.decorator = decorator;
    }

    @Override
    public String execute(String args) throws CommandException {
        decorator.clearCollection();
        return "";
    }

    @Override
    public String getDescription() {
        return "Clears out all entries in database.";
    }
}
