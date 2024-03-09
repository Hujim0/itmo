package commandDatabaseBridge.databaseCommands;

import commands.CommandArgument;
import commands.exceptions.CommandException;
import commands.exceptions.IllegalCommandSyntaxException;
import commands.nativeCommands.OverloadedCommand;
import database.DatabaseDecorator;

public class RemoveByKeyAndValueCommand implements OverloadedCommand {

    private final DatabaseDecorator<?> decorator;

    public RemoveByKeyAndValueCommand(DatabaseDecorator<?> decorator) {
        this.decorator = decorator;
    }

    @Override
    public String execute(String args) throws CommandException {
        String[] argsSplit = args.split(" ");

        if (argsSplit.length == 2) {
            decorator.removeElementByKeyAndValue(argsSplit[0], argsSplit[1]);
        }
        else {
            throw new IllegalCommandSyntaxException("Wrong number of arguments.", this);
        }

        return "";
    }

    @Override
    public String getDescription() {
        return "Removes an element by given key and value.";
    }

    @Override
    public CommandArgument[] getArguments() {
        return new CommandArgument[] {
                new CommandArgument("key", "The key of an element that the value will be searched in", false),
                new CommandArgument("value", "The value of an given key that the founded element will be deleted.", false),

        };
    }
}
