package engine;

import parser.types.generic.Serializable;
import exceptions.IllegalCommandArgumentException;
import lombok.Getter;

import java.util.ArrayDeque;

@Getter
public class ArrayDequeDatabase<T> extends CommandProcessorDatabase implements IDatabase {

    ArrayDeque<T> database = new ArrayDeque<>();
    public static Serializable<?> entity;

    public Serializable<?> getEntity() {
        return entity;
    }

    public ArrayDequeDatabase(Serializable<T> entity) {
        ArrayDequeDatabase.entity = entity;
    }
    @Override
    public void serializeDatabase() {
    }

    @Override
    public String getDatabaseInformation() {
        return "A java database with main collection ArrayDeque, contains " + database.size() + " elements";
    }

    @Override
    public void printDatabaseEntries() {
        for (T object : database) {
            System.out.println(object.toString());
        }
    }

    @Override
    public void updateElementById(String id, String element) throws IllegalCommandArgumentException {
    }

    @Override
    public void clearDatabase() {
        database.clear();
    }

    @Override
    public void removeElementBy(String id) throws IllegalCommandArgumentException {
        database.forEach((entry) -> {
        });
    }

    @Override
    public String getPossibleValues(String key) throws IllegalCommandArgumentException {
        return null;
    }

    @Override
    public void removeFirst() throws IllegalCommandArgumentException {

    }

    @Override
    public void removeAllByValue(String key, String value) throws IllegalCommandArgumentException {

    }

    @Override
    public String countElementsByPredicate(String predicate, String key, String value) throws IllegalCommandArgumentException {
        return null;
    }
}
