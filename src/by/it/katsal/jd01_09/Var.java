package by.it.katsal.jd01_09;

abstract class Var implements Operation {

    public static Var createVar(String varValue) {
        if (varValue.matches(Patterns.SCALAR)){
            return new Scalar(varValue);
        }
        else if(varValue.matches(Patterns.VECTOR)){
            return new Vector(varValue);
        }
        else if(varValue.matches(Patterns.MATRIX)){
            return new Matrix(varValue);
        }
        else

            return null;
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation addition %s + %s is impossible%n",this,other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation subtract %s - %s is impossible%n",this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation multiply %s*%s is impossible%n", this, other);

        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation division %s/%s is impossible%n",this,other);

        return null;
    }

    @Override
    public String toString() {
        return "unknown variable (abstract stub)";
    }
}


