package commandDatabaseBridge.databaseCommands;

import commands.CommandArgument;
import commands.exceptions.CommandException;
import commands.exceptions.IllegalCommandSyntaxException;
import commands.nativeCommands.OverloadedCommand;
import database.Database;

public class RemoveById implements OverloadedCommand {
    private final Database<?> database;

    public RemoveById(Database<?> database) {
        this.database = database;
    }

    @Override
    public String execute(String args) throws CommandException {
        try {
            if (!database.removeElementById(Long.parseLong(args.trim()))) {
                throw new CommandException("Element with this id is not found!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalCommandSyntaxException("{id} should be a number!", this);
        }

        return "";
    }

    @Override
    public String getDescription() {
        return "Finds an element with specified id and removes it.";
    }

    @Override
    public CommandArgument[] getArguments() {
        return new CommandArgument[] {
                new CommandArgument("id", "The id of an element that should be removed.", false)
        };
    }
}
