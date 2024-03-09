package parser.types.xml.primitives;

import parser.types.generic.SerializablePrimitive;
import parser.types.xml.XmlEntityBuilder;
import parser.types.xml.XmlHelper;

public abstract class XmlType<T> extends SerializablePrimitive<T> {
    @Override
    default String serialize(int indent, Object input) {
        StringBuilder builder = new StringBuilder();

        XmlHelper.AddOpeningTag(builder, indent, );
        builder.append(input);
        XmlHelper.AddClosingTagWithNewLine(builder, indent, getEntityName());

        return builder.toString();
    }

    @Override
    default T deserialize(String input) {
        return getValue(input);
    }

    class XmlTypeLong extends SerializablePrimitive.SerializableLong implements XmlType<Long> {
        public XmlTypeLong(String entityName) {
            super(entityName);
        }
    }
    class XmlTypeDouble extends SerializablePrimitive.SerializableDouble implements XmlType<Double> {
        public XmlTypeDouble(String entityName) {
            super(entityName);
        }
    }

    class XmlTypeInt extends SerializablePrimitive.SerializableInt implements XmlType<Integer> {
        public XmlTypeInt(String entityName) {
            super(entityName);
        }
    }

    class XmlTypeString extends SerializablePrimitive.SerializableString implements XmlType<String> {
        public XmlTypeString(String entityName) {
            super(entityName);
        }
    }

    class XmlTypeEnum extends SerializablePrimitive.SerializableEnum implements XmlType<Enum<?>> {
        public XmlTypeEnum(String entityName, Class<?> clazz) {
            super(entityName, clazz);
        }
    }
}
