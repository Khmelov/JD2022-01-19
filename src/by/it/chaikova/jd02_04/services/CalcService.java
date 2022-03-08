package by.it.chaikova.jd02_04.services;

import by.it.chaikova.jd02_04.exceptions.CalcException;
import by.it.chaikova.jd02_04.model.Var;
import by.it.chaikova.jd02_04.repositories.VarRepository;
import by.it.chaikova.jd02_04.utils.Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcService {

    private final VarRepository repository;

    private final Map<String, Integer> prioritiesMap = Map.of(
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
List <String> operations = new ArrayList<>();
        Matcher operationFinder = Pattern.compile(Patterns.OPERATION).matcher(expression);
while (operationFinder.find()){
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
        return repository.create(operands.get(0));
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
            String op = operations.get(i);
            if (currentPriority < prioritiesMap.get(op)) {
                currentPriority = prioritiesMap.get(op);
                index = i;
            }
        }
        return index;
    }
}
