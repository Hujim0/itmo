package commandDatabaseBridge.databaseCommands;

import commands.exceptions.CommandException;
import commands.exceptions.IllegalCommandSyntaxException;
import commands.nativeCommands.Command;
import database.Database;

public class SumOfAverageMark implements Command {
    private final Database<?> database;

    public SumOfAverageMark(Database<?> database) {
        this.database = database;
    }

    @Override
    public String execute(String args) throws CommandException {
        if (!args.isBlank()) {
            throw new IllegalCommandSyntaxException("The arguments should be empty.", this);
        }
        return Long.toString(database.sumOfAverageMark());
    }

    @Override
    public String getDescription() {
        return null;
    }
}
