package by.it.yushkevich.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private VarRepository varRepository;

    public Parser(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    public Var calc(String expression) throws CalcException {
//2 + 2
        expression.replaceAll(Patterns.SPACES, "");
        String[] parts = expression.split(Patterns.OPERATION, 2);// разделили не более чем на две части (т.е. нашли левую и правую часть)
        if (parts.length == 1) {
            return varRepository.create(expression);
        }


        Var right = varRepository.create(parts[1]);

        if (expression.contains("=")){
            String name = parts[0];
            return varRepository.save(name, right);

        }

        Var left = varRepository.create(parts[0]);

        if (left == null || right == null) {
            throw new CalcException(String.format("Incorrect expression " + expression));

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


       throw new CalcException("Something wen wrong");

    }
}
