package by.it.skorobogatyi.calc.utils;

import by.it.skorobogatyi.calc.variables.AbstractVar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Map<String, Integer> priorityMap = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    public AbstractVar calc(String expression) throws CalcException {

        expression = expression.replaceAll(CustomPatterns.SPACES, "");

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(CustomPatterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher operationFinder = Pattern.compile(CustomPatterns.OPERATION).matcher(expression);
        while (operationFinder.find()) {
            operations.add(operationFinder.group());
        }

        int index = getIndexOperation(operations);
        String left = operands.remove(index);
        String right = operands.remove(index);
        String operation = operations.remove(index);
        AbstractVar result = calcOneOperation(left, operation, right);


        String[] parts = expression.split(CustomPatterns.OPERATION, 2);

        if (parts.length == 1) {
            return AbstractVar.create(expression);
        }

        AbstractVar left = AbstractVar.create(parts[0]);
        AbstractVar right = AbstractVar.create(parts[1]);

        if (left != null && right != null) {
            Matcher matcher = Pattern.compile(CustomPatterns.OPERATION).matcher(expression);

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
                    case "=":
                        VariablesStorage.variables.put(String.valueOf(left), right);
                        return right;
                    default:
                        String message = "Incorrect expression: " + expression;
                        throw new CalcException(message);
                }
            }
        }
        throw new CalcException("No such variable");
    }

    private int getIndexOperation(List<String> operation) {
        int index = -1;
        int currentPriority = -1;
        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            if (currentPriority < priorityMap.get(op)) {
                currentPriority = priorityMap.get(op);
                index = i;
            }
        }
    }
}
