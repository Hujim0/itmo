package database;

import dataStructs.exceptions.IllegalValueException;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SimpleDatabase<T> extends DatabaseDecorator<T> {
    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void addElement(T element) {

    }

    @Override
    public String getAllElements() {
        return null;
    }

    @Override
    public void updateElementById(long id, T new_element) throws IllegalValueException {

    }

    @Override
    public void removeElementByKeyAndValue(String key, String value) throws IllegalValueException {

    }

    @Override
    public void clearCollection() {

    }

    @Override
    public void removeFirstElement() throws IllegalValueException {

    }

    @Override
    public int countElementsByKeyAndValue(Predicate predicate, String key, String value) throws IllegalValueException {
        return 0;
    }

    @Override
    public String getSortedElementsByKey(SortingOrder order, String key) throws IllegalValueException {
        return null;
    }

    @Override
    public String getConstructorSignature() {
        return null;
    }
}
