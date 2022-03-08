package by.it.kustova.calculator.services;

import by.it.kustova.calculator.exceptions.CalcException;
import by.it.kustova.calculator.model.Var;
import by.it.kustova.calculator.repositories.VarRepository;
import by.it.kustova.calculator.utils.Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcService {

    private final VarRepository repository;

    private final Map<String, Integer> priorityMap = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );


    public CalcService(VarRepository repository) {
        this.repository = repository;
    }

    public Var calc(String expression) throws CalcException {
        expression = expression.replaceAll(Patterns.SPACES, "");
        if (expression.contains("(")) {
            expression = calcWithBrackets(expression);
        }
        String result = getVar(expression);
        return repository.create(result);
    }

    private String getVar(String expression) throws CalcException {
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher operationFinder = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (operationFinder.find()) {
            operations.add(operationFinder.group());
        }
        while (!operations.isEmpty()) {
            int index = getIndexOperation(operations);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String operation = operations.remove(index);
            Var result = calcOneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return operands.get(0);
    }


    private Var calcOneOperation(String leftStr, String operation, String rightStr)
            throws CalcException {
        Var right = repository.create(rightStr);
        if (operation.equals("=")) {
            return repository.save(leftStr, right);
        }
        Var left = repository.create(leftStr);
        if (left == null || right == null) {
            throw new CalcException("Incorrect operation " + leftStr + operation + rightStr);
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
        }
        throw new CalcException("0_o");
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

    private String calcWithBrackets(String expression) throws CalcException {
        String inExpression = expression;
        String withoutBrackets = null;
        while (inExpression.contains("(")) {
            int bracketsCount = 0;
            int bracketsOpen = inExpression.indexOf('(');
            int bracketsClose = 0;
            for (int i = bracketsOpen; i < inExpression.length(); i++) {
                if (inExpression.charAt(i) == '(') {
                    bracketsCount++;
                    bracketsOpen = i;
                }
                if (inExpression.charAt(i) == ')') {
                    bracketsCount--;
                    bracketsClose = i;

                    if (bracketsCount > 0 || (bracketsCount == 0 && inExpression.contains("("))) {
                        String subExpression = inExpression.substring(bracketsOpen + 1, bracketsClose);
                        inExpression = inExpression.replace("(" + subExpression + ")", (CharSequence) calc(subExpression));
                        if (inExpression.contains("(")) {
                            withoutBrackets = calcWithBrackets(inExpression);
                            break;
                        } else {
                            withoutBrackets = inExpression;
                            return withoutBrackets;
                        }
                    }
                }

            }
            if (withoutBrackets != null) {
                return withoutBrackets;
            }
        }

        return withoutBrackets;
    }
}
