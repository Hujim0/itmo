package commandDatabaseBridge.databaseCommands;

import commands.CommandArgument;
import commands.exceptions.CommandException;
import commands.nativeCommands.OverloadedCommand;
import database.Database;

public class RemoveLower implements OverloadedCommand {

    private final Database<?> database;

    public RemoveLower(Database<?> decorator) {
        this.database = decorator;
    }

    @Override
    public String execute(String args) throws CommandException {

        try {
            database.removeLower(Integer.parseInt(args));
        }
        catch (NumberFormatException e) {
            throw new CommandException("id should be a number!");
        }


//        if (argsSplit.length == 2) {
////            decorator.removeElementById(argsSplit[0], argsSplit[1]);
//        }
//        else {
//            throw new IllegalCommandSyntaxException("Wrong number of arguments.", this);
//        }

        return "";


    }

    @Override
    public String getDescription() {
        return "Removes an element by given key and value.";
    }

    @Override
    public CommandArgument[] getArguments() {
        return new CommandArgument[] {
                new CommandArgument("id", "the id that all elements with greater id will be removed", false)
//                new CommandArgument("key", "The key of an element that the value will be searched in", false),
//                new CommandArgument("value", "The value of an given key that the founded element will be deleted.", false),

        };
    }
}
