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

        List<String> operands = new ArrayList<>(
                Arrays.asList(
                        expression.split(CustomPatterns.OPERATION)
                )
        );

        List<String> operations = new ArrayList<>();
        Matcher operationFinder = Pattern.compile(CustomPatterns.OPERATION).matcher(expression);
        while (operationFinder.find()) {
            operations.add(operationFinder.group());
        }

        while (!operations.isEmpty()) {
            int index = getIndexOperation(operations);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String operation = operations.remove(index);
            AbstractVar result = calcOneOperation(left, operation, right);
            operands.add(index, result.toString());
        }

        return AbstractVar.create(operands.get(0));
    }

    private AbstractVar calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {

        AbstractVar right = AbstractVar.create(rightStr);

        if (operation.equals("=")) {
            VariablesStorage.variables.put(leftStr, right);
            return right;
        }

        AbstractVar left = AbstractVar.create(leftStr);

        if (left == null || right == null) {
            throw new CalcException("Incorrect operation: " + leftStr + operation + rightStr);
        }

        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
            default:
                String message = "Incorrect expression";
                throw new CalcException(message);
        }
    }

    private int getIndexOperation(List<String> operations) {
        int index = -1;
        int currentPriority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (currentPriority < priorityMap.get(operation)) {
                currentPriority = priorityMap.get(operation);
                index = i;
            }
        }
        return index;
    }
}
