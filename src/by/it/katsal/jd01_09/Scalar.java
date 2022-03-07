package by.it.katsal.jd01_09;

class Scalar extends Var {



    private final double value;

    public Scalar(String stringValue){
        value = Double.parseDouble(stringValue);
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar otherVector) {
        value = otherVector.value;
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar){
            return new Scalar(this.value + otherScalar.value);
        }else {
            return other.add(this);
        }
    }


    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value - otherScalar.value);
        }
        else {
            return other.sub(this).mul(new Scalar(-1));
        }
    }

    @Override
    public Var mul(Var other) {
       if (other instanceof Scalar otherScalar){
            return new Scalar(this.value *  otherScalar.value);
        }
       else {
           return other.mul(this);
       }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof  Scalar otherScalar) {
            if(otherScalar.value == 0){
                System.out.printf("ERROR: division by zero %s / %s%n", this, other);
                return null;
            }
            return new Scalar(this.value / otherScalar.value);
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


