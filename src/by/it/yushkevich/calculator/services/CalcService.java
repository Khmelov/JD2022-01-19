package by.it.yushkevich.calculator.services;

import by.it.yushkevich.calculator.exceptions.CalcException;
import by.it.yushkevich.calculator.repository.VarRepository;
import by.it.yushkevich.calculator.utils.Patterns;
import by.it.yushkevich.calculator.repository.MapRepository;
import by.it.yushkevich.calculator.model.Var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcService {

    private final VarRepository repository;

    public CalcService(VarRepository repository) {
        this.repository = repository;
    }

    public Var calc(String expression) throws CalcException {

        expression.replaceAll(Patterns.SPACES, "");
        String[] parts = expression.split(Patterns.OPERATION, 2);// разделили не более чем на две части (т.е. нашли левую и правую часть)
        if (parts.length == 1) {
            return repository.create(expression);
        }


        Var right = repository.create(parts[1]);

        if (expression.contains("=")){
            String name = parts[0];
            return repository.save(name, right);

        }

        Var left = repository.create(parts[0]);

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
