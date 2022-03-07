package by.it.kharevich.calculator.model;

import by.it.kharevich.calculator.exceptions.ApplicationException;
import by.it.kharevich.calculator.exceptions.CalcException;
import by.it.kharevich.calculator.resources.ResourceManager;
import by.it.kharevich.calculator.utils.ExceptionMessages;

public class Scalar extends Var {

    private final double value;

    public Scalar(String stringValue) {
        value = Double.parseDouble(stringValue);
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value + otherScalar.value);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException{ // 2-{1,2,3} ==> {1,2,3}-2
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value - otherScalar.value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value * otherScalar.value);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar) {
            if (otherScalar.value == 0) {
                String message = String.format(ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_2) + " %s / %s%n", this, other);
                throw new ApplicationException(message);
            }
            return new Scalar(this.value / otherScalar.value);
        }
        return super.add(other);
    }

    public double getValue() {
        return value;
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
