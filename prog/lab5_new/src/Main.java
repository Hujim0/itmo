import commandDatabaseBridge.CommandDatabaseBridge;
import commands.AbstractCommandProcessor;
import commands.CommandProcessor;
import console.ConsoleProcessor;
import dataStructs.StudyGroup;
import database.*;
import parser.JsonFileParser;

import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        FileParser< StudyGroup> parser

        AbstractCommandProcessor processor = new CommandProcessor();
        ConsoleProcessor consoleProcessor = new ConsoleProcessor(processor);

        StudyGroupDatabase database = new StudyGroupDatabase(
                new FileDatabase<>(
                        new JsonFileParser<>(Path.of(args[0])),
                        new CollectionDatabase<>(
                                new ArrayDeque<>(),
                                new EntityBuilder<>(
                                        null,
                                        () -> StudyGroup.createFromInput(new Scanner(System.in))),
                                new SimpleDatabase<>()
                        )
                )
        );

//        System.out.println(database.getInfo());

        CommandDatabaseBridge<StudyGroup> bridge = new CommandDatabaseBridge<>(processor, database);

        consoleProcessor.startCommandLoop();


    }
}