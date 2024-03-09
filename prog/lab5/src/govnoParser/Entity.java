package govnoParser;

public class Entity {
    protected final String entityName;
    protected final EntityBuilder builder;
    public Entity(String entityName, EntityBuilder builder) {
        this.entityName = entityName;
        this.builder = builder;
    }
}
