package commandDatabaseBridge;

import commandDatabaseBridge.databaseCommands.*;
import commands.AbstractCommandProcessor;
import commands.CommandProcessor;
import console.ExitCommand;
import database.Database;
import database.DatabaseDecorator;

public class CommandDatabaseBridge<T> {
    CommandProcessor processor;
    DatabaseDecorator<T> database;

    public CommandDatabaseBridge(AbstractCommandProcessor processor, DatabaseDecorator<T> database) {
        processor.getCommands().put("info", new InfoCommand(database));
        ExitCommand command = (ExitCommand) processor.getCommands().get("exit");
        processor.getCommands().put("exit", new ExitDatabaseCommand(command.getProcessor()));
        processor.getCommands().put("add", new AddCommand<>(database));
        processor.getCommands().put("show", new ShowCommand(database));
        processor.getCommands().put("update", new UpdateCommand<>(database));
    }
}
