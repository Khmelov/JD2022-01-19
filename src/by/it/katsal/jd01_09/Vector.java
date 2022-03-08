package by.it.katsal.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {


    private final double[] value;


    public Vector(double[] value) {
        this.value = value.clone();
    }


    public Vector(Vector otherVector){
        this.value = otherVector.value.clone();
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

    public double[] getValue() {
        return value.clone();
    }

    @Override
    public Var add(Var other) {
        double[] localValue = value.clone();
        if(other instanceof Scalar scalar){
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] += scalar.getValue();
            }
            return new Vector(localValue);
        }else if(other instanceof  Vector vector){
            if(this.value.length == vector.value.length){
                for (int i = 0; i < localValue.length; i++){
                    localValue[i] += vector.value[i];
                }
                return new Vector(localValue);
            }
        }

        return super.add(other);
    }


    @Override
    public Var sub(Var other) {
            double[] localValue = value.clone();
            if(other instanceof Scalar scalar){
                for (int i = 0; i < localValue.length; i++) {
                    localValue[i] -= scalar.getValue();
                }
                return new Vector(localValue);
            }else if(other instanceof  Vector vector){
                if(this.value.length == vector.value.length){
                    for (int i = 0; i < localValue.length; i++){
                        localValue[i] -= vector.value[i];
                    }
                    return new Vector(localValue);
                }
            }

            return super.sub(other);
        }

    @Override
    public Var mul(Var other) {
        double[] localValue = value.clone();
        if(other instanceof Scalar scalar){
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] *= scalar.getValue();
            }
            return new Vector(localValue);
        }else if(other instanceof  Vector vector){
            if(this.value.length == vector.value.length){
                int sum = 0;
                for (int i = 0; i < localValue.length; i++){
                        localValue[i] *= vector.value[i];
                        sum += localValue[i];
                }

                return new Scalar(sum);
            }
        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        double[] localValue = value.clone();
        if(other instanceof Scalar scalar){
            if(scalar.getValue() == 0) {
                System.out.printf("ERROR: division by zero %s / %s%n", this, other);
                return null;
            }
            else {
                for (int i = 0; i < localValue.length; i++) {
                    localValue[i] /= scalar.getValue();
                }
                return new Vector(localValue);
            }
        } else if (other instanceof Vector vector) {
            return super.div(other);
        }
        return super.div(other);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('{');
        String delimiter = "";
        for (double element : value) {
            builder.append(delimiter).append(element);
            delimiter=", ";
        }
        builder.append('}');
        return builder.toString();
        }
}


