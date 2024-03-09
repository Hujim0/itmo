package engine;

import annotations.Command;
import exceptions.IllegalCommandArgumentException;

public abstract class CommandProcessorDatabase extends CommandProcessor {
    public abstract void serializeDatabase();
    public abstract String getDatabaseInformation();
    public abstract void printDatabaseEntries();
    public abstract void updateElementById(String id, String element) throws IllegalCommandArgumentException;
    public abstract void clearDatabase();
    public abstract void removeElementBy(String id) throws IllegalCommandArgumentException;
    public abstract String getPossibleValues(String key) throws IllegalCommandArgumentException;
    public abstract void removeFirst() throws IllegalCommandArgumentException;
    public abstract void removeAllByValue(String key, String value) throws IllegalCommandArgumentException;
    public abstract String countElementsByPredicate(String predicate, String key, String value) throws IllegalCommandArgumentException;


    @Command(description = "Prints information about this database.")
    public void info() {
        System.out.println(getDatabaseInformation());
    }

    @Command(description = "Prints database entries.")
    public void show() {
        printDatabaseEntries();
    }

    @Command(description = "Add a new database entry.")
    public void add(String[] args) {
        System.out.println(args[0]);
    }

    @Override
    @Command(description = "Shuts down database without saving.")
    public void exit() {
        setRunning(false);
    }

    @Command(parametersDescription = {"{id}", "{element}"},
            description = "Update an element in collection by id.")
    public void update(String id, String element) throws IllegalCommandArgumentException{
        updateElementById(id, element);
    }
    @Command(parametersDescription = {"{id}"},
            description = "Remove an element in collection by id.")
    public void remove_by_id(String id) throws IllegalCommandArgumentException {
        removeElementBy(id);
    }

    @Command(description = "Delete all entries in database.")
    public void clear() {
        clearDatabase();
    }
    @Command(description = "Saves all current entries to original path.")
    public void save() {
        serializeDatabase();
    }
    @Command(description = "Deletes the first element")
    public void remove_first() throws IllegalCommandArgumentException{
        removeFirst();
    }
    @Command(parametersDescription = {"{key}", "{value}"},
            description = "Removes all entries that match given value. Get possible values by passing only key")
    public void remove_all_by(String key, String value) throws IllegalCommandArgumentException {

        removeAllByValue(key, value);
    }

    @Command(parametersDescription = {"{key}"},
            description = "Removes all entries that match given value. Get possible values by passing only key")
    public void remove_all_by(String key) throws IllegalCommandArgumentException {
        System.out.println("Possible values are: " + getPossibleValues(key));
    }

    @Command(parametersDescription = {"{greater_than|less_than|equals}","{key}", "{value}"},
            description = "Count all database entries based on a given key and all values of that key in the database.")
    public void count(String predicate, String key, String value) throws IllegalCommandArgumentException {
        System.out.println("There is " + countElementsByPredicate(predicate, key, value) + " elements by key: " + key + "that " + predicate + " than " + value);
    }
}
