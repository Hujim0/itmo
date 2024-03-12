package commandDatabaseBridge.databaseCommands;

import commands.exceptions.CommandException;
import commands.nativeCommands.Command;
import database.Database;

public class SaveCommand implements Command {

    private final Database<?> decorator;

    public SaveCommand(Database<?> decorator) {
        this.decorator = decorator;
    }

    @Override
    public String execute(String args) throws CommandException {

        try {
            decorator.serialize();
        } catch (Exception e) {
            throw new CommandException(e.getMessage());
        }
        return "";
    }

    @Override
    public String getDescription() {
        return "Saves database to the file.";
    }
}
