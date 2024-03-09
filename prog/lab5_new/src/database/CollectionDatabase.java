package database;

import dataStructs.exceptions.IllegalValueException;
import lombok.AllArgsConstructor;

import java.util.ArrayDeque;
import java.util.Collection;

@AllArgsConstructor
public class CollectionDatabase<T> extends DatabaseDecorator<T> {
    Collection<T> collection = new ArrayDeque<>();
    EntityBuilder<T> builder;
    @Override
    public String getInfo() {
        return "Type: " +
                collection.getClass().getSimpleName() +
                "\nNumber of entries: " +
                collection.size() +
                "\n";
    }

    public CollectionDatabase(Collection<T> collectionInstance, EntityBuilder<T> builder, Database<T> decoratedDatabase) {
        super(decoratedDatabase);
        collection =collectionInstance;
        this.builder = builder;
    }

    public String getAllElements() {
        StringBuilder builder = new StringBuilder();

        if (collection.isEmpty()) {
            builder.append("The database is currently empty.");
            return builder.toString();
        }

        collection.forEach(builder::append);

        return builder.toString();
    }

    public void addElement(T element) {
        collection.add(element);
    }

    @Override
    public T createElementFromString(String input) {
        return builder.buildFromString(input);
    }

    public void clearCollection() {
        collection.clear();
    }

    @Override
    public void removeElementByKeyAndValue(String key, String value) {

    }
}
