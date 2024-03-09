package parser;

import dataStructs.exceptions.IllegalValueException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.StreamSupport;

@Data
@AllArgsConstructor
public abstract class FileParser<T> {
    private Path filePath;
    public abstract T deserializeFromFile();
    public abstract void serializeIntoFile(T type);

    public Integer parseInt(String input) throws IllegalValueException {
        for (char character : input.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new IllegalValueException("A number can't contain any characters!");
            }
        }

        return null;
    }
}
