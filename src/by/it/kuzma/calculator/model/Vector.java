package by.it.kuzma.calculator.model;

import by.it.kuzma.calculator.exceptions.CalcException;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] vale) {
        this.value = vale.clone();
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value.clone();
    }

    public Vector(String strVector) {
        strVector = strVector.replaceAll("[{}]", "");

        String[] arrVector = strVector.split(",");
        value = new double[arrVector.length];
        for (int i = 0; i < arrVector.length; i++) {
            value[i] = Double.parseDouble(arrVector[i]);
        }

    }

    public double[] getValue() {
        return value.clone();
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[] localValue = value.clone();
        if (other instanceof Scalar scalar){
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] += scalar.getValue();
            }
            return new Vector(localValue);

        } else if (other instanceof Vector vector){
            if (localValue.length == vector.value.length){
                for (int i = 0; i < localValue.length; i++) {
                    localValue[i]+=vector.value[i];
                }
                return new Vector(localValue);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[] localValue = value.clone();
        if (other instanceof Scalar scalar){
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] -= scalar.getValue();
            }
            return new Vector(localValue);

        } else if (other instanceof Vector vector){
            if (localValue.length == vector.value.length){
                for (int i = 0; i < localValue.length; i++) {
                    localValue[i]-=vector.value[i];
                }
                return new Vector(localValue);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        double[] localValue = value.clone();
        if (other instanceof Scalar scalar){
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] *= scalar.getValue();
            }
            return new Vector(localValue);

        } else if (other instanceof Vector vector){
            if (localValue.length == vector.value.length){
                double mulVector = 0;
                for (int i = 0; i < localValue.length; i++) {
                    mulVector += localValue[i] * vector.value[i];
                }
                return new Scalar(mulVector);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        double[] localValue = value.clone();
        if (other instanceof Scalar scalar) {
            if (scalar.getValue() != 0) {
                for (int i = 0; i < localValue.length; i++) {
                    localValue[i] /= scalar.getValue();
                }
                return new Vector(localValue);
            }
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter = "";
        for (double element : value){
            out.append(delimiter).append(element);
            delimiter = ", ";
        }
        out.append('}');
        return  out.toString();
    }
}
