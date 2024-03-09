package console;

import commands.exceptions.CommandException;
import commands.exceptions.IllegalCommandSyntaxException;

public class ExitCommand extends ConsoleAwareCommand {
    public ExitCommand(ConsoleProcessor processor) {
        super(processor);
    }
    @Override
    public String execute(String args) throws CommandException {
        if (!args.isBlank()) {
            throw new IllegalCommandSyntaxException("Exit command expects no arguments.", this);
        }

        getProcessor().setRunning(false);
        return "exiting...";
    }

    @Override
    public String getDescription() {
        return "exists the program.";
    }
}
