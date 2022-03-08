package by.it.katsal.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {

        this.value = value.clone();//т.к. хранится ссылка, то наш массив могут изменить извне, поэтому делаем клон

    }

    public Vector(Vector vector) {
        this.value = vector.value;

    }

    public double[] getValue() {
        return value.clone();
    }


    public Vector(String vector) {

        double[] buff = {};
        String regex = "[0-9.]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(vector);
        while (matcher.find()) {
            String text = matcher.group();
            double parseText = Double.parseDouble(text);
            buff = Arrays.copyOf(buff, buff.length + 1);
            buff[buff.length - 1] = parseText;

        }
        this.value = buff;


    }


    @Override
    public Var add(Var other) {

        double[] localValue = value.clone();

        if (other instanceof Scalar scalar) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] = localValue[i] + scalar.getValue();
            }
            return new Vector(localValue);

        } else if (other instanceof Vector vector) {

            if (this.value.length == vector.value.length) {
                for (int i = 0; i < localValue.length; i++) {
                    localValue[i] = localValue[i] + vector.value[i];
                }
                return new Vector(localValue);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {

        double[] localValue = value.clone();

        if (other instanceof Scalar scalar) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] = localValue[i] - scalar.getValue();
            }
            return new Vector(localValue);

        } else if (other instanceof Vector vector) {

            if (this.value.length == vector.value.length) {
                for (int i = 0; i < localValue.length; i++) {
                    localValue[i] = localValue[i] - vector.value[i];
                }
                return new Vector(localValue);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {

        double[] localValue = value.clone();

        if (other instanceof Scalar scalar) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] = localValue[i] * scalar.getValue();
            }
            return new Vector(localValue);

        } else if (other instanceof Vector vector) {

            if (localValue.length == vector.value.length) {
                System.out.println(localValue.length + " left local value length ||| right vector value lenttgh" + vector.value.length);
                double sum = 0;

                for (int i = 0; i < localValue.length; i++) {
                    localValue[i] = localValue[i] * vector.value[i];
                    sum = sum + localValue[i];
                }
                return new Scalar(sum);


            }


        }
        return super.mul(other);

    }

    @Override
    public Var div(Var other) {
        double[] localValue = value.clone();

        if (other instanceof Scalar scalar) {
            for (int i = 0; i < localValue.length; i++) {
                localValue[i] = localValue[i] / scalar.getValue();
            }
            return new Vector(localValue);

        } else return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");

        for (int i = 0; i < value.length; i++) {
            double element = value[i];
            out.append(element);
            if (i < value.length - 1) {
                out.append(", ");
            }
            //out.append("}");
        }

        out.append("}");
        return out.toString();


    }
}

