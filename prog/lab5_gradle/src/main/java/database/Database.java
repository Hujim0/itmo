package database;

import dataStructs.FormOfEducation;
import dataStructs.exceptions.IllegalValueException;

import java.util.Optional;

/**
 * interface for general-purpose database. Should be created with decorator.
 *
 * @param <T>
 */
public interface Database<T> {
    void removeGreater(long id);
    void removeLower(long id);

    long sumOfAverageMark();

    String getElementsDescending();

    Optional<Integer> CountLessThanFormOfEducation(FormOfEducation education);

    public enum Predicate {
        GREATER_THAN,
        LESS_THAN
    }
    public enum SortingOrder {
        ASCENDING,
        DESCENDING
    }

    String getInfo();
    void addElement(T element);
    T createElementFromInput();
    T createElementFromString(String input);
    String getAllElements();
    void updateElementById(long id, T new_element) throws IllegalValueException;
    boolean removeElementById(long id) throws IllegalValueException;
    void clearCollection();
    void removeFirstElement() throws IllegalValueException;
//    int countElementsByKeyAndValue(Predicate predicate, String key, String value) throws IllegalValueException;
    String getSortedElementsByKey(SortingOrder order, String key) throws IllegalValueException;
    String getConstructorSignature();
    boolean addIfMin(T element);

    void serialize() throws Exception;
    void deserialize() throws Exception;

}
