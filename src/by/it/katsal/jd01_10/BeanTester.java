package by.it.katsal.jd01_10;


import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args)throws Exception {


        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        Bean bean = beanClass.getConstructor().newInstance();


        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)){
                Param annotation = method.getAnnotation(Param.class);
                System.out.print(method.getName()+" ");
                System.out.println(method.invoke(bean, annotation.a(), annotation.b()));


            }
        }




    }
}



