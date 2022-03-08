package by.it.kustova.calculator.model;

import by.it.kustova.calculator.exceptions.CalcException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    public Vector(double[] value) {
        this.value = value.clone();
    }

    private final double[] value;

    public double[] getValue() {
        return value.clone();
    }

    public Vector(String stringValue) {
        Pattern pattern = Pattern.compile("[\\d.?\\d]+");
        Matcher matcher = pattern.matcher(stringValue);
        String[] stringArray = {};
        while (matcher.find()) {
            String digit = matcher.group();
            stringArray = Arrays.copyOf(stringArray, stringArray.length + 1);
            stringArray[stringArray.length - 1] = digit;
        }
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        this.value = doubleArray;
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
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter = "";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter = ",";
        }
        out.append("}");
        return out.toString();
    }
}
