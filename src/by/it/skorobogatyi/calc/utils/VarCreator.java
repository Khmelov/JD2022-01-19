package by.it.skorobogatyi.calc.utils;

import by.it.skorobogatyi.calc.exceptions.CalcException;
import by.it.skorobogatyi.calc.logger.Logger;
import by.it.skorobogatyi.calc.resources.LocalisationManager;
import by.it.skorobogatyi.calc.variables.*;

import java.util.Locale;

public class VarCreator {


    public static AbstractVar create(String varValue) throws CalcException {

        String messageForLogger;

        varValue = varValue.replaceAll(" ", "");

        if (varValue.matches(CustomPatterns.SCALAR)) {
            return new Scalar(varValue);

        } else if (varValue.matches(CustomPatterns.VECTOR)) {
            return new Vector(varValue);

        } else if (varValue.matches(CustomPatterns.MATRIX)) {
            return new Matrix(varValue);

        } else if (varValue.matches(CustomPatterns.VARIABLE)) {

            if (VariablesStorage.variables.containsKey(varValue)) {
                return VariablesStorage.variables.get(varValue);
            } else {
                return new Variable(varValue);
            }

        } else if (varValue.matches(CustomPatterns.COMMAND_PRINTVAR)) {
            System.out.println(VariablesStorage.printVar());
            return null;

        } else if (varValue.matches(CustomPatterns.COMMAND_SORTVAR)) {
            System.out.println(VariablesStorage.sortVar());
            return null;

        }  else if (varValue.matches(CustomPatterns.COMMAND_CHANGE_LANGUAGE_RU)) {
            LocalisationManager.INSTANCE.set(new Locale("ru", "RU"));
            messageForLogger = "Язык изменён на русский";
            Logger.getInstance().info(messageForLogger);
            System.out.println(messageForLogger);


        }  else if (varValue.matches(CustomPatterns.COMMAND_CHANGE_LANGUAGE_EN)) {
            LocalisationManager.INSTANCE.set(new Locale("en", "US"));
            messageForLogger = "Changing language to English";
            Logger.getInstance().info(messageForLogger);
            System.out.println(messageForLogger);


        }  else if (varValue.matches(CustomPatterns.COMMAND_CHANGE_LANGUAGE_BY)) {
            LocalisationManager.INSTANCE.set(new Locale("be", "BY"));
            messageForLogger = "Витаю, сябра, гэта калькулятар с беларускай мовай";
            Logger.getInstance().info(messageForLogger);
            System.out.println(messageForLogger);

        }
        throw new CalcException("");
    }
}
