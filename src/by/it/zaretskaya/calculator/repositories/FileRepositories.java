package by.it.zaretskaya.calculator.repositories;

import by.it.zaretskaya.calculator.exeptions.ApplicationException;
import by.it.zaretskaya.calculator.model.Matrix;
import by.it.zaretskaya.calculator.model.Scalar;
import by.it.zaretskaya.calculator.model.Var;
import by.it.zaretskaya.calculator.model.Vector;
import by.it.zaretskaya.calculator.utils.Patterns;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileRepositories implements VarRepository {

    private final String txtDataBase;
    private final Map<String,Var> variables=new HashMap<>();

    public FileRepositories(String txtDataBase) {
        this.txtDataBase= txtDataBase;
        if (Files.exists(Paths.get(txtDataBase))){
        init(txtDataBase);
        }
    }

    private void init(String ignoredTxtDataBase) {
        try {
            List<String> strings = Files.readAllLines(Path.of(this.txtDataBase));
            for (String line : strings) {
                String[] split = line.split("=",2);
                String name = split[0];
                String value = split[1];
                Var var = create(value);
                variables.put(name,var);
            }

        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }

    @Override
    public Var save(String name, Var value) {
        variables.put(name,value);
       try(PrintWriter printWriter = new PrintWriter(txtDataBase)) {
           for (Map.Entry<String, Var> stringVarEntry : variables.entrySet()) {
               printWriter.printf("%s+%s%n",stringVarEntry.getKey(),stringVarEntry.getValue());

           }
       } catch (FileNotFoundException e) {
           throw new ApplicationException(e);
       }

        return value;
    }

    public  Var create(String varValueOrName)  {
        if (varValueOrName.matches(Patterns.SCALAR)){
            return new Scalar(varValueOrName);
        }else if (varValueOrName.matches(Patterns.VECTOR)){
            return new Vector(varValueOrName);
        }else if (varValueOrName.matches(Patterns.MATRIX)){
            return new Matrix(varValueOrName);
        }else if(variables.containsKey(varValueOrName)){
            return variables.get(varValueOrName);
        }

        throw new ApplicationException("not found"+varValueOrName);
    }
}
