package by.it.kuzma.calculator.model;

import by.it.kuzma.calculator.exceptions.CalcException;

public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value.clone();
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value.clone();
    }

    public Matrix(String strMatrix) {

        String[] rowMatrix = strMatrix.split("},");
        String[][] readyStrMatrix = new String[rowMatrix.length][];

        for (int i = 0; i < rowMatrix.length; i++) {
            readyStrMatrix[i] = rowMatrix[i].replaceAll("[{}]", "").split(",");
        }

        value = new double[readyStrMatrix.length][readyStrMatrix[0].length];

        for (int i = 0; i < readyStrMatrix.length; i++) {
            for (int j = 0; j < readyStrMatrix[i].length; j++) {
                value[i][j] = Double.parseDouble(readyStrMatrix[i][j].trim());
            }
        }
    }

    public double[][] getValue() {
        return value.clone();
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[][] localValue = new double[value.length][value[0].length];
        for (int i = 0; i < localValue.length; i++) {
            System.arraycopy(value[i], 0, localValue[i], 0, localValue[i].length);
        }
        if (other instanceof Scalar scalar) {
            for (int i = 0; i < localValue.length; i++) {
                for (int j = 0; j < localValue[i].length; j++) {
                    localValue[i][j] += scalar.getValue();
                }
            }
            return new Matrix(localValue);
        } else if (other instanceof Vector){
            return super.add(other);
        } else if (other instanceof Matrix matrix){
            if (localValue.length == matrix.value.length && localValue[0].length == matrix.value[0].length){
                for (int i = 0; i < localValue.length; i++) {
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
    public Var sub(Var other) throws CalcException {
        double[][] localValue = new double[value.length][value[0].length];
        for (int i = 0; i < localValue.length; i++) {
            System.arraycopy(value[i], 0, localValue[i], 0, localValue[i].length);
        }

        if (other instanceof Scalar scalar){
            for (int i = 0; i < localValue.length; i++) {
                for (int j = 0; j < localValue[i].length; j++) {
                    localValue[i][j] -= scalar.getValue();
                }
            }
            return new Matrix(localValue);
        } else if (other instanceof Vector){
            return super.sub(other);
        } else if (other instanceof Matrix matrix) {
            if (localValue.length == matrix.value.length && localValue[0].length == matrix.value[0].length) {
                for (int i = 0; i < localValue.length; i++) {
                    for (int j = 0; j < localValue[i].length; j++) {
                        localValue[i][j] -= matrix.value[i][j];
                    }
                }
                return new Matrix(localValue);
            }
            return super.sub(other);
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
            double[][] localValue = new double[value.length][value[0].length];
            for (int i = 0; i < localValue.length; i++) {
                System.arraycopy(value[i], 0, localValue[i], 0, localValue[i].length);
            }

            if (other instanceof Scalar scalar){
                for (int i = 0; i < localValue.length; i++) {
                    for (int j = 0; j < localValue[i].length; j++) {
                        localValue[i][j] *= scalar.getValue();
                    }
                }
                return new Matrix(localValue);
            } else if (other instanceof Vector vector){
                if (localValue[0].length == vector.getValue().length){
                    double[] matrixMulVector = new double[localValue[0].length];
                    for (int i = 0; i < localValue.length; i++) {
                        for (int j = 0; j < localValue[i].length; j++) {
                            matrixMulVector[i] += localValue[i][j] * vector.getValue()[j];
                        }
                    }
                    return new Vector(matrixMulVector);
                }
                return super.mul(other);

            } else if (other instanceof Matrix matrix){
                if (localValue.length == matrix.value[0].length){
                    double[][] mulMatrix = new double[localValue.length][matrix.value[0].length];
                    for (int i = 0; i < localValue.length; i++) {
                        for (int j = 0; j < matrix.value[0].length; j++) {
                            for (int k = 0; k < matrix.value.length; k++) {
                                mulMatrix[i][j] += localValue[i][k] * matrix.value[k][j];
                            }
                        }
                    }
                    return new Matrix(mulMatrix);
                }
                return super.mul(other);
            }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    @Override
    public String toString() {

        StringBuilder out = new StringBuilder();
        out.append('{');

        for (int i = 0; i < value.length; i++) {
            out.append('{');
            String delimiter = "";
            for (int j = 0; j < value[i].length; j++) {
                out.append(delimiter).append(value[i][j]);
                delimiter = ", ";
                if (j == value[i].length - 1 && i < value.length - 1) {
                    out.append('}').append(delimiter);
                }
            }
            if (i == value.length - 1) {
                out.append('}');
            }
        }
        out.append('}');

        return out.toString();

    }
}

