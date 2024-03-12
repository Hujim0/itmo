import commandDatabaseBridge.CommandDatabaseBridge;
import commands.AbstractCommandProcessor;
import commands.CommandProcessor;
import console.ConsoleProcessor;
import dataStructs.StudyGroup;
import dataStructs.StudyGroupList;
import database.*;
import parser.JsonFileParser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AbstractCommandProcessor processor = new CommandProcessor();
        ConsoleProcessor consoleProcessor = new ConsoleProcessor(processor);

        StudyGroupDatabase database = new StudyGroupDatabase(
                new EntityBuilder<>(
                        null,
                        () -> StudyGroup.createFromInput(new Scanner(System.in))),
                new JsonFileParser<>(Path.of(args[0]), StudyGroupList.class));

        new CommandDatabaseBridge<>(processor, database);

        consoleProcessor.startCommandLoop();
    }
}