package by.it.katsal.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {

    public Var calc(String expression) {
        expression = expression.replaceAll(Patterns.SPACES, "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length == 1) {
            return Var.createVar(expression);
        }
        Var left = Var.createVar(parts[0]);
        Var right = Var.createVar(parts[1]);
        if (left == null || right == null) {
            System.out.println("Incorrect expression " + expression);
            return null;
        }
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
            }
        }

        return null;
    }
}

