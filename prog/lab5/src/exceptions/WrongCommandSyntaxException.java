package exceptions;

import engine.CommandProcessor;

import java.lang.reflect.Method;

public class WrongCommandSyntaxException extends Exception {
    public WrongCommandSyntaxException(Class<? extends CommandProcessor> processor, String input, String command) {
        super("Wrong command syntax: \"" + input + "\".\nExpected: \"" + CommandProcessor.getCommandSyntax(processor, command) + "\".");

    }
}