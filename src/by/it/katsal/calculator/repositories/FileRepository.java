package by.it.katsal.calculator.repositories;

import by.it.katsal.calculator.exceptions.ApplacitionException;
import by.it.katsal.calculator.model.Matrix;
import by.it.katsal.calculator.model.Scalar;
import by.it.katsal.calculator.model.Var;
import by.it.katsal.calculator.model.Vector;
import by.it.katsal.calculator.utils.Patterns;

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

    private final String txtDataBase;
    private final Map<String, Var> variables = new HashMap<>();

    public FileRepository(String txtDataBase) {
        this.txtDataBase = txtDataBase;
        if (Files.exists(Paths.get(txtDataBase))) {
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
                Var var = create(value);
                variables.put(name, var);
            }
        } catch (IOException e) {
            throw new ApplacitionException(e);
        }
    }

    @Override
    public Var save(String name, Var value) {
        variables.put(name, value);
        try (PrintWriter printWriter = new PrintWriter(txtDataBase)) {
            for (Map.Entry<String, Var> entry : variables.entrySet()) {
                printWriter.printf("%s=%s%n", entry.getKey(), entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new ApplacitionException(e);
        }
        return value;
    }

    public Var create(String varValueOrName) {
        if (varValueOrName.matches(Patterns.SCALAR)) {
            return new Scalar(varValueOrName);
        } else if (varValueOrName.matches(Patterns.VECTOR)) {
            return new Vector(varValueOrName);
        } else if (varValueOrName.matches(Patterns.MATRIX)) {
            return new Matrix(varValueOrName);
        } else if (variables.containsKey(varValueOrName)) {
            return variables.get(varValueOrName);
        }
        throw new ApplacitionException("not found " + varValueOrName);
    }
}
