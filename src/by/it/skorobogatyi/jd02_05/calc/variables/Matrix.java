package by.it.skorobogatyi.jd02_05.calc.variables;

import by.it.skorobogatyi.jd02_05.calc.resources.LocalisationManager;
import by.it.skorobogatyi.jd02_05.calc.utils.CalcException;
import by.it.skorobogatyi.jd02_05.calc.utils.Operation;

class Matrix extends AbstractVar implements Operation {

    private final double[][] value;
    private final LocalisationManager lang = LocalisationManager.INSTANCE;



    public Matrix(double[][] value) {
        this.value = value.clone();
    }


    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value.clone();
    }


    public Matrix(String stringWithMatrix) {

        String[] matrixElements = stringWithMatrix.split("[^0-9],\s?[^0-9]");

        value = new double[matrixElements.length][0];

        for (int i = 0; i < matrixElements.length; i++) {

            matrixElements[i] = matrixElements[i].replaceAll("[{},\\s]+", " ").trim();
            String[] lineElements = matrixElements[i].split(" ");

            double[] lineElementsInDouble = new double[lineElements.length];

            for (int j = 0; j < lineElements.length; j++) {
                lineElementsInDouble[j] = Double.parseDouble(lineElements[j]);
            }

            value[i] = lineElementsInDouble;
        }
    }


    public double[][] getValue() {
        return this.value;
    }

    @Override
    public String toString() {

        StringBuilder returnString = new StringBuilder();

        returnString.append("{");
        for (int i = 0; i < value.length; i++) {
            returnString.append("{");

            for (int j = 0; j < value[i].length - 1; j++) {
                double element = value[i][j];
                returnString.append(element).append(", ");
            }

            returnString.append(value[i][value[i].length - 1]).append("}");

            if (i < value.length - 1) {
                returnString.append(", ");
            }
        }
        returnString.append("}");

        return String.valueOf(returnString);
    }


    @Override
    public AbstractVar add(AbstractVar other) throws CalcException {
        return other.add(this);
    }

    @Override
    public AbstractVar add(Scalar other) {

        double[][] returnMatrix = this.value.clone();
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                returnMatrix[i][j] = other.getValue() + returnMatrix[i][j];
            }
        }

        return new Matrix(returnMatrix);
    }

    @Override
    public AbstractVar add(Vector other) throws CalcException {
        String submessage = String.format("%s + %s", other, this);
        String message = String.format("%s: %s%n", lang.get("message.addition"), submessage);
        throw new CalcException(message);
    }

    @Override
    public AbstractVar add(Matrix other) throws CalcException {

        if (other.value.length != this.value.length) {
            String submessage = String.format("%s + %s", other, this);
            String message = String.format("%s: %s%n", lang.get("message.addition"), submessage);
            throw new CalcException(message);
        }

        for (int i = 0; i < this.value.length; i++) {
            if (other.value[i].length != this.value[i].length) {
                String submessage = String.format("%s + %s", other, this);
                String message = String.format("%s: %s%n", lang.get("message.addition"), submessage);
                throw new CalcException(message);
            }
        }

        double[][] returnMatrix = new double[this.value.length][];

        for (int i = 0; i < this.value.length; i++) {
            returnMatrix[i] = new double[this.value[i].length];

            for (int j = 0; j < this.value[i].length; j++) {
                returnMatrix[i][j] = other.value[i][j] + this.value[i][j];
            }
        }

        return new Matrix(returnMatrix);
    }


    @Override
    public AbstractVar sub(AbstractVar other) throws CalcException {
       return other.sub(this);
    }

    @Override
    public AbstractVar sub(Scalar other) {

        double[][] returnMatrix = this.value.clone();
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                returnMatrix[i][j] = returnMatrix[i][j] - other.getValue();
            }
        }

        return new Matrix(returnMatrix);
    }

    @Override
    public AbstractVar sub(Vector other) throws CalcException {
        String submessage = String.format("%s - %s", other, this);
        String message = String.format("%s: %s%n", lang.get("message.subtraction"), submessage);
        throw new CalcException(message);
    }

    @Override
    public AbstractVar sub(Matrix other) throws CalcException {

        if (other.value.length != this.value.length) {
            String submessage = String.format("%s - %s", other, this);
            String message = String.format("%s: %s%n", lang.get("message.subtraction"), submessage);
            throw new CalcException(message);
        }

        for (int i = 0; i < this.value.length; i++) {
            if (other.value[i].length != this.value[i].length) {
                String submessage = String.format("%s - %s", other, this);
                String message = String.format("%s: %s%n", lang.get("message.subtraction"), submessage);
                throw new CalcException(message);
            }
        }

        double[][] returnMatrix = new double[this.value.length][];

        for (int i = 0; i < this.value.length; i++) {
            returnMatrix[i] = new double[this.value[i].length];

            for (int j = 0; j < this.value[i].length; j++) {
                returnMatrix[i][j] = other.value[i][j] - this.value[i][j];
            }
        }

        return new Matrix(returnMatrix);
    }


    @Override
    public AbstractVar mul(AbstractVar other) throws CalcException {
        return other.mul(this);
    }

    @Override
    public AbstractVar mul(Scalar other) {
        double[][] returnMatrix = this.value.clone();
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                returnMatrix[i][j] = other.getValue() * returnMatrix[i][j];
            }
        }
        return new Matrix(returnMatrix);
    }

    @Override
    public AbstractVar mul(Vector other) throws CalcException {

        if (other.getValue().length != this.value[0].length) {
            String submessage = String.format("%s * %s", other, this);
            String message = String.format("%s: %s%n", lang.get("message.multiplication"), submessage);
            throw new CalcException(message);
        }

        double[] returnVector = new double[this.value.length];

        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < other.getValue().length; j++) {
                returnVector[i] = this.value[i][j] * other.getValue()[j] + returnVector[i];
            }
        }

        return new Vector(returnVector);
    }

    @Override
    public AbstractVar mul(Matrix other) throws CalcException {

        if (this.value[0].length != other.value.length) {
            String submessage = String.format("%s * %s", other, this);
            String message = String.format("%s: %s%n", lang.get("message.multiplication"), submessage);
            throw new CalcException(message);
        }

        double[][] returnMatrix = new double[this.value.length][other.value[0].length];

        for (int i = 0; i < returnMatrix.length; i++) {
            for (int j = 0; j < returnMatrix[0].length; j++) {
                for (int k = 0; k < this.value[0].length; k++) {
                    returnMatrix[i][j] = returnMatrix[i][j] + other.value[i][k] * this.value[k][j];
                }
            }
        }

        return new Matrix(returnMatrix);
    }


    @Override
    public AbstractVar div(AbstractVar other) throws CalcException {
        return other.div(this);
    }

    @Override
    public AbstractVar div(Scalar other) throws CalcException {

        if (other.getValue() != 0) {

            double[][] returnMatrix = this.value.clone();
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    returnMatrix[i][j] = returnMatrix[i][j] / other.getValue();
                }
            }

            return new Matrix(returnMatrix);
        }

        String submessage = String.format("%s / %s", this, other);
        String message = String.format("%s: %s%n", lang.get("message.division"), submessage);
        throw new CalcException(message);
    }

    @Override
    public AbstractVar div(Vector other) throws CalcException {
        String submessage = String.format("%s / %s", other, this);
        String message = String.format("%s: %s%n", lang.get("message.division"), submessage);
        throw new CalcException(message);
    }

    @Override
    public AbstractVar div(Matrix other) throws CalcException {
        String submessage = String.format("%s / %s", other, this);
        String message = String.format("%s: %s%n", lang.get("message.division"), submessage);
        throw new CalcException(message);
    }
}
