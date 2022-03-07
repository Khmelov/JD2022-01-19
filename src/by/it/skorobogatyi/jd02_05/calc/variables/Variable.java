package by.it.skorobogatyi.jd02_05.calc.variables;

public class Variable extends AbstractVar {

    private final String value;

    public Variable(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public AbstractVar add(AbstractVar other) {
        return null;
    }

    @Override
    public AbstractVar add(Scalar other) {
        return null;
    }

    @Override
    public AbstractVar add(Vector other) {
        return null;
    }

    @Override
    public AbstractVar add(Matrix other) {
        return null;
    }

    @Override
    public AbstractVar sub(AbstractVar other) {
        return null;
    }

    @Override
    public AbstractVar sub(Scalar other) {
        return null;
    }

    @Override
    public AbstractVar sub(Vector other) {
        return null;
    }

    @Override
    public AbstractVar sub(Matrix other) {
        return null;
    }

    @Override
    public AbstractVar mul(AbstractVar other) {
        return null;
    }

    @Override
    public AbstractVar mul(Scalar other) {
        return null;
    }

    @Override
    public AbstractVar mul(Vector other) {
        return null;
    }

    @Override
    public AbstractVar mul(Matrix other) {
        return null;
    }

    @Override
    public AbstractVar div(AbstractVar other) {
        return null;
    }

    @Override
    public AbstractVar div(Scalar other) {
        return null;
    }

    @Override
    public AbstractVar div(Vector other) {
        return null;
    }

    @Override
    public AbstractVar div(Matrix other) {
        return null;
    }
}
