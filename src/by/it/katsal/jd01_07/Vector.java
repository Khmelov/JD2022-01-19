package by.it.katsal.jd01_07;

class Vector extends Var {

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
