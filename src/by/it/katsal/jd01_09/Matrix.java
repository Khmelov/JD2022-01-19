package by.it.katsal.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var{


    private final double[][] value;


    public Matrix(double[][] value) {
        this.value = value.clone();
    }


    public Matrix(Matrix otherMatrix){
        this.value = otherMatrix.value.clone();
    }


    public Matrix(String stringValue) {
        int lines = 0;
        Pattern patternColumns = Pattern.compile("[\\{]+");
        Matcher matcher1 = patternColumns.matcher(stringValue);
        while (matcher1.find()) {
            lines++;
        }

        Pattern patternLines = Pattern.compile("[\\d.?\\d]+");
        Matcher matcher2 = patternLines.matcher(stringValue);
        String[] stringArray = {};

        while (matcher2.find()) {
            String digit = matcher2.group();
            stringArray = Arrays.copyOf(stringArray, stringArray.length + 1);
            stringArray[stringArray.length - 1] = digit;
        }

        int linesLength = stringArray.length / lines;
        double[][] doubleMatrix = new double[lines][linesLength];
        for (int i = 0, digitPosition = 0; i < doubleMatrix.length; i++) {
            for (int j = 0; j < linesLength; j++) {
                doubleMatrix[i][j] = Double.parseDouble(stringArray[digitPosition]);
                digitPosition++;
            }
        }

        this.value = doubleMatrix;
    }

    public double[][] getValue() {
        double[][] localValue =  new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                localValue[i][j] = value[i][j];
            }
        }

        return localValue;
    }

    @Override
    public Var add(Var other) {
        double[][] localValue =  new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                localValue[i][j] = value[i][j];
            }
        }
        if(other instanceof Scalar scalar){
            for (int i = 0; i < localValue.length; i++) {
                for (int j = 0; j < localValue[i].length; j++) {
                    localValue[i][j] += scalar.getValue();
                }
            }

            return new Matrix(localValue);
        }
        else if(other instanceof  Vector vector){
            return super.add(other);
        }
        else if(other instanceof Matrix matrix){
            if(this.value.length == matrix.value.length){
                for (int i = 0; i < localValue.length; i++){
                    for (int j = 0; j < localValue[i].length; j++) {
                        localValue[i][j] += matrix.value[i][j];
                    }
                }

                return new Matrix(localValue);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        double[][] localValue =  new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                localValue[i][j] = value[i][j];
            }
        }
        if(other instanceof Scalar scalar){
            for (int i = 0; i < localValue.length; i++) {
                for (int j = 0; j < localValue[i].length; j++) {
                    localValue[i][j] -= scalar.getValue();
                }
            }

            return new Matrix(localValue);
        }
        else if(other instanceof  Vector vector){
            return super.sub(other);
        }
        else if(other instanceof Matrix matrix){
            if(this.value.length == matrix.value.length){
                for (int i = 0; i < localValue.length; i++){
                    for (int j = 0; j < localValue[i].length; j++) {
                        localValue[i][j] -= matrix.value[i][j];
                    }
                }

                return new Matrix(localValue);
            }
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        double[][] localValue =  new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                localValue[i][j] = value[i][j];
            }
        }
        if(other instanceof Scalar scalar){
            for (int i = 0; i < localValue.length; i++) {
                for (int j = 0; j < localValue[i].length; j++) {
                    localValue[i][j] *= scalar.getValue();
                }
            }
            return new Matrix(localValue);
        }
        else if(other instanceof  Vector vector){
            if(localValue[0].length == vector.getValue().length){
                double[] localVector = new double[localValue[0].length];
                for (int i = 0; i < localVector.length; i++) {
                    for (int j = 0; j < vector.getValue().length; j++) {
                        localVector[i] = localVector[i] + localValue[i][j] * vector.getValue()[j];
                    }
                }

                return new Vector(localVector);
            }

            return super.mul(other);
        }

        else if(other instanceof Matrix matrix) {
            if (localValue.length == matrix.value.length) {//
                double[][] tempValue = new double[localValue.length][matrix.value[0].length];
                for (int i = 0; i < localValue.length; i++) {
                    for (int j = 0; j < matrix.value[0].length; j++) {
                        for (int k = 0; k < matrix.value.length; k++)
                            tempValue[i][j] = tempValue[i][j] + localValue[i][k] * matrix.value[k][j];
                    }
                }
                localValue = Arrays.copyOf(tempValue,tempValue.length);
                return new Matrix(localValue);
            }

            return super.mul(other);
            }

        return super.mul(other);
    }


    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('{');
        for (int i = 0; i < value.length; i++) {
            builder.append('{');
            String delimiter = "";
            String comma = ",";
            for (int j = 0; j < value[i].length; j++) {
                builder.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if(i< value.length-1){
                builder.append('}').append(comma + " ");
            }else {
                builder.append('}');
            }
        }

        builder.append('}');
        return builder.toString();
    }
}


