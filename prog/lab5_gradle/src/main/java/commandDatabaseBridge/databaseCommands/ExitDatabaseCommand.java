package commandDatabaseBridge.databaseCommands;

import console.ConsoleProcessor;
import console.ExitCommand;

public class ExitDatabaseCommand extends ExitCommand {
    public ExitDatabaseCommand(ConsoleProcessor processor) {
        super(processor);
    }

    @Override
    public String getDescription() {
        return "Exists interactive mode WITHOUT SAVING.";
    }
}
