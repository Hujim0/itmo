package commandDatabaseBridge.databaseCommands;

import commands.CommandArgument;
import commands.exceptions.CommandException;
import commands.exceptions.IllegalCommandSyntaxException;
import commands.nativeCommands.OverloadedCommand;
import database.Database;

public class UpdateCommandById<T> implements OverloadedCommand {

    private final Database<T> database;

    public UpdateCommandById(Database<T> database) {
        this.database = database;
    }

    @Override
    public String execute(String args) throws CommandException {
        if (args.isBlank()) {
            throw new IllegalCommandSyntaxException("Arguments of the command update can't be empty!", this);
        }
        try {
            String[] argsSplit = args.split(" ", 2);

            long id = Long.parseLong(argsSplit[0]);


            if (argsSplit.length == 1) {
                database.updateElementById(id, database.createElementFromInput());

            }
            else if (argsSplit.length == 2) {
                database.updateElementById(id, database.createElementFromString(argsSplit[1]));
            }
            else {
                throw new IllegalCommandSyntaxException("Wrong number of parameters.", this);
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalCommandSyntaxException("Expected a number in {id}.", this);
        }

        return "";
    }

    @Override
    public String getDescription() {
        return "Updates the element based on it's ID, by creating a new element and replacing with an old one.";
    }

    @Override
    public CommandArgument[] getArguments() {
        return new CommandArgument[] {
                new CommandArgument("id", "The id of an element that will be replaced.", false),
                new CommandArgument("element", "element that will be replaced.", true)
        };
    }
}
