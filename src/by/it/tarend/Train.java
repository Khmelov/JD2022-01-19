package by.it.tarend;

import by.it.tarend.calc.exceptions.CalcException;
import by.it.tarend.calc.services.CalcService;
import by.it.tarend.calc.utils.Patterns;

import java.util.Stack;

public class Train {
    public static void main(String[] args) throws CalcException {
        // D=((C-0.15)-20)/(7-5)
//       String expression = "D=((C-0.15)-20)/(7-5)";

        String expression = "C=B+(A*2)";


        int braceCounter = 0;
        int openBrace = expression.indexOf('(');
        int closeBrace = 0;
        for (int i = openBrace; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                braceCounter++;
            }
            if (expression.charAt(i) == ')') {
                braceCounter--;
            }
            if (braceCounter == 0) {
                closeBrace = i;
                break;
            }
        }
        String subExpression = expression.substring(openBrace + 1, closeBrace);
        System.out.println(subExpression);
        expression = expression.replace("("+subExpression+")", "77");

        System.out.println(expression);

    }
}
