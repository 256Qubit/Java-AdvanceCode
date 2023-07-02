package com.test.static1;
/*
1.被static修饰的成员变量，会被该类的所有对象共享
2.被static修饰的成员变量，会随着类的加载而加载，优先于对象存在
3.多了一种调用方式，可以通过类名.的方式去调用
 */
public class Test1Static {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.name= "张三";
        stu1.age = 23;
        //stu1.school="黑马达摩院";
        Student.school="黑马达摩院";
        stu1.show();

        Student stu2 = new Student();
        stu2.show();
        stu1.show();
    }
}
