package engine;

import annotations.Command;
import exceptions.CommandDoesntExistsException;
import exceptions.IllegalCommandArgumentException;
import exceptions.WrongCommandSyntaxException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Getter
public class CommandProcessor {

    public static final int MAX_HISTORY_COUNT = 11;

    @Setter(AccessLevel.PROTECTED)
    private boolean running = true;
    private final List<String> history = new ArrayList<>();

    public void addToHistory(String entry) {
        history.add(entry);

        if (history.size() > MAX_HISTORY_COUNT) {
            history.remove(0);
        }
    }

    public void beginCommandLoop() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to lab5 database! type \"help\"");

        while (isRunning()) {
            try {
                executeCommand(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getCommandSyntax(Method method, Command command) {
        StringBuilder out = new StringBuilder("\"" + method.getName());

        for (String parameterDescription : command.parametersDescription()) {
            out.append(" ").append(parameterDescription);
        }

        out.append("\"");
        return out.toString();
    }

    public static String getCommandSyntax(Class<? extends CommandProcessor> caller, String commandName) {
        StringBuilder out = new StringBuilder();

        for (Method method : caller.getMethods()) {
            if (!method.getName().equals(commandName)) {
                continue;
            }
            Command annotationCommand = method.getAnnotation(Command.class);

            if (annotationCommand == null) {
                continue;
            }
            if (!out.toString().isEmpty()) {
                out.append(" or ");
            }

            out.append(getCommandSyntax(method, annotationCommand));
        }

        return out.toString();
    }

    public void executeCommand(String input) throws CommandDoesntExistsException, WrongCommandSyntaxException {

        List<String> keywords = Arrays.stream(input.split(" "))
                .map(String::trim)
                .filter(arg -> !arg.isBlank())
                .collect(Collectors.toList());

        String commandName = keywords.get(0);
        keywords.remove(0);

        Class<?>[] types = new Class<?>[keywords.size()];

        Arrays.fill(types, String.class);

        try {
            Method commandMethod = this.getClass().getMethod(commandName, types);

            try {
                commandMethod.invoke(this, keywords.toArray());
                addToHistory(input);
            } catch (InvocationTargetException e) {
                System.out.println(e.getCause().getMessage());
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }

        } catch (NoSuchMethodException e) {
            for (Method method : this.getClass().getMethods()) {
                if (method.getName().equals(commandName)) {
                    throw new WrongCommandSyntaxException(this.getClass(), input, commandName);
                }
            }

            throw new CommandDoesntExistsException(input);
        }
    }

    @Command(description = "Prints all available commands, pass an argument to see description for given command.")
    public void help() {
        Arrays.stream(this.getClass().getMethods())
                .filter(method -> method.getAnnotation(Command.class) != null)
                .forEach(method -> {
                                        System.out.println(getCommandSyntax(method, method.getAnnotation(Command.class)));
                });
    }


    @Command(parametersDescription = {"{command_name}"},
            description = "Prints all available commands, pass an argument to see description for given command.")
    public void help(String data) throws IllegalCommandArgumentException {
        for (Method method : this.getClass().getMethods()) {
            Command commandAnnotation = method.getAnnotation(Command.class);

            if (commandAnnotation == null || !method.getName().equals(data)) {
                continue;
            }

            System.out.println(commandAnnotation.description());
            return;
        }

        throw new IllegalCommandArgumentException("Can't find help: command \"" + data + "\" doesn't exists.");
    }
    @Command(description = "Shuts down processor.")
    public void exit() {
        setRunning(false);
    }

    @Command(parametersDescription = {"{path}"},
            description = "Executes a script that contains commands for this processor line by line.")
    public void execute_script(String path) throws IllegalCommandArgumentException {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            reader.lines()
                    .filter(line -> !line.startsWith("#") && !line.isBlank())
                    .forEach(line -> {
                        try {
                            executeCommand(line);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    });
            System.out.println("...Done.");
        } catch (FileNotFoundException e) {
            throw new IllegalCommandArgumentException("File doesnt exists.");
        } catch (IOException e) {
            throw new IllegalCommandArgumentException(e.getMessage());
        }
    }

    @Command(description = "Prints out last 11 used commands.")
    public void history() {
        history.forEach((line) -> {
            System.out.println(line.split(" ")[0]);
        });
    }

    @Command(description = "Print out last 11 commands with command arguments")
    public void history_full() {
        history.forEach(System.out::println);
    }
}
