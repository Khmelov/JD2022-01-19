package by.it.tarend.calc.model;

import by.it.tarend.calc.exceptions.CalcException;

import java.util.Arrays;

public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {

        this.value = value.clone();
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value.clone();
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(otherMatrix.value[i], otherMatrix.value[i].length);
        }
    }

    public Matrix(String strMatrix) {

        String[] rows = strMatrix.replaceAll("[{]+|[}]{2,}", " ").trim().split("},");
        int rowsCounter = rows.length;
        int columnsCounter = rows[0].trim().split("[,]").length;

        String[][] elements = new String[rowsCounter][columnsCounter];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = rows[i].trim().split("[,]");
        }
        double[][] localValue = new double[rowsCounter][columnsCounter];
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                localValue[i][j] = Double.parseDouble(elements[i][j]);
            }
        }
        this.value = localValue;

    }

    @Override
    public Var add(Var other) throws CalcException {
        double[][] localValue = this.value.clone();
        for (int i = 0; i < localValue.length; i++) {
            localValue[i] = Arrays.copyOf(this.value[i], this.value[i].length);
        }
        if (other instanceof Scalar otherScalar) {
            for (int i = 0; i < localValue.length; i++) {
                for (int j = 0; j < localValue[i].length; j++) {
                    localValue[i][j] += otherScalar.getValue();
                }
            }
            return new Matrix(localValue);
        } else if (other instanceof Matrix otherMatrix) {
            if ((localValue.length == otherMatrix.value.length) && (localValue[0].length == otherMatrix.value[0].length)) {
                for (int i = 0; i < localValue.length; i++) {
                    for (int j = 0; j < localValue[i].length; j++) {
                        localValue[i][j] += otherMatrix.value[i][j];
                    }
                }
                return new Matrix(localValue);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[][] localValue = this.value.clone();
        for (int i = 0; i < localValue.length; i++) {
            localValue[i] = Arrays.copyOf(this.value[i], this.value[i].length);
        }
        if (other instanceof Scalar otherScalar) {
            for (int i = 0; i < localValue.length; i++) {
                for (int j = 0; j < localValue[i].length; j++) {
                    localValue[i][j] -= otherScalar.getValue();
                }
            }
            return new Matrix(localValue);
        } else if (other instanceof Matrix otherMatrix) {
            if ((localValue.length == otherMatrix.value.length) && (localValue[0].length == otherMatrix.value[0].length)) {
                for (int i = 0; i < localValue.length; i++) {
                    for (int j = 0; j < localValue[i].length; j++) {
                        localValue[i][j] -= otherMatrix.value[i][j];
                    }
                }
                return new Matrix(localValue);
            }
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        double[][] localValue = this.value.clone();
        for (int i = 0; i < localValue.length; i++) {
            localValue[i] = Arrays.copyOf(this.value[i], this.value[i].length);
        }
        if (other instanceof Scalar otherScalar) {
            for (int i = 0; i < localValue.length; i++) {
                for (int j = 0; j < localValue[i].length; j++) {
                    localValue[i][j] *= otherScalar.getValue();
                }
            }
            return new Matrix(localValue);
        } else if (other instanceof Vector otherVector) {
            if (localValue[0].length == otherVector.getValue().length) {
                double[] resultVector = new double[localValue.length];
                for (int i = 0; i < localValue.length; i++) {
                    for (int j = 0; j < resultVector.length; j++) {
                        resultVector[i] += localValue[i][j] * otherVector.getValue()[j];
                    }
                }
                return new Vector(resultVector);
            } else return super.mul(other);
        } else if (other instanceof Matrix otherMatrix) {
            if (localValue[0].length == otherMatrix.value.length) {
                double[][] resultMatrix = new double[localValue.length][otherMatrix.value[0].length];
                for (int i = 0; i < localValue.length; i++) {
                    for (int j = 0; j < otherMatrix.value[0].length; j++) {
                        for (int k = 0; k < localValue[0].length; k++) {
                            resultMatrix[i][j] += localValue[i][k] * otherMatrix.value[k][j];
                        }
                    }
                }
                return new Matrix(resultMatrix);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder outPut = new StringBuilder();
        outPut.append("{");
        for (int i = 0; i < value.length; i++) {
            String delimiter = "";
            outPut.append("{");
            for (int j = 0; j < value[i].length; j++) {
                outPut.append(delimiter).append(value[i][j]);
                delimiter = ",";
            }
            if (i == value.length - 1) {
                delimiter = "";
            }
            outPut.append("}").append(delimiter);
        }
        outPut.append("}");
        return outPut.toString();
    }
}
