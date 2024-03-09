package dataStructs;

import dataStructs.exceptions.KeyNotFoundException;
import dataStructs.exceptions.NumberOutOfBoundsException;
import dataStructs.exceptions.ValueIsNullException;
import lombok.*;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Data
public class Coordinates implements Comparable<Coordinates>{
    private double x; //Значение поля должно быть больше -313
    private double y;

    final static String X_OUT_OF_BOUNDS_MESSAGE = "Value of X should equal or be greater than -313!";
    public static void checkX(double x) throws NumberOutOfBoundsException {
        if (x <= -313) {
            throw new NumberOutOfBoundsException(X_OUT_OF_BOUNDS_MESSAGE);
        }
    }

    public void setX(double x) throws NumberOutOfBoundsException {
        checkX(x);
        this.x = x;
    }

    public Coordinates(double x, double y){
        setX(x);
        setY(y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static Coordinates parse(String input) throws NumberOutOfBoundsException {
        String[] values = input.replace("(","")
                .replace( ")", "")
                .replace(" ", "")
                .split(",");

        return new Coordinates(Double.parseDouble(values[0]), Double.parseDouble(values[1]));
    }

    public int compareWithKey(String key, String value) throws NumberOutOfBoundsException, ValueIsNullException, KeyNotFoundException {
        if (key.equals("x")) {
            return Double.compare(getX(), Double.parseDouble(value));
        }
        else if (key.equals("y")) {
            return Double.compare(getY(), Double.parseDouble(value));
        }
        else if (key.isEmpty()) {
            return compareTo(Coordinates.parse(value));
        } else {
            throw new KeyNotFoundException(key);
        }
    }
    @Override
    public int compareTo(Coordinates o) {
        if (x > o.x) {
            return 1;
        }
        else if (x< o.x) {
            return -1;
        }

        if (y > o.y) {
            return 1;
        }
        else if (y< o.y) {
            return -1;
        }
        return 0;
    }

    public static double enterX(Scanner scanner) {
        System.out.println("Enter x coordinate: ");

        try {
            double x = Double.parseDouble(scanner.nextLine());

            checkX(x);

            return x;
        }
        catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        catch ( NumberOutOfBoundsException e) {
            System.err.println(X_OUT_OF_BOUNDS_MESSAGE);
        }

        return enterX(scanner);
    }

    public static double enterY(Scanner scanner) {
        System.out.println("Enter y coordinate: ");

        try {
            return Long.parseLong(scanner.nextLine());
        }
        catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        catch ( NumberOutOfBoundsException e) {
            System.err.println(X_OUT_OF_BOUNDS_MESSAGE);
        }

        return enterY(scanner);
    }

    public static Coordinates createFromInput(Scanner scanner) {
        System.out.println("Creating coordinates...");

        double x = enterX(scanner);
        double y = enterY(scanner);

        return new Coordinates(x,y);
    }
}