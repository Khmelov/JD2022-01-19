package by.it.katsal.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
private final double [] value;
public Vector (double [] value ){
    this.value = value.clone();
}
public double [] getValue(){
    return value.clone();
}

    @Override
    public String toString() {
    StringBuilder out = new StringBuilder();
    out.append('{');
    String delimiter = "";
        for (double element:value) {
            out.append(delimiter).append(element);
            delimiter = ", ";

        }

    out.append('}');
        return out.toString();
    }
}



