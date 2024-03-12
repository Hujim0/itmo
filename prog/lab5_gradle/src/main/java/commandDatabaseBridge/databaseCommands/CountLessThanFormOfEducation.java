package commandDatabaseBridge.databaseCommands;

import commands.CommandArgument;
import commands.exceptions.CommandException;
import commands.exceptions.IllegalCommandSyntaxException;
import commands.nativeCommands.OverloadedCommand;
import dataStructs.FormOfEducation;
import database.Database;

import javax.xml.crypto.Data;
import java.util.Optional;

public class CountLessThanFormOfEducation implements OverloadedCommand {

    private final Database<?> database;

    public CountLessThanFormOfEducation(Database<?> database) {
        this.database = database;
    }

    @Override
    public String execute(String args) throws CommandException {
        try {
            Optional<Integer> res = database.CountLessThanFormOfEducation(FormOfEducation.valueOf(args));

            if (res.isEmpty()) {
                throw new CommandException("The database is empty!");
            }

            return res.get().toString();
        } catch (IllegalArgumentException e) {
            throw new IllegalCommandSyntaxException(e.getMessage(), this);
        }

    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public CommandArgument[] getArguments() {
        return new CommandArgument[] {
                new CommandArgument("DISTANCE_EDUCATION|FULL_TIME_EDUCATION|EVENING_CLASSES", "", false)
        };
    }
}
