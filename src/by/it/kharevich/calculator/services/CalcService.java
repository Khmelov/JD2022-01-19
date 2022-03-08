package by.it.kharevich.calculator.services;

import by.it.kharevich.calculator.exceptions.CalcException;
import by.it.kharevich.calculator.repository.VarRepository;
import by.it.kharevich.calculator.resources.ResourceManager;
import by.it.kharevich.calculator.utils.ExceptionMessages;
import by.it.kharevich.calculator.utils.Patterns;
import by.it.kharevich.calculator.model.Var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcService {

    private final VarRepository repository;

    private final Map<String, Integer> priorityMap = Map.of("=",0,"+",1,"-",1,"*",2,"/",2);

    public CalcService(VarRepository repository) {
        this.repository = repository;
    }


    public Var calc(String expression) throws CalcException {
        expression = expression.replaceAll(Patterns.SPACES, "");
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher operationFinder = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (operationFinder.find()){
            operations.add(operationFinder.group());
        }
        while (!operations.isEmpty()){
            int index = getIndexOperation(operations);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String operation = operations.remove(index);
            Var result = calcOneOperation(left,operation,right);
            operands.add(index,result.toString());
        }
        return repository.create(operands.get(0));
    }

    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {

        Var right = repository.create(rightStr);
        if (operation.equals("=")) {
            return repository.save(leftStr, right);
        }
        Var left = repository.create(leftStr);
        if (left == null || right == null) {
            throw new CalcException(ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_IO)+ " " + leftStr + operation + rightStr);
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
        throw new CalcException(ResourceManager.INSTANCE.get(ExceptionMessages.MESSAGE_IOS));
    }

    private int getIndexOperation(List<String> operations) {
        int index = -1;
        int currentPriority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operationE = operations.get(i);
            if (currentPriority< priorityMap.get(operationE)){
                currentPriority = priorityMap.get(operationE);
                index = i;
            }
        }
        return index;
    }
}
