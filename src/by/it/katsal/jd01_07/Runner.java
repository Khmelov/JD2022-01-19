package by.it.katsal.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar var1=new Scalar("1234.5678");
        System.out.println(var1);
        Var var2 = new Scalar(2.22);
        System.out.println(var2);
        Var var3 = new Scalar(var1);
        System.out.println(var3);
        Var var4 = new Vector(new double[] {1,2,3,4});
        System.out.println(var4);



    }
}



