package by.it.yushkevich.calculator;

//TODO do this task one more time by yourself
abstract class Var implements Operation {


    @Override
    public Var add(Var other) throws CalcException {


        throw new CalcException(String.format("Operation 'ADD' %s + %s impossible%n", this, other));

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Operation 'SUB' %s - %s impossible%n", this, other));

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Operation 'MUL' %s * %s impossible%n", this, other));

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation 'DIV' %s \\ %s impossible%n", this, other));

    }

    @Override
    public String toString() {
        return "abstract variable";
    }
}
