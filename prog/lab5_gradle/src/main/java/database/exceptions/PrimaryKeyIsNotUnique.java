package database.exceptions;

public class PrimaryKeyIsNotUnique extends RuntimeException{

    public PrimaryKeyIsNotUnique(String s) {
        super(s);
    }
}
