package by.it.burov.calculator.services;

import by.it.burov.calculator.ecxeptions.CalcException;
import by.it.burov.calculator.model.Var;
import by.it.burov.calculator.repositories.VarRepository;
import by.it.burov.calculator.utils.Patterns;

import java.util.*;
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
        return repository.createVar(operands.get(0));
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

    public static String bracketControl(String s) {
        String current = "";
        Stack<Integer> numbers = new Stack<Integer>();
        Stack<Character> op = new Stack<Character>();
        //((C-0.15)-20)/(7-5)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                //while ()
                //if (!stack.isEmpty() || stack.pop() == '(') {
                 //   end = i - 1;
                  //  return true;
                }
            }

        return current;
    }
}

