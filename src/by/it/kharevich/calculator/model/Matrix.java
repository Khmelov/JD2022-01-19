package by.it.kharevich.calculator.model;

public class Matrix extends Var {

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

 /*   public double Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{ }]", "");
        String[] strMatrixarr = strMatrix.split(",");
        String[][] parts = new String[0][];
        for (int i = 0; i < strMatrixarr.length; i++) {
            String[] arrstrMatrix = strMatrixarr[i].split(",");
            for (int i1 = 0; i1 < arrstrMatrix.length; i1++) {
                parts[i][i1]= arrstrMatrix[i];
                double result = Double.parseDouble(parts[i][i1]);

            }

        }
        this.value = parts;
    }*/

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
