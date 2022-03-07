package by.it.skorobogatyi.jd02_05.calc.variables;

import by.it.skorobogatyi.jd02_05.calc.resources.LocalisationManager;
import by.it.skorobogatyi.jd02_05.calc.utils.CalcException;
import by.it.skorobogatyi.jd02_05.calc.utils.Operation;

class Scalar extends AbstractVar implements Operation {

    private final double value;
    private final LocalisationManager lang = LocalisationManager.INSTANCE;


    public double getValue() {
        return value;
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public Scalar(String strScalar) {
        value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }



    @Override
    public AbstractVar add(AbstractVar other) throws CalcException {
        return other.add(this);
    }

    @Override
    public AbstractVar add(Scalar other) {
        double returnValue = other.value + this.value;
        return new Scalar(returnValue);
    }

    @Override
    public AbstractVar add(Vector other) {
        return other.add(this);
    }

    @Override
    public AbstractVar add(Matrix other) {
        return other.add(this);
    }


    @Override
    public AbstractVar sub(AbstractVar other) throws CalcException {
        return other.sub(this);
    }

    @Override
    public AbstractVar sub(Scalar other) {
        double returnValue = other.value - this.value;
        return new Scalar(returnValue);
    }

    @Override
    public AbstractVar sub(Vector other) {
        return other.sub(this);
    }

    @Override
    public AbstractVar sub(Matrix other) {
        return other.sub(this);
    }



    @Override
    public AbstractVar mul(AbstractVar other) throws CalcException {
       return other.mul(this);
    }

    @Override
    public AbstractVar mul(Scalar other) {
        double returnValue = other.value * this.value;
        return new Scalar(returnValue);
    }

    @Override
    public AbstractVar mul(Vector other) {
        return other.mul(this);
    }

    @Override
    public AbstractVar mul(Matrix other) {
        return other.mul(this);
    }


    @Override
    public AbstractVar div(AbstractVar other) throws CalcException {
        return other.div(this);
    }

    @Override
    public AbstractVar div(Scalar other) throws CalcException {
        if (this.value != 0) {
            double returnValue = other.value / this.value;
            return new Scalar(returnValue);
        }

        String submessage = String.format("%s / %s", other, this);
        String message = String.format("%s: %s%n", lang.get("message.division"), submessage);
        throw new CalcException(message);

    }

    @Override
    public AbstractVar div(Vector other) throws CalcException {

        if (this.getValue() != 0) {

            double[] localValue = other.getValue().clone();
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] = localValue[i] / this.value;
            }
            return new Vector(localValue);
        }
        String submessage = String.format("%s / %s", this, other);
        String message = String.format("%s: %s%n", lang.get("message.division"), submessage);
        throw new CalcException(message);
    }

    @Override
    public AbstractVar div(Matrix other) throws CalcException {
        return other.div(this);
    }

}
