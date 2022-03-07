package by.it.kharevich.calculator.model;

import by.it.kharevich.calculator.exceptions.CalcException;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value.clone();
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value.clone();
    }

    public Vector(String strVector) {
        strVector = strVector.replaceAll("[{}]", "");
        String[] strVectorArr = strVector.split(",");
        this.value = new double[strVectorArr.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strVectorArr[i]);
        }
    }

    public double[] getValue() {
        return value.clone();
    }


    @Override
    public Var add(Var other) throws CalcException {
        double[] localValue = value.clone();
        if (other instanceof Scalar scalar) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] += scalar.getValue();
            }
            return new Vector(localValue);
        } else if (other instanceof Vector vector) {
            if (this.value.length == vector.value.length) {
                for (int i = 0; i < localValue.length; i++) {
                    localValue[i] += vector.value[i];
                }
                return new Vector(localValue);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[] localValue = value.clone();
        if (other instanceof Scalar scalar) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] -= scalar.getValue();
            }
            return new Vector(localValue);
        } else if (other instanceof Vector vector && this.value.length == vector.value.length) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] -= vector.value[i];
            }
            return new Vector(localValue);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        double[] localValue = value.clone();
        double sumLocalValue = 0;
        if (other instanceof Scalar scalar) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] *= scalar.getValue();
            }
            return new Vector(localValue);
        } else if (other instanceof Vector vector && this.value.length == vector.value.length) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] *= vector.value[i];
                sumLocalValue = sumLocalValue + localValue[i];
            }
            return new Scalar(sumLocalValue);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        double[] localValue = value.clone();
        if (other instanceof Scalar scalar && scalar.getValue() != 0) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] = localValue[i] / scalar.getValue();
            }
            return new Vector(localValue);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter = "";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter = ", ";
        }
        out.append("}");
        return out.toString();
    }
}
