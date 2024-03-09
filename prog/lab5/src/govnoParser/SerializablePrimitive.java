package govnoParser;

public abstract class SerializablePrimitive<T> implements Serializable<T> {
    public abstract T getValue(String stringValue);

    public abstract static class SerializableString extends SerializablePrimitive<String> {
        public SerializableString(String entityName) {
            super(entityName);
        }

        @Override
        public String getValue(String stringValue) {
            return stringValue;
        }
    }

    abstract class SerializableLong extends Entity implements SerializablePrimitive<Long> {
        public SerializableLong(String entityName) {
            super(entityName);
        }

        @Override
        public Long getValue(String stringValue) {
            return Long.parseLong(stringValue);
        }
    }

    abstract class SerializableFloat extends Entity implements SerializablePrimitive<Float> {
        public SerializableFloat(String entityName) {
            super(entityName);
        }

        @Override
        public Float getValue(String stringValue) {
            return Float.parseFloat(stringValue);
        }
    }

    abstract class SerializableInt extends Entity implements SerializablePrimitive<Integer> {
        public SerializableInt(String entityName) {
            super(entityName);
        }
        @Override
        public Integer getValue(String stringValue) {
            return Integer.parseInt(stringValue);
        }
    }

    abstract class SerializableDouble extends Entity implements SerializablePrimitive<Double> {
        public SerializableDouble(String entityName) {
            super(entityName);
        }
        @Override
        public Double getValue(String stringValue) {
            return Double.parseDouble(stringValue);
        }
    }

    abstract class SerializableEnum extends Entity implements SerializablePrimitive<Enum<?>> {

        private final Class<?> enumClass;
        public SerializableEnum(String entityName, Class<?> enumClass) {
            super(entityName);

            this.enumClass = enumClass;
        }

        @Override
        public Enum<?> getValue(String stringValue) {
            for (Enum<?> enums : enumClass.asSubclass(Enum.class).getEnumConstants()) {
                System.out.println(enums);
                if (enums.name().equals(stringValue)) {
                    return enums;
                }
            }

            return null;
        }
    }
}
