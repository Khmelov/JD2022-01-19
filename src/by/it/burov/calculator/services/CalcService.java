package by.it.burov.calculator.services;

import by.it.burov.calculator.ecxeptions.CalcException;
import by.it.burov.calculator.repositories.VarRepository;
import by.it.burov.calculator.utils.Patterns;
import by.it.burov.calculator.repositories.MapRepository;
import by.it.burov.calculator.model.Var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcService {

    private final VarRepository repository;

    public CalcService(VarRepository repository) {
        this.repository = repository;
    }

    public Var calc(String expression) throws CalcException {
        expression = expression.replaceAll(Patterns.SPACES, "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length == 1) {
            return repository.createVar(expression);
        }
        Var right = repository.createVar(parts[1]);
        if(expression.contains("=")){
            String name = parts[0];
            return repository.saveVars(name,right);
        }
        Var left = repository.createVar(parts[0]);
        if (left == null || right == null) {
            throw new CalcException("Incorrect expression " + expression);
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
        throw new CalcException("Something went wrong");
    }
}

