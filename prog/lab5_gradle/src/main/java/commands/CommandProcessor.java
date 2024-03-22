package commands;

import commands.nativeCommands.Command;
import commands.nativeCommands.ExecuteScriptCommand;
import commands.nativeCommands.HelpCommand;
import commands.exceptions.CommandDoesntExistsException;
import commands.exceptions.CommandException;
import commands.nativeCommands.HistoryCommand;
import lombok.Getter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        commands.put("execute_script", new ExecuteScriptCommand(this));
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

        Consumer<String> standardOutputLambda = standardOutput;
        Consumer<String> errorOutputLambda = errorOutput;

        String[] commandSplit = input.trim().split(" ", 2);

        String commandName = commandSplit[0];
        String commandArgs = "";

        if (commandSplit.length == 2) {
            commandArgs = commandSplit[1];
        }

        try {
            if (!commandArgs.contains(">")) {
                executeCommandWithArgs(commandName, commandArgs, standardOutputLambda, errorOutputLambda);
                return;
            }

            String[] argumentsSplit = commandArgs.split(">");

            commandArgs = argumentsSplit[0];

            String fileName = argumentsSplit[1];
            Path path = Path.of(fileName);
            try {
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
            } catch (IOException e) {
                errorOutput.accept("Can't create file! " + e.getMessage());
                return;
            }

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                if (commandArgs.endsWith("2")) {
                    commandArgs = commandArgs.substring(0, commandArgs.length() - 1);

                    errorOutputLambda = (line) -> {
                        try {
                            writer.write(line);
                        } catch (IOException e) {
                            throw new CommandException(e.getMessage());
                        }
                    };
                } else {
                    standardOutputLambda = (line) -> {
                        try {
                            writer.write(line);
                        } catch (IOException e) {
                            throw new CommandException(e.getMessage());
                        }
                    };
                }

                executeCommandWithArgs(commandName, commandArgs, standardOutputLambda, errorOutputLambda);
            }
        } catch (IOException e) {
            throw new CommandException(e.getMessage());
        }
    }

    private void executeCommandWithArgs(String commandName, String args, Consumer<String> out, Consumer<String> err) {
        try {
            if (!commands.containsKey(commandName)) {
                throw new CommandDoesntExistsException(commandName);
            }
            String output = commands.get(commandName).execute(args);
            if (output != null && !output.isBlank())
                out.accept(output);
        } catch (CommandException e) {
            err.accept(e.getMessage());
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
