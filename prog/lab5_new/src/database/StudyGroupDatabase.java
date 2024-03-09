package database;

import dataStructs.*;
import dataStructs.exceptions.IllegalValueException;
import dataStructs.exceptions.KeyNotFoundException;
import dataStructs.exceptions.NumberOutOfBoundsException;
import dataStructs.exceptions.ValueIsNullException;
import parser.FileParser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;

public class StudyGroupDatabase extends DatabaseDecorator<StudyGroup> {
    public Collection<StudyGroup> collection;

    public StudyGroupDatabase(DatabaseDecorator<StudyGroup> decorator) {
        super(decorator);
    }

    public void updateElementById( long id, StudyGroup new_element) throws IllegalValueException {
        for (StudyGroup group : collection) {
            if (group.getId() == id) {
                collection.remove(group);
                collection.add(new_element);
            }
        }
    }

    public void removeElementByKeyAndValue(String key, String value) throws IllegalValueException{

        Method getter = getGetterMethodByKey(key);

        collection.removeIf((studyGroup) -> {
            try {
                return getter.invoke(studyGroup, (Object[]) null).toString().equals(value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public int countElementsByKeyAndValue(Predicate predicate, String key, String value) throws KeyNotFoundException, ValueIsNullException, NumberOutOfBoundsException {
        Method getter = getGetterMethodByKey(key);

        if (!getter.getReturnType().isAssignableFrom(Comparable.class)) {
            throw new KeyNotFoundException("Can't compare by key " + key + ".");
        }

        int count = 0;

        for (StudyGroup studyGroup : collection) {
            int comparison = compareByKey(studyGroup, key,value);

            if (predicate == Predicate.LESS_THAN && comparison < 0) {
                count++;
            }
            else if (predicate == Predicate.GREATER_THAN && comparison > 0){
                count++;
            }
        }

        return count;
    }

    public String getSortedElementsByKey(SortingOrder order, String key) {
        return null;
    }

    public String getConstructorSignature() {
        return "(name: String, " +
                "coordinates: (x :double, y: double), " +
                "studentsCount: int, " +
                "averageMark: long, " +
                "formOfEducation: FormOfEducation, " +
                "semesterEnum: FormOfEducation, " +
                "groupAdmin: (name: String, " +
                            "birthday: String, " +
                            "nationality: Country, " +
                            "location: (x: int, y: float, name: String))";
    }

    public Method getGetterMethodByKey(String key) throws KeyNotFoundException {
        String getterMethodName = "get" + key.substring(0,1).toUpperCase() + key.substring(1);

        if (key.equals("class")) {
            throw new KeyNotFoundException(key);
        }

        try {
            return StudyGroup.class.getMethod(getterMethodName, (Class<?>[]) null);
        } catch (NoSuchMethodException e) {
            throw new KeyNotFoundException(key);
        }
    }

    public int compareByKey(StudyGroup element1, String key, String value) throws KeyNotFoundException, NumberOutOfBoundsException, ValueIsNullException {
        return element1.compareWithKey(key, value);
    }
}
