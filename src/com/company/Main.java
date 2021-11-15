package com.company;

public class Main {

    public static void main(String[] args) {
	// Class是模板，对象是实例
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());

        Class<? extends Car> aClass1 = car1.getClass();
        Class<? extends Car> aClass2 = car2.getClass();
        Class<? extends Car> aClass3 = car3.getClass();

        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());

        ClassLoader classLoader = aClass1.getClassLoader();//...CLASSPATH
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();//...jre/lib/ext/*.jar
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();//...jre/lib/rt.jar
        System.out.println(parent1);//null 获取不到

        //System.out.println("".getClass().getClassLoader());
    }
}
