package by.it.zaretskaya.calculator.model;

import by.it.zaretskaya.calculator.exeptions.CalcException;


public abstract class Var implements Operation {

    @Override
     public Var add(Var other) throws CalcException {
       throw new CalcException( String.format("Operation addition %s + %s impossible%n",this,other));

     }

     @Override
     public Var sub(Var other) throws CalcException{
         throw new CalcException( String.format("Operation subtraction %s - %s impossible%n",this,other));

     }

     @Override
     public Var mul(Var other) throws CalcException{
         throw new CalcException( String.format("Operation multiplication %s * %s impossible%n",this,other));

     }

     @Override
     public Var div(Var other) throws CalcException {
         throw new CalcException( String.format("Operation division %s / %s impossible%n",this,other));

     }

    @Override
      public String toString() {
        return "abstract variable{}";
    }
}
