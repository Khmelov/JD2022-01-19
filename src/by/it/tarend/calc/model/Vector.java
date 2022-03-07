package by.it.tarend.calc.model;

import by.it.tarend.calc.exceptions.CalcException;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value.clone();
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value.clone();
    }

    public Vector(String strVector) {
        String[] vector = strVector.replaceAll("[/{/}]", "").split(",");
        double[] value = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            value[i] = Double.parseDouble(vector[i]);
        }
        this.value = value.clone();
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[] localValue = value.clone();
        if (other instanceof Scalar otherScalar) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] += otherScalar.getValue();
            }
            return new Vector(localValue);
        } else if (other instanceof Vector otherVector) {
            if (this.value.length == otherVector.value.length) {
                for (int i = 0; i < localValue.length; i++) {
                    localValue[i] += otherVector.value[i];
                }
                return new Vector(localValue);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[] localValue = value.clone();
        if (other instanceof Scalar otherScalar) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] -= otherScalar.getValue();
            }
            return new Vector(localValue);
        } else if (other instanceof Vector otherVector) {
            if (this.value.length == otherVector.value.length) {
                for (int i = 0; i < localValue.length; i++) {
                    localValue[i] -= otherVector.value[i];
                }
                return new Vector(localValue);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        double[] localValue = value.clone();
        if (other instanceof Scalar otherScalar) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] *= otherScalar.getValue();
            }
            return new Vector(localValue);
        } else if (other instanceof Vector otherVector) {
            if (localValue.length == otherVector.value.length) {
                double result = 0.0;
                for (int i = 0; i < localValue.length; i++) {
                    result += localValue[i] * otherVector.value[i];
                }
                return new Scalar(result);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        double[] localValue = value.clone();
        if (other instanceof Scalar otherScalar) {
            if (otherScalar.getValue() != 0) {
                for (int i = 0; i < localValue.length; i++) {
                    localValue[i] /= otherScalar.getValue();
                }
                return new Vector(localValue);
            }
        }
        return super.div(other);
    }

    public double[] getValue() {
        return value.clone();
    }

    @Override
    public String toString() {
        StringBuilder outPut = new StringBuilder();
        String delimiter = "";
        outPut.append("{");
        for (double element : value) {
            outPut.append(delimiter).append(element);
            delimiter = ",";
        }
        outPut.append("}");
        return outPut.toString();
    }
}
