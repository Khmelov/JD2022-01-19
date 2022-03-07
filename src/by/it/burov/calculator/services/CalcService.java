package by.it.burov.calculator.services;

import by.it.burov.calculator.ecxeptions.CalcException;
import by.it.burov.calculator.model.Var;
import by.it.burov.calculator.repositories.VarRepository;
import by.it.burov.calculator.utils.Patterns;

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
            expression = bracketControl(expression);
        }
        String result = getVar(expression);
        return repository.createVar(result);
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

    private String bracketControl(String expression) throws CalcException {
        String checkedExpression = expression;
        String expressionWithoutBrackets = null;
        while (checkedExpression.contains("(")) {
            int bracketCounter = 0;
            int openBracketPosition = checkedExpression.indexOf('(');
            int closeBracketPosition = 0;
            for (int i = openBracketPosition; i < checkedExpression.length(); i++) {
                if (checkedExpression.charAt(i) == '(') {
                    bracketCounter++;
                    openBracketPosition = i;
                }
                if (checkedExpression.charAt(i) == ')') {
                    bracketCounter--;
                    closeBracketPosition = i;

                    if (bracketCounter > 0) {
                        String subExpression = checkedExpression.substring(openBracketPosition + 1, closeBracketPosition);
                        checkedExpression = checkedExpression.replace("(" + subExpression + ")", getVar(subExpression));
                        if (checkedExpression.contains("(")) {
                            expressionWithoutBrackets = bracketControl(checkedExpression);
                            break;
                        }
                    }
                }

                if (bracketCounter == 0) {
                    break;
                }
            }
            if (expressionWithoutBrackets != null) {
                return expressionWithoutBrackets;
            }

            String subExpression = checkedExpression.substring(openBracketPosition + 1, closeBracketPosition);
            if (subExpression.contains("(")) {
                bracketControl(subExpression);
            } else {
                expressionWithoutBrackets = checkedExpression.replace("(" + subExpression + ")", getVar(subExpression));
                return expressionWithoutBrackets;
            }
        }
        return expressionWithoutBrackets;
    }

    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {
        Var right = repository.createVar(rightStr);
        if (operation.equals("=")) {
            return repository.saveVars(leftStr, right);
        }
        Var left = repository.createVar(leftStr);
        if (left == null || right == null) {
            throw new CalcException("Incorrect expression " + leftStr + operation + rightStr);
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
        throw new CalcException("Something went wrong!");
    }


    private int getIndexOperation(List<String> operation) {
        int index = -1;
        int currentPriority = -1;
        for (int i = 0; i < operation.size(); i++) {
            String getOperation = operation.get(i);
            if (currentPriority < priorityMap.get(getOperation)) {
                currentPriority = priorityMap.get(getOperation);
                index = i;
            }
        }
        return index;
    }
}
