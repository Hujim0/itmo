package commandDatabaseBridge;

import commandDatabaseBridge.databaseCommands.*;
import commands.AbstractCommandProcessor;
import commands.CommandProcessor;
import console.ExitCommand;
import database.Database;

public class CommandDatabaseBridge<T> {
    CommandProcessor processor;
    Database<T> database;

    public CommandDatabaseBridge(AbstractCommandProcessor processor, Database<T> database) {
        processor.getCommands().put("info", new InfoCommand(database));
        ExitCommand command = (ExitCommand) processor.getCommands().get("exit");
        processor.getCommands().put("exit", new ExitDatabaseCommand(command.getProcessor()));
        processor.getCommands().put("add", new AddCommand<>(database));
        processor.getCommands().put("show", new ShowCommand(database));
        processor.getCommands().put("update", new UpdateCommandById<>(database));
        processor.getCommands().put("save", new SaveCommand(database));
        processor.getCommands().put("clear", new ClearCommand(database));
        processor.getCommands().put("remove_by_id", new RemoveById(database));
        processor.getCommands().put("add_if_min", new AddIfMin<>(database));
        processor.getCommands().put("remove_greater", new RemoveGreater(database));
        processor.getCommands().put("remove_lower", new RemoveLower(database));
        processor.getCommands().put("sum_of_average_mark", new SumOfAverageMark(database));
        processor.getCommands().put("print_descending", new PrintDescending(database));
        processor.getCommands().put("count_less_than_form_of_education", new CountLessThanFormOfEducation(database));
    }
}
