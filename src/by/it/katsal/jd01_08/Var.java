package by.it.katsal.jd01_08;

abstract class Var implements Operation{

    @Override
    public Var add(Var other) {
        System.out.printf("Operation 'ADD' %s + %s impossible%n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation 'SUB' %s - %s impossible%n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation 'MUL' %s * %s impossible%n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation 'DIV' %s \\ %s impossible%n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "abstract variable";
    }
}
