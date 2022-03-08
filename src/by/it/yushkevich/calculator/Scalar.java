package by.it.yushkevich.calculator;

class Scalar extends Var {


    private double value;

    public Scalar() {
        super();
    }

    public Scalar(double value) {

        this.value = value;

    }


    public Scalar(Scalar otherScalar) {

        this.value = otherScalar.value;

    }


    public Scalar(String stringValue) {

        value = Double.parseDouble(stringValue);
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double result = this.value + otherScalar.value;
            return new Scalar(result);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException { //2-{1,2,3} ==> {1,2,3} -2  поэтому нужно умножитьн= нна минус 1
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double result = this.value - otherScalar.value;
            return new Scalar(result);
        }

        else return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {

        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double result = this.value * otherScalar.value;
            return new Scalar(result);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {

        if (other instanceof Scalar) {

            Scalar otherScalar = (Scalar) other;
            if (otherScalar.value == 0) {
                String message = String.format(" division by zero %s // %s%n", this, other);
                throw new CalcException(message);


            } else {
                double result = this.value / otherScalar.value;
                return new Scalar(result);
            }
        }
        return super.div(other);
    }


    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        //делаем из дабла строку
        return Double.toString(value);
    }
}
