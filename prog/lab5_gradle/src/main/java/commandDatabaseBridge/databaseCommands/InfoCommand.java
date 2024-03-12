package commandDatabaseBridge.databaseCommands;

import commands.exceptions.CommandException;
import commands.nativeCommands.Command;
import database.Database;

public class InfoCommand implements Command {
    Database<?> database;
    @Override
    public String execute(String args) throws CommandException {
        return database.getInfo();
    }

    public InfoCommand(Database<?> database) {
        this.database = database;
    }

    @Override
    public String getDescription() {
        return "Shows info about current collection.";
    }
}
