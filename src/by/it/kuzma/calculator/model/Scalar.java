package by.it.kuzma.calculator.model;

import by.it.kuzma.calculator.exceptions.CalcException;

public class Scalar extends Var {

    private final double value;

    public Scalar(String stringValue){
        value=Double.parseDouble(stringValue);
    }

    public Scalar(double value){
        this.value=value;
    }

    public Scalar(Scalar otherScalar){
        this.value=otherScalar.value;
    }

    public double getValue(){
        return this.value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar){
            return new Scalar(this.value + otherScalar.value);
        }else {
        return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar){
            return new Scalar(this.value - otherScalar.value);
        }else {
            return other.sub(this).mul(new Scalar(-1));
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar){
            return new Scalar(this.value * otherScalar.value);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar){
            if (otherScalar.value == 0){
                String message = String.format("division by zero %s / %s%n", this, other);
                throw new CalcException(message);
            }
            return new Scalar(this.value / otherScalar.value);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
