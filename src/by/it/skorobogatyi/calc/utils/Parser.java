package by.it.skorobogatyi.calc.utils;

import by.it.skorobogatyi.calc.exceptions.CalcException;
import by.it.skorobogatyi.calc.logger.Logger;
import by.it.skorobogatyi.calc.resources.LocalisationManager;
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

        if (expression.contains("(")) {
            expression = resolveBraces(expression);
        }

        String result = calcWithoutBraces(expression);
        return VarCreator.create(result);
    }

    private String resolveBraces(String expression) throws CalcException {

        String newExpression = expression;

        while (newExpression.contains("(")) {

            int braceCounter = 0;
            int openBraceIndex = newExpression.indexOf('(');
            int closeBraceIndex = 0;

            for (int i = openBraceIndex; i < newExpression.length(); i++) {
                char symbol = newExpression.charAt(i);

                if (symbol == '(') {
                    braceCounter++;
                }

                if (symbol == ')') {
                    braceCounter--;
                }

                if (braceCounter == 0) {
                    closeBraceIndex = i;
                    break;
                }
            }

            String subExpression = newExpression.substring(openBraceIndex + 1, closeBraceIndex);

            String recursiveString;
            if (subExpression.contains("(")) {
                recursiveString = resolveBraces(subExpression);
            } else {
                recursiveString = subExpression;
            }

            String replacementExpression = calcWithoutBraces(recursiveString);
            newExpression = newExpression.replace("(" + subExpression + ")", replacementExpression);
        }
        return newExpression;
    }

    private String calcWithoutBraces(String expression) throws CalcException {

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

        return operands.get(0);
    }

    private AbstractVar calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {

        AbstractVar right = VarCreator.create(rightStr);

        if (operation.equals("=")) {
            VariablesStorage.variables.put(leftStr, right);
            return right;
        }

        AbstractVar left = VarCreator.create(leftStr);

        if (left == null || right == null) {
            String message = String.format("%s" + leftStr + operation + rightStr,
                    LocalisationManager.INSTANCE.get("error.incorrectOperation"));
            Logger.INSTANCE.error(message);
            throw new CalcException(message);
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
                String message = String.format("%s",
                        LocalisationManager.INSTANCE.get("error.incorrectExpression"));
                Logger.INSTANCE.error(message);
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
