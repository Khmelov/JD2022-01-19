package by.it.katsal.jd01_08;

class Scalar extends Var {

    private final double value;

    public Scalar(String stringValue) {
        value = Double.parseDouble(stringValue);
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value + otherScalar.value);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) { // 2-{1,2,3} ==> {1,2,3}-2
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value - otherScalar.value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value * otherScalar.value);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar) {
            if (otherScalar.value == 0) {
                System.out.printf("ERROR: division by zero %s / %s%n", this, other);
                return null; //TODO replace with Exception
            }
            return new Scalar(this.value / otherScalar.value);
        }
        return super.add(other);
    }

    public double getValue() {
        return value;
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}



