package exceptions;

public class StringIsEmptyException extends Exception {

    public StringIsEmptyException(String s) {
        super(s);
    }
}
