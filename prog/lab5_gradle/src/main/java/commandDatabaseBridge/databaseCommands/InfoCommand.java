package commandDatabaseBridge.databaseCommands;

import commands.exceptions.CommandException;
import commands.nativeCommands.Command;
import database.DatabaseDecorator;

public class InfoCommand implements Command {
    DatabaseDecorator<?> database;
    public InfoCommand(DatabaseDecorator<?> database) {
        this.database = database;
    }

    @Override
    public String execute(String args) throws CommandException {
        return database.getInfo();
    }

    @Override
    public String getDescription() {
        return "Shows info about current collection.";
    }
}
