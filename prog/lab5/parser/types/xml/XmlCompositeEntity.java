package parser.types.xml;

import parser.types.generic.CompositeEntity;
//#FCF3EA

public class XmlCompositeEntity<T> extends CompositeEntity<T> {

    public String serialize(int indent, Object instance) {
        StringBuilder builder = new StringBuilder();

        XmlHelper.AddOpeningTagWithNewLine(builder, indent, entityName);

        for (String key : getChildGetters().keySet()) {

            try {
                Object objectToSerialize = getChildGetters().get(key).invoke(instance);

                builder.append(getChildTypes().get(key).serialize(indent + 4, objectToSerialize));
                builder.append("\n");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        XmlHelper.AddClosingTagWithNewLine(builder, indent, entityName);

        return builder.toString();
    }

    public T deserialize(String string) {

        return null;
    }

    public XmlCompositeEntity(Class<?> type, String entityName) {
        super(type, entityName);
    }
}