package database;

import dataStructs.*;
import dataStructs.exceptions.IllegalValueException;
import dataStructs.exceptions.KeyNotFoundException;
import dataStructs.exceptions.NumberOutOfBoundsException;
import dataStructs.exceptions.ValueIsNullException;
import lombok.Getter;
import parser.FileParser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.Date;

@Getter
public class StudyGroupDatabase extends CollectionDatabase<StudyGroup> {

    FileParser<StudyGroupList> parser;
    @Override
    public String getInfo() {


        StringBuilder builder = new StringBuilder(super.getInfo());

        Path pathToFile = parser.getFilePath();

        if (!Files.exists(pathToFile)) {
            builder.append("\nFile problem: file doesn't exists.");

            return builder.toString();
        }

        BasicFileAttributes attributes = null;
        try {
            attributes = Files.readAttributes(pathToFile, BasicFileAttributes.class);
        } catch (IOException e) {
            builder.append("\nFile problem: ").append(e.getMessage());

            return builder.toString();
        }

        builder.append("Initialization date: ").append(Date.from(attributes.creationTime().toInstant()))
                .append("\nLast update date: ").append(Date.from(attributes.lastModifiedTime().toInstant()));

        return builder.toString();
    }
    public StudyGroupDatabase(Collection<StudyGroup> collection, EntityBuilder<StudyGroup> builder, FileParser<StudyGroupList> parser, DatabaseDecorator<StudyGroup> decoratedDatabase) {

        super(collection, builder, decoratedDatabase);
        setDecoratedDatabase(this);
        this.parser = parser;

        try {
            deserialize();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateElementById( long id, StudyGroup new_element) throws IllegalValueException {
        if (getCollection().isEmpty()) {
            throw new IllegalValueException("Database is empty!");
        }



        for (StudyGroup group : getCollection()) {
            if (group.getId() == id) {


                getCollection().remove(group);
                getCollection().add(new_element);

                return;
            }
        }

        throw new IllegalValueException("Can't find an element with this id!");
    }

    public void removeElementByKeyAndValue(String key, String value) throws IllegalValueException{

        Method getter = getGetterMethodByKey(key);

        getCollection().removeIf((studyGroup) -> {
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

        for (StudyGroup studyGroup : getCollection()) {
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
//        return element1.compareWithKey(key, value);
        return 0;
    }

    public void serialize() throws IOException {
        parser.serializeIntoFile(new StudyGroupList(getCollection()));
    }

    public void deserialize() throws IOException {
        getCollection().addAll(parser.deserializeFromFile().getStudyGroupList());
    }
}
