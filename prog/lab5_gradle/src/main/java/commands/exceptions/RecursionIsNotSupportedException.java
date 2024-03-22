package commands.exceptions;

import java.util.Stack;
import java.util.stream.Collectors;

public class RecursionIsNotSupportedException extends CommandException{
    /**
     * Clears out stack trace.
     *
     *
     * @param message exception massage.
     */
    public RecursionIsNotSupportedException(String message, Stack<String> stackTrace) {
        super(message + "\n" +
                "   Stack trace:\n" +
                stackTrace.stream()
                        .map(line -> " ".repeat(8) + line + "\n")
                        .collect(Collectors.joining()));

        stackTrace.clear();
    }
}
