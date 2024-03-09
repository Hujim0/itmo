package commandDatabaseBridge.databaseCommands;

import commands.CommandArgument;
import commands.exceptions.CommandException;
import commands.nativeCommands.OverloadedCommand;
import database.CollectionDatabase;
import database.DatabaseDecorator;

public class AddCommand<T> implements OverloadedCommand {

    DatabaseDecorator<T> database;

    public AddCommand(DatabaseDecorator<T> database) {
        this.database = database;

    }

    @Override
    public String execute(String args) throws CommandException {
        database.addElement(database.createElementFromInput());
        return "Done.";
    }

    @Override
    public String getDescription() {
        return "Adds a new element based on user's input.";
    }

    @Override
    public CommandArgument[] getArguments() {
        return new CommandArgument[] {
                new CommandArgument(
                        "element",
                        "If this argument is empty, element will be constructed based on user's input.\n" +
                                "Or command tries to construct element with signature: \n" + database.getConstructorSignature(), true)
        };
    }
}
