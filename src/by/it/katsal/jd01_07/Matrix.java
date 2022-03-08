package by.it.katsal.jd01_07;

class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        double[][] secondMatrix = value.clone();
        for (int i = 0; i < secondMatrix.length; i++) {
            secondMatrix[i] = secondMatrix[i].clone();
        }
        this.value = secondMatrix;
    }

    public Matrix(Matrix otherMatrix) {
        double[][] secondMatrix = otherMatrix.value.clone();
        for (int i = 0; i < secondMatrix.length; i++) {
            secondMatrix[i] = secondMatrix[i].clone();
        }
        this.value = secondMatrix;
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[^0-9],\\s?[^0-9]", "&");
        strMatrix = strMatrix.replaceAll("[{}]", "");
        String[] strMatrixArr = strMatrix.split("&");
        int q = strMatrixArr.length;
        int q1 = strMatrixArr[0].trim().split(",").length;
        String[][] matrixArr = new String[q][q1];
        for (int i = 0; i < matrixArr.length; i++) {
            matrixArr[i] = strMatrixArr[0].trim().split(",");
        }
        double[][] secondMatrix = new double[q][q1];
        for (int i = 0; i < matrixArr.length; i++) {
            for (int i1 = 0; i1 < matrixArr[0].length; i1++) {
                secondMatrix[i][i1] = Double.parseDouble(matrixArr[i][i1]);

            }
        }
        this.value = secondMatrix;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        for (int i = 0; i < value.length; i++) {
            out.append("{");
            String delimiter = ",";
            for (int i1 = 0; i1 < value[i].length; i1++) {
                out.append(value[i][i1]).append(delimiter);
                delimiter = "";
                if (i == value.length - 1) {
                    out.append(delimiter);
                }
            }
            delimiter = ",";
            if (i == value.length - 1) {
                delimiter = "";
                out.append(delimiter);
            }
            out.append("}").append(delimiter);
        }
        out.append("}");
        return out.toString();
    }
}
