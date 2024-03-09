package dataStructs;
import dataStructs.exceptions.KeyNotFoundException;
import dataStructs.exceptions.NumberOutOfBoundsException;
import dataStructs.exceptions.StringIsEmptyException;
import dataStructs.exceptions.ValueIsNullException;
import database.DatabaseEntity;
import lombok.*;

import java.lang.reflect.Field;
import java.time.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

@Data
public class StudyGroup implements DatabaseEntity {

    private static int lastId;

    @Setter(AccessLevel.NONE)
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NonNull
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NonNull
    private Coordinates coordinates; //Поле не может быть null
    @NonNull
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @NonNull
    private Integer studentsCount; //Значение поля должно быть больше 0, Поле может быть null

    private long averageMark; //Значение поля должно быть больше 0
    private FormOfEducation formOfEducation; //Поле может быть null
    private Semester semesterEnum; //Поле может быть null
    private Person groupAdmin; //Поле может быть null

    final static String NAME_IS_EMPTY_MESSAGE = "Name of the group can't be empty!";
    final static String AVERAGE_MARK_OUT_OF_BOUNDS_MESSAGE = "Average mark should be greater than zero!";
    final static String STUDENT_COUNT_OUT_OF_BOUNDS_MESSAGE = "Student count should be greater than zero!";

    public static void checkName(String name) throws StringIsEmptyException {
        if (name == null || name.isBlank()) {
            throw new StringIsEmptyException(NAME_IS_EMPTY_MESSAGE);
        }
    }
    public void setName(String name) throws StringIsEmptyException {
        checkName(name);
        this.name = name;
    }


    public static void checkAverageMark(long value) throws NumberOutOfBoundsException{
        if (value <= 0) {
            throw new NumberOutOfBoundsException(AVERAGE_MARK_OUT_OF_BOUNDS_MESSAGE);
        }
    }
    public void setAverageMark(long value) throws NumberOutOfBoundsException {
        checkAverageMark(value);
        this.averageMark = value;
    }



    public static void checkStudentsCount(Integer value) throws NumberOutOfBoundsException {
        if (value == null || value <= 0) {
            throw new NumberOutOfBoundsException(STUDENT_COUNT_OUT_OF_BOUNDS_MESSAGE);
        }
    }
    public void setStudentsCount(Integer value) throws NumberOutOfBoundsException {
        checkStudentsCount(value);
        studentsCount = value;
    }



    public StudyGroup(String name, Coordinates coordinates, Integer studentsCount, long averageMark, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) throws StringIsEmptyException, NumberOutOfBoundsException {
        setName(name);
        setCoordinates(coordinates);
        setStudentsCount(studentsCount);
        setAverageMark(averageMark);
        setFormOfEducation(formOfEducation);
        setSemesterEnum(semesterEnum);
        setGroupAdmin(groupAdmin);

        setCreationDate(LocalDate.now());
        id = lastId++;
    }

    @Override
    public String toString() {
        String separator = ", ";

        return getId() + separator +
                getName() + separator +
                getCoordinates() + separator +
                getCreationDate() + separator +
                getStudentsCount() + separator +
                getAverageMark() + separator +
                getFormOfEducation() + separator +
                getSemesterEnum() + separator +
                getGroupAdmin();
    }


    public int compareWithKey(String key, String value) throws NumberOutOfBoundsException, ValueIsNullException, KeyNotFoundException {
        if (key.equals("averageMark")) {
            return Double.compare(getAverageMark(), Double.parseDouble(value));
        }
        else if(key.startsWith("coordinates")) {
            return getCoordinates().compareWithKey(key.replace("coordinates.", ""), value);
        }
        else if(key.equals("studentsCount")) {
            return Integer.compare(getStudentsCount(), Integer.parseInt(value));
        }
        else if (key.equals("id")) {
            return Long.compare(getId(), Long.parseLong(value));
        }
        else if(key.startsWith("groupAdmin")) {
            return getGroupAdmin().compareWithKey(key.replace("groupAdmin.", ""), value);
        }
        else {
            throw new KeyNotFoundException(key);
        }
    }

    public static StudyGroup createFromInput(Scanner scanner) {

        return new StudyGroup(
                enterName(scanner),
                Coordinates.createFromInput(scanner),
                enterStudentsCount(scanner),
                enterAverageMark(scanner),
                enterFormOfEducation(scanner),
                enterSemesterEnum(scanner),
                Person.createFromInput(scanner));
    }

    public static String enterName(Scanner scanner) {
        System.out.println("Enter name: ");

        try {
            String in = scanner.nextLine();
            checkName(in);

            return in;

        }
        catch (StringIsEmptyException e) {
            System.err.println(NAME_IS_EMPTY_MESSAGE);
        }

        return enterName(scanner);
    }

    public static int enterStudentsCount(Scanner scanner) {
        System.out.println("Enter students count (number): ");

        try {
            int in = Integer.parseInt(scanner.nextLine()) ;
            checkStudentsCount(in);

            return in;
        }
        catch (NumberOutOfBoundsException e) {
            System.err.println(STUDENT_COUNT_OUT_OF_BOUNDS_MESSAGE);
        }
        catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

        return enterStudentsCount(scanner);
    }

    public static long enterAverageMark(Scanner scanner) {
        System.out.println("Enter average mark (number): ");

        try {
            long in = Long.parseLong(scanner.nextLine());
            checkAverageMark(in);

            return in;
        }
        catch (NumberOutOfBoundsException e) {
            System.err.println(AVERAGE_MARK_OUT_OF_BOUNDS_MESSAGE);
        }
        catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

        return enterAverageMark(scanner);
    }

    public static String getEnumOptions(Class<? extends Enum<?>> clazz) {
        Iterator<? extends Enum<?>> iterator = Arrays.stream(clazz.getEnumConstants()).iterator();

        StringBuilder builder = new StringBuilder();

        while (iterator.hasNext()) {
            builder.append(iterator.next().name());
            if (iterator.hasNext()) {
                builder.append(" | ");
            }
        }

        return builder.toString();
    }

    public static FormOfEducation enterFormOfEducation(Scanner scanner) {
        System.out.println("Enter form of education: ");

        System.out.println("Choose one of following: " + getEnumOptions(FormOfEducation.class));

        try {
            String in = scanner.nextLine();
            return FormOfEducation.valueOf(in);
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return enterFormOfEducation(scanner);
        }
    }

    public static Semester enterSemesterEnum(Scanner scanner) {
        System.out.println("Enter semester: ");

        System.out.println("Choose one of following: " + getEnumOptions(Semester.class));

        try {
            String in = scanner.nextLine();
            return Semester.valueOf(in);
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return enterSemesterEnum(scanner);
        }
    }

    @Override
    public String getValues() {
        return toString();
    }

    @Override
    public String getHeaders() {
        return null;
    }
}