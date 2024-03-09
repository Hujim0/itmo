package govnoParser;

public abstract class NonCompositeType<T> extends Entity implements Serializable<T>{
    public NonCompositeType(String entityName, EntityBuilder builder) {
        super(entityName, builder);
    }

    public abstract static class LongType extends NonCompositeType<Long> {
        public LongType(String entityName, EntityBuilder builder) {
            super(entityName, builder);
        }
    }
}