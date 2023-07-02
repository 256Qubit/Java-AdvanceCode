package com.test.static1;
/*
静态随着类的加载而加载，优先于对象存在
非静态需要在创建对象之后，才可以进行使用

1.静态方法中，只能访问静态成员（成员变量，成员方法）
2.非静态方法中，可以使用静态成员变量也可以使用非静态成员变量
3.静态方法中没有this关键字
 */

public class Student {
    String name;
    int age;
    static String school;

    public void show(){
        System.out.println(name+"..."+age+"..."+school);
        method();
    }
    public static void method(){

    }

}
