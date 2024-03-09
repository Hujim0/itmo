package parser.types.xml;

import parser.types.generic.Serializable;
import parser.types.generic.EntityBuilder;
import parser.types.xml.primitives.XmlType;

public class XmlEntityBuilder implements EntityBuilder {
    public Serializable<?> createNewSerializableType(Class<?> clazz, String entityName) {
        if (clazz == Long.class || clazz == Long.TYPE) {
            return new XmlType.XmlTypeLong(entityName);

        } else if (clazz == Double.class || clazz == Double.TYPE) {
            return new XmlType.XmlTypeDouble(entityName);

        } else if (clazz == Integer.class || clazz == Integer.TYPE) {
            return new XmlType.XmlTypeInt(entityName);

        } else if (clazz == String.class) {
            return new XmlType.XmlTypeString(entityName);
        }
        else if (clazz.isEnum()) {

            return new XmlType.XmlTypeEnum(entityName, clazz);
//            return null;
        }
        else {
            return new XmlCompositeEntity<>(clazz, entityName);
        }
    }
}
