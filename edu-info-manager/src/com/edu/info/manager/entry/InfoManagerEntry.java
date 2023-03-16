package com.edu.info.manager.entry;

import com.edu.info.manager.controller.StudentController;

import java.util.Scanner;

//程序入口点
public class InfoManagerEntry {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.println("[信息管理系统]");

            System.out.println("[请输入相应数字访问相关功能]");

            System.out.println("1 学生管理");

            System.out.println("2 教师管理");

            System.out.println("3 退出");

            String choice = sc.next();
            switch (choice){
                case "1":
                    System.out.println("[学生管理]");
                    StudentController studentController = new StudentController();
                    studentController.start();
                    break;
                case "2":
                    System.out.println("[教师管理]");
                    break;
                case "3":
                    System.out.println("[退出程序]");
                    System.exit(0);//退出当前正在运行的JVM虚拟机
                    break;
                default:
                    System.out.println("[输入错误]");
                    break;
            }
        }

    }
}
