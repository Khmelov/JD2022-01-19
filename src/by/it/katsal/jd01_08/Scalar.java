package by.it.katsal.jd01_08;

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double result = this.value + otherScalar.value;
            return new Scalar(result);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) { //2-{1,2,3} ==> {1,2,3} -2  поэтому нужно умножитьн= нна минус 1
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double result = this.value - otherScalar.value;
            return new Scalar(result);
        }

        else return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {

        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double result = this.value * otherScalar.value;
            return new Scalar(result);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {

        if (other instanceof Scalar) {

            Scalar otherScalar = (Scalar) other;
            if (otherScalar.value == 0) {
                System.out.printf("ERROR: division by zero %s // %s%n", this,other);
                return null;//TODO replace with Exception

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

        return Double.toString(value);
    }
}
