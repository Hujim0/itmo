package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import parser.adapters.DateDeserializer;
import parser.adapters.DateSerializer;
import parser.adapters.LocalDateDeserializer;
import parser.adapters.LocalDateSerializer;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Date;

public class JsonFileParser<T> extends FileParser<T> {
    private final Gson gson;
    private final Class<T> classToSerialize;
    public JsonFileParser(Path filePath,Class<T> classToSerialize) {
        super(filePath);
        this.classToSerialize = classToSerialize;

        gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())

                .setPrettyPrinting()
                .create();
    }

    @Override
    public T deserializeFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath().toString()))){

            return gson.fromJson(reader,classToSerialize);
        }
        catch (JsonSyntaxException | JsonIOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void serializeIntoFile(T type) throws IOException {
        try (FileWriter writer = new FileWriter(getFilePath().toString())) {
            writer.write(gson.toJson(type, classToSerialize));
        }
    }
}
