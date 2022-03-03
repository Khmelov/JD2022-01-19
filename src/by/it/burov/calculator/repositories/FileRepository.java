package by.it.burov.calculator.repositories;

import by.it.burov.calculator.ecxeptions.ApplicationException;
import by.it.burov.calculator.model.Matrix;
import by.it.burov.calculator.model.Scalar;
import by.it.burov.calculator.model.Var;
import by.it.burov.calculator.model.Vector;
import by.it.burov.calculator.utils.Patterns;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileRepository implements VarRepository {

    private final Map<String, Var> variables = new HashMap<>();

    private final String txtDataBase;

    public FileRepository(String txtDataBase) {
        this.txtDataBase = txtDataBase;
        if(Files.exists(Paths.get(txtDataBase))) {
            init(txtDataBase);
        }
    }

    private void init(String txtDataBase) {
        try {
            List<String> strings = Files.readAllLines(Path.of(txtDataBase));
            for (String line : strings) {
                String[] split = line.split("=", 2);
                String name = split[0];
                String value = split[1];
                Var var = createVar(value);
                variables.put(name, var);

            }
        } catch (IOException e) {
            new ApplicationException(e);
        }
    }

    @Override
    public Var saveVars(String name, Var value) {
        variables.put(name, value);
        try (PrintWriter writer = new PrintWriter(txtDataBase);
        ) {
            for (Map.Entry<String, Var> entry : variables.entrySet()) {
                writer.printf("%s=%s%n", entry.getKey(), entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new ApplicationException(e);
        }

        return null;
    }

    @Override
    public Var createVar(String varValueForName) {
        if (varValueForName.matches(Patterns.SCALAR)) {
            return new Scalar(varValueForName);
        } else if (varValueForName.matches(Patterns.VECTOR)) {
            return new Vector(varValueForName);
        } else if (varValueForName.matches(Patterns.MATRIX)) {
            return new Matrix(varValueForName);
        } else if (variables.containsKey(varValueForName)) {
            return variables.get(varValueForName);
        }

        throw new ApplicationException("not found " + varValueForName);
    }
}
