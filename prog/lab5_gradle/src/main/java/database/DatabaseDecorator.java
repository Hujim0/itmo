package database;

import dataStructs.exceptions.IllegalValueException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;


/**
 * Class that implements a decorator design pattern.
 *
 * @param <T> type that database holds.
 */
@AllArgsConstructor
@Getter
@Setter
public class DatabaseDecorator<T> implements Database<T>{
    private Database<T> decoratedDatabase;
    @Override
    public String getInfo() {
        return decoratedDatabase.getInfo();
    }

    @Override
    public void addElement(T element) {
        decoratedDatabase.addElement(element);
    }

    @Override
    public T createElementFromInput() {
        return decoratedDatabase.createElementFromInput();
    }

    @Override
    public T createElementFromString(String input) {
        return decoratedDatabase.createElementFromString(input);
    }

    @Override
    public String getAllElements() {
        return decoratedDatabase.getAllElements();
    }

    @Override
    public void updateElementById(long id, T new_element) throws IllegalValueException {
        decoratedDatabase.updateElementById(id, new_element);
    }

    @Override
    public void removeElementByKeyAndValue(String key, String value) throws IllegalValueException {
        decoratedDatabase.removeElementByKeyAndValue(key, value);
    }

    @Override
    public void clearCollection() {
        decoratedDatabase.clearCollection();
    }

    @Override
    public void removeFirstElement() throws IllegalValueException {
        decoratedDatabase.removeFirstElement();
    }

    @Override
    public int countElementsByKeyAndValue(Predicate predicate, String key, String value) throws IllegalValueException {
        return decoratedDatabase.countElementsByKeyAndValue(predicate,key,value);
    }

    @Override
    public String getSortedElementsByKey(SortingOrder order, String key) throws IllegalValueException {
        return decoratedDatabase.getSortedElementsByKey(order,key);
    }

    @Override
    public String getConstructorSignature() {
        return decoratedDatabase.getConstructorSignature();
    }

    @Override
    public void serialize() throws Exception {
        decoratedDatabase.serialize();
    }

    @Override
    public void deserialize() throws Exception {
        decoratedDatabase.deserialize();
    }

}
