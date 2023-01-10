package com.test;

import com.test2.Student;

public class TestPackage {
    public static void main(String[] args) {

        com.test2.Student stu1 = new com.test2.Student();

        com.test3.Student stu2 = new com.test3.Student();

        Student stu = new Student();

    }
}
