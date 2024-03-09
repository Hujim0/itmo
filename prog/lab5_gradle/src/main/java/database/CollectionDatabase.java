package database;

import dataStructs.exceptions.IllegalValueException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayDeque;
import java.util.Collection;

@Getter
public class CollectionDatabase<T> extends DatabaseDecorator<T> {
    private final Collection<T> collection;
    private final EntityBuilder<T> builder;

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

        collection.forEach(instance -> {
            builder.append(instance).append("\n");
        });

        return builder.toString();
    }

    public void addElement(T element) {
        collection.add(element);
    }

    @Override
    public T createElementFromString(String input) {
        return builder.buildFromString(input);
    }

    @Override
    public T createElementFromInput() {
        return builder.buildFromInput();
    }


    public void clearCollection() {
        collection.clear();
    }

    @Override
    public void removeElementByKeyAndValue(String key, String value) {

    }
}
