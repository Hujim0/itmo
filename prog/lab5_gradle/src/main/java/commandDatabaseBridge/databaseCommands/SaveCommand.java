package commandDatabaseBridge.databaseCommands;

import commands.exceptions.CommandException;
import commands.nativeCommands.Command;
import database.DatabaseDecorator;

import java.io.IOException;

public class SaveCommand implements Command {

    private final DatabaseDecorator<?> decorator;

    public SaveCommand(DatabaseDecorator<?> decorator) {
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
        return null;
    }
}
