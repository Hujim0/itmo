package govnoParser;

import java.util.HashMap;

public abstract class EntityBuilder {

    HashMap<Class<?>, NonCompositeType<?>> nonCompositeTypeHashMap = new HashMap<>();

    public Serializable<?> createNewSerializableType(Class<?> clazz, String entityName) {
        nonCompositeTypeHashMap.get(clazz)
    }

}
