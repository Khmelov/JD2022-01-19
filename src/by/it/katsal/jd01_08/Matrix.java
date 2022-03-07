package by.it.katsal.jd01_08;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;


    public Matrix(double[][] value) {
        this.value = value.clone();
    }


    public Matrix(Matrix otherMatrix) {

        this.value = otherMatrix.value.clone();
    }


    public Matrix(String textMatrix) {


        String textForRows = textMatrix.replaceAll("[{]+|[}]{2,}", "");
        textForRows = textForRows.trim();
        String[] rows = textForRows.split("},");
        int rowsCount = rows.length; //6
        String[] col = rows[0].trim().split(",");
        int colCount = col.length;
        for (int i = 0; i < col.length; i++) {
            col[i].trim();
        }

        String[][] buffArray = new String[rowsCount][colCount];
        for (int i = 0; i < buffArray.length; i++) {
            buffArray[i] = rows[i].trim().split("[,]");
        }

        double[][] value = new double[rowsCount][colCount];
        for (int i = 0; i < buffArray.length; i++) {
            for (int j = 0; j < buffArray[i].length; j++) {
                value[i][j] = Double.parseDouble(buffArray[i][j]);
            }
        }
        this.value = value;

    }


    @Override
    public Var add(Var other) {

        double[][] localMatrix = new double[this.value.length][this.value[0].length];

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                localMatrix[i][j] = value[i][j];
            }
        }

        if (other instanceof Scalar scalar) {
            for (int i = 0; i < localMatrix.length; i++) {
                for (int j = 0; j < localMatrix[i].length; j++) {
                    localMatrix[i][j] = localMatrix[i][j] + scalar.getValue();
                }

            }
            return new Matrix(localMatrix);


        } else if (other instanceof Matrix matrix) {


            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    localMatrix[i][j] = value[i][j];
                }
            }

            if (this.value.length == matrix.value.length) {
                for (int i = 0; i < localMatrix.length; i++) {
                    for (int j = 0; j < localMatrix[i].length; j++) {

                        localMatrix[i][j] = localMatrix[i][j] + matrix.value[i][j];

                    }

                }
                return new Matrix(localMatrix);

            }
        }
        return super.add(other);
    }


    @Override
    public Var sub(Var other) {
        double[][] localMatrix = new double[this.value.length][this.value[0].length];

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                localMatrix[i][j] = value[i][j];
            }
        }

        if (other instanceof Scalar scalar) {
            for (int i = 0; i < localMatrix.length; i++) {
                for (int j = 0; j < localMatrix[i].length; j++) {
                    localMatrix[i][j] = localMatrix[i][j] - scalar.getValue();
                }

            }
            return new Matrix(localMatrix);

        } else if (other instanceof Matrix matrix) {


            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    localMatrix[i][j] = value[i][j];
                }
            }

            if (this.value.length == matrix.value.length) {
                for (int i = 0; i < localMatrix.length; i++) {
                    for (int j = 0; j < localMatrix[i].length; j++) {

                        localMatrix[i][j] = localMatrix[i][j] - matrix.value[i][j];

                    }

                }
                return new Matrix(localMatrix);

            }
        }


        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        double[][] localMatrix = new double[this.value.length][this.value[0].length];

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                localMatrix[i][j] = value[i][j];
            }
        }

        if (other instanceof Scalar scalar) {

            for (int i = 0; i < localMatrix.length; i++) {
                for (int j = 0; j < localMatrix[i].length; j++) {
                    localMatrix[i][j] *= scalar.getValue();
                }
            }
            return new Matrix(localMatrix);

        } else if (other instanceof Vector vector) {
            int localLength = localMatrix.length;
            int otherLength = vector.getValue().length;

            if (localLength == otherLength) {

                double[] tempVectorArray = new double[localLength];

                for (int i = 0; i < localLength; i++) {
                    for (int j = 0; j < otherLength; j++) {
                        tempVectorArray[i] = tempVectorArray[i] + localMatrix[i][j] * vector.getValue()[j];
                    }
                }
                return new Vector(tempVectorArray);

            } else return super.mul(other);


        } else if (other instanceof Matrix matrix) {
            if (localMatrix.length == matrix.value[0].length) {

                double[][] matrixArray = new double[localMatrix.length][matrix.value[0].length];

                for (int i = 0; i < matrixArray.length; i++) {

                    for (int j = 0; j < localMatrix.length; j++) {

                        for (int k = 0; k < matrix.value.length; k++) {
                            matrixArray[i][j] = matrixArray[i][j] + localMatrix[i][k] * matrix.value[k][j];
                        }
                    }
                }
                return new Matrix(matrixArray);
            }

        }


        //TODO multiply


        return super.mul(other);
    }


    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {

        StringBuilder out = new StringBuilder();
        out.append("{");


        for (int i = 0; i < value.length; i++) {
            out.append("{");
            for (int j = 0; j < value[i].length; j++) {

                out.append(value[i][j]);

                if (j < value[i].length - 1) {
                    out.append(", ");

                }
            }

            out.append("}");
            if (i < value.length - 1) {
                out.append(", ");
            }
        }
        out.append("}");

        return out.toString();
    }
}






