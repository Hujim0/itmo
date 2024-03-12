package commands;

import commands.nativeCommands.Command;
import commands.nativeCommands.HelpCommand;
import commands.exceptions.CommandDoesntExistsException;
import commands.exceptions.CommandException;
import commands.nativeCommands.HistoryCommand;
import lombok.Getter;

import java.util.*;
import java.util.function.Consumer;

/**
 * Class that handles an execution of a given command through HashMap, that on given string key, gives out a command instance.
 * Stores history of 11 last commands.
 */
@Getter
public class CommandProcessor extends AbstractCommandProcessor{

    public CommandProcessor() {
        commands.put("help", new HelpCommand(this));
        commands.put("history", new HistoryCommand(this));
    }
    private final HashMap<String, Command> commands = new HashMap<>();

    public static final int HISTORY_LENGTH = 11;

    private final ArrayDeque<String> history = new ArrayDeque<>(HISTORY_LENGTH);

    /**
     * Tries to execute a command with given input.
     *
     * @param input command
     * @param standardOutput gets called when command don't throw any errors.
     * @param errorOutput gets called when something's wrong.
     */

    public void executeCommand(String input, Consumer<String> standardOutput, Consumer<String> errorOutput) {

        String[] commandSplit = input.trim().split(" ", 2);

        String commandName = commandSplit[0];
        String commandArgs = "";
        if (commandSplit.length == 2) {
            commandArgs = commandSplit[1];
        }

        try {
            if (!commands.containsKey(commandName)) {
                throw new CommandDoesntExistsException(commandName);
            }
            String output = commands.get(commandName).execute(commandArgs);
            if (output != null && !output.isBlank())
                standardOutput.accept(output);
        } catch (CommandException e) {
            errorOutput.accept(e.getMessage());
        }

        if (history.size() == HISTORY_LENGTH) {
            history.removeFirst();
        }

        history.add(commandName);
    }

    public void executeCommands(Scanner scanner, Consumer<String> standardOutput, Consumer<String> errorOutput) {
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isBlank() || line.startsWith("#")) {
                continue;
            }

            executeCommand(scanner.nextLine(), standardOutput, errorOutput);
        }
    }


}
