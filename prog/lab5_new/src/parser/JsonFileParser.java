package parser;

import java.nio.file.Path;

public class JsonFileParser<T> extends FileParser<T> {
    public JsonFileParser(Path filePath) {
        super(filePath);
    }

    @Override
    public T deserializeFromFile() {
        return null;
    }

    @Override
    public void serializeIntoFile(T type) {

    }
}
