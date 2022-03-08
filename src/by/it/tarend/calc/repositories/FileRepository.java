package by.it.tarend.calc.repositories;

import by.it.tarend.calc.exceptions.ApplicationException;
import by.it.tarend.calc.model.Matrix;
import by.it.tarend.calc.model.Scalar;
import by.it.tarend.calc.model.Var;
import by.it.tarend.calc.model.Vector;
import by.it.tarend.calc.utils.Patterns;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileRepository implements VarRepository{

    private final Map<String, Var> variables = new HashMap<>();
    private final String txtDataBase;

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
                String[] parts = line.split("=", 2);
                String name = parts[0];
                String value = parts[1];
                Var var = create(value);
                variables.put(name, var);
            }
        } catch (IOException e) {
            throw new ApplicationException(e);
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
            throw new ApplicationException(e);
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

        throw new ApplicationException("Unknown variable " + varValueOrName);
    }
}
