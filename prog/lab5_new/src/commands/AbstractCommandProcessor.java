package commands;

import commands.exceptions.CommandDoesntExistsException;
import commands.exceptions.CommandException;
import commands.nativeCommands.Command;
import commands.nativeCommands.HelpCommand;
import lombok.Getter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

/**
 * Class that handles an execution of a given command through HashMap, that on given string key, gives out a command instance.
 */
@Getter

public abstract class AbstractCommandProcessor {

    private final HashMap<String, Command> commands = new HashMap<>();
    /**
     * Tries to execute a command with given input.
     *
     * @param input command
     * @param standardOutput gets called when command don't throw any errors.
     * @param errorOutput gets called when something's wrong.
     */

    public abstract void executeCommand(String input, Consumer<String> standardOutput, Consumer<String> errorOutput);
}
