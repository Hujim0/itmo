package parser.types.xml;

public class XmlHelper {
    public static void AddOpeningTagWithNewLine(StringBuilder builder, int indent, String entityName) {
        builder.append(" ".repeat(indent));
        builder.append("<");
        builder.append(entityName);
        builder.append(">\n");
    }

    public static void AddClosingTagWithNewLine(StringBuilder builder, int indent, String entityName) {
        builder.append(" ".repeat(indent));
        builder.append("</");
        builder.append(entityName);
        builder.append(">\n");
    }

    public static void AddOpeningTag(StringBuilder builder, int indent, String entityName) {
        builder.append(" ".repeat(indent));
        builder.append("<");
        builder.append(entityName);
        builder.append(">");
    }

    public static void AddClosingTag(StringBuilder builder, int indent, String entityName) {
        builder.append(" ".repeat(indent));
        builder.append("</");
        builder.append(entityName);
        builder.append(">");
    }
}
