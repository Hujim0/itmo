package console;

import commands.AbstractCommandProcessor;
import commands.CommandProcessor;
import lombok.Data;

import java.util.Scanner;
import java.util.function.Consumer;

@Data
public class ConsoleProcessor {

    boolean isRunning = true;

    private final AbstractCommandProcessor commandProcessor;

    public ConsoleProcessor(AbstractCommandProcessor commandProcessor) {

        this.commandProcessor = commandProcessor;

        commandProcessor.getCommands().put("exit", new ExitCommand(this));
    }

    /**
     * Starts a while loop until user writes "exit" command.
     */
    public void startCommandLoop() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type \"help\" to see available commands.");

        while (isRunning) {
            commandProcessor.executeCommand(
                    scanner.nextLine(),
                    System.out::println,
                    System.err::println);
        }
    }




}
