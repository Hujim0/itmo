package database;

import lombok.AllArgsConstructor;
import lombok.Data;
import parser.FileParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileDatabase<T> extends DatabaseDecorator<T>{
    private final FileParser<T> parser;

    public FileDatabase(FileParser<T> parser, Database<T> decoratedDatabase) {
        super(decoratedDatabase);

        this.parser = parser;
    }

    @Override
    public String getInfo() {
        StringBuilder builder = new StringBuilder(getDecoratedDatabase().getInfo());

        Path pathToFile = parser.getFilePath();

        if (!Files.exists(pathToFile)) {
            builder.append("\nFile problem: file doesn't exists.");

            return builder.toString();
        }

        BasicFileAttributes attributes = null;
        try {
            attributes = Files.readAttributes(pathToFile, BasicFileAttributes.class);
        } catch (IOException e) {
            builder.append("\nFile problem: ").append(e.getMessage());

            return builder.toString();
        }

        builder.append("Initialization date: ").append(attributes.creationTime())
                .append("Last update date: ").append(attributes.lastModifiedTime());

        return builder.toString();
    }

    public void saveToFile() {

    }

    public void ReadFromFile() {

    }
}
