package engine;

import parser.types.xml.XmlCompositeEntity;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class XmlDatabase<T extends XmlCompositeEntity> extends ArrayDequeDatabase<T> {

    private String filePath;
    private XmlCompositeEntity xmlDatabaseType;
    public final static String xmlVersion = "<?xml version='1.0'?>\n";

    @Override
    public void serializeDatabase() {
        try(FileWriter writer = new FileWriter(filePath)) {
            writer.write(xmlVersion);

            writer.write("<root>\n");

            for (T entry : database) {
                writer.write(" ".repeat(4) + "<item>");
                writer.write(entry.serialize(8, entry));
                writer.write("\n" + " ".repeat(4) + "</item>");
            }

            writer.write("\n</root>");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deserialize() {

        String fileContent = "";
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\code\\itmo\\prog\\lab5\\databaseFiles\\database.xml"))) {
            fileContent = reader.lines().map(String::trim).collect(Collectors.joining());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayDeque<String> tags = new ArrayDeque<>(Arrays.stream(fileContent.split("<")).toList());
        ArrayDeque<String> depthStack = new ArrayDeque<>();

        System.out.println(tags.removeFirst()); //empty string

        if (!tags.removeFirst().startsWith("?")) {
            throw new RuntimeException("Missing xml version tag");
        }

        XmlCompositeEntity type = (XmlCompositeEntity) getEntity();

        String root = tags.removeFirst().split(">")[0];
        depthStack.push(root);

//        type.deserialize(depthStack, tags);

//        while (!tags.peekFirst().equals("/" + root)) {
//            database.add((T)type.deserialize(depthStack, tags));
//        }

        System.out.println("no error");

//        do {
//            line = lines.removeFirst();
//            for (String tag :line.split("<")) {
//                String inner =tag.split(">")[1];
////                    String tag
//
//                if (tag.startsWith("/")) {
//                    if (!tag.equals(depthStack.removeLast())) {
//                        throw new RuntimeException();
//                    }
//                }
//
//                depthStack.push();
//            }
//        } while (!line.equals("item"));
//
//        depthStack.push();
//        depthStack.push("item");
//
//        while (depthStack.peekLast().equals("item")) {
//            database.push((T)type.deserialize(depthStack, lines));
//        }


    }

    public XmlDatabase(String filePath, T example) {
        super(example);
        this.filePath = filePath;
    }
}
