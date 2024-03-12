package commandDatabaseBridge.databaseCommands;

import commands.exceptions.CommandException;
import commands.nativeCommands.Command;
import database.Database;

public class ClearCommand implements Command {
    private final Database<?> decorator;

    public ClearCommand(Database<?> decorator) {
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
