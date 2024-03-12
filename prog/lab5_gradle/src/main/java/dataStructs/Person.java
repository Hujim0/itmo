package dataStructs;
import dataStructs.exceptions.IllegalValueException;
import dataStructs.exceptions.NumberOutOfBoundsException;
import dataStructs.exceptions.StringIsEmptyException;
import lombok.Data;
import lombok.NonNull;

import java.time.*;
import java.util.Scanner;

@Data
public class Person {
    @NonNull
    private String name; //Поле не может быть null, Строка не может быть пустой
    private LocalDate birthday; //Поле может быть null
    private double weight; //Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 40, Длина строки должна быть не меньше 7, Поле не может быть null
    private Country nationality; //Поле может быть null

    private final static String NAME_IS_EMPTY_MESSAGE = "Name of the group admin can't be empty!";
    private final static String WIGHT_IS_OUT_OF_BOUNDS = "Weight can't be less than zero!";


    public static void checkName(String name)throws StringIsEmptyException  {
        if (name == null || name.isBlank()) {
            throw new StringIsEmptyException(NAME_IS_EMPTY_MESSAGE);
        }
    }
    public void setName(String name) {
        checkName(name);

        this.name = name;
    }

    public void setWeight(double weight) {
        checkWeight(weight);
        this.weight = weight;
    }

    private static void checkWeight(double weight) {
        if (weight <= 0) {
            throw new NumberOutOfBoundsException(WIGHT_IS_OUT_OF_BOUNDS);
        }
    }

    public static void checkPassportID(String passportID) {
        if (passportID == null) {
            throw new StringIsEmptyException("PassportID can't be null!");
        }
        if (passportID.length() < 7) {
            throw new IllegalValueException("PassportID should be longer than 6 characters!");
        }
        else if(passportID.length() >= 40) {
            throw new IllegalValueException("PassportID should be smaller than 40 characters!");

        }
    }
    public void setPassportID(String passportID) {
        checkPassportID(passportID);
        this.passportID = passportID;
    }

    public Person(String name, LocalDate birthday, double weight, String passportID, Country nationality) throws StringIsEmptyException {
        setName(name);
        setBirthday(birthday);
        setWeight(weight);
        setPassportID(passportID);
        setNationality(nationality);
    }

//    public int compareWithKey(String key, String value) throws ValueIsNullException, KeyNotFoundException {
//        if (key.equals("birthday")) {
//            return getBirthday().compareTo(LocalDate.parse(value));
//        }
//        else if (key.equals("location")) {
//            return getLocation().compareTo(Location.parse(value));
//        }
//        else if (key.equals("name") || key.isEmpty()) {
//            return getName().compareTo(value);
//        }
//        else {
//            throw new KeyNotFoundException(key);
//        }
//    }

    public static Person createFromInput(Scanner scanner) {
        return new Person(
                enterName(scanner),
                enterBirthday(scanner),
                enterWeight(scanner),
                enterPassportId(scanner),
                enterCounty(scanner));
    }

    public static String enterName(Scanner scanner) {
        System.out.println("Enter group admin name: ");

        try {
            String in = scanner.nextLine();
            checkName(in);

            return in;

        }
        catch (StringIsEmptyException e) {
            System.err.println(e.getMessage());
            return enterName(scanner);
        }
    }


    public static String enterPassportId(Scanner scanner) {
        System.out.println("Enter group admin passportID: ");

        try {
            String in = scanner.nextLine();
            checkPassportID(in);

            return in;

        }
        catch (IllegalValueException e) {
            System.err.println(e.getMessage());
            return enterPassportId(scanner);
        }
    }
    public static LocalDate enterBirthday(Scanner scanner) {
        System.out.println("Enter group admin birthday, ");

        System.out.println("Is null? (y/n)");
        if (scanner.nextLine().equals("y")) {
            return null;
        }

        try {
            System.out.println("year: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.println("month: ");
            int month = Integer.parseInt(scanner.nextLine());

            System.out.println("day: ");
            int day = Integer.parseInt(scanner.nextLine());


            return LocalDate.of(year, month, day);

        }
        catch (DateTimeException | NumberOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        return enterBirthday(scanner);
    }

    public static Country enterCounty(Scanner scanner) {
        System.out.println("Enter nationality of group admin: ");

        System.out.println("Is null? (y/n)");
        if (scanner.nextLine().equals("y")) {
            return null;
        }

        System.out.println("Choose one of following: " + StudyGroup.getEnumOptions(Country.class));

        try {
            String in = scanner.nextLine();
            return Country.valueOf(in);
        }
        catch (IllegalArgumentException e) {
            System.err.println("Country: " + e.getMessage());
            return enterCounty(scanner);
        }
    }

    public static double enterWeight(Scanner scanner) {
        System.out.println("Enter weight of group admin: ");
        try {
            double in = Double.parseDouble(scanner.nextLine());

            checkWeight(in);

            return in;
        }
        catch (NumberOutOfBoundsException e) {
            System.err.println(WIGHT_IS_OUT_OF_BOUNDS);
        }
        catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

        return enterWeight(scanner);
    }
}
