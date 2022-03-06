package by.it.tarend.calc.services;

import by.it.tarend.calc.exceptions.CalcException;
import by.it.tarend.calc.repositories.VarRepository;
import by.it.tarend.calc.utils.Patterns;
import by.it.tarend.calc.repositories.MapRepository;
import by.it.tarend.calc.model.Var;

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

        // A=2+5*8
        // C=B+(A*2)
        // D=((C-0.15)-20)/(7-5)
        // E={2,3}*(D/2)

        expression = expression.replaceAll(Patterns.SPACES, "");
        if (expression.contains("(")) {
            expression = calcBracesExpressions(expression);
        }
        String result = calcWithoutBraces(expression);
        return repository.create(result);
    }

    private String calcBracesExpressions(String expression) throws CalcException {
        String newExpression = expression;
        while (newExpression.contains("(")) {
            int braceCounter = 0;
            int openBrace = newExpression.indexOf('(');
            int closeBrace = 0;
            for (int i = openBrace; i < newExpression.length(); i++) {
                if (newExpression.charAt(i) == '(') {
                    braceCounter++;
                }
                if (newExpression.charAt(i) == ')') {
                    braceCounter--;
                }
                if (braceCounter == 0) {
                    closeBrace = i;
                    break;
                }
            }
            String subExpression = newExpression.substring(openBrace + 1, closeBrace);
//            System.out.println(subExpression);
            if (subExpression.contains("(")) {
                calcBracesExpressions(subExpression);
            } else {
                newExpression = newExpression.replace("("+subExpression+")", calcWithoutBraces(subExpression));
            }
        }
        return newExpression;
    }

    private String calcWithoutBraces(String expression) throws CalcException {
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION))); // A 2 5 8
        List<String> operations = new ArrayList<>(); // = + *
        Matcher operationFinder = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (operationFinder.find()) {
            operations.add(operationFinder.group());
        }
        while (!operations.isEmpty()) {
            int index = getIndexOperation(operations);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String operation = operations.remove(index);
            // A 2, = +
            Var result = calcOneOperation(left, operation, right); // 5*8
            operands.add(index, result.toString());
        }
        return operands.get(0);
    }

    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {

        Var right = repository.create(rightStr);
        if (operation.equals("=")) {
            return repository.save(leftStr, right);
        }
        Var left = repository.create(leftStr);
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
        throw new CalcException("LOL");
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
