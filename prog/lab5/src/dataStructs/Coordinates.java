package dataStructs;

import annotations.BuilderParameter;
import exceptions.NumberOutOfBoundsException;
import lombok.*;

@Data
public class Coordinates {
    private double x; //Значение поля должно быть больше -313
    private double y;

    public void setX(double x) throws NumberOutOfBoundsException {
        if (x <= -313) {
            throw new NumberOutOfBoundsException("значение X должно быть больше -313");
        }

        this.x = x;
    }

    public Coordinates(double x, double y) throws NumberOutOfBoundsException {
        setX(x);
        setY(y);
    }

    public Coordinates build (
        @BuilderParameter("x") double x,
        @BuilderParameter("y") double y
    )
    throws NumberOutOfBoundsException{
        return new Coordinates(x,y);
    }
}