package com.edu.info.manager.controller;

import com.edu.info.manager.domain.Student;

import com.edu.info.manager.service.StudentService;

import java.util.Scanner;

//controller包 客服接待，与用户打交道
public class StudentController {

    private StudentService studentService = new StudentService();

    private Scanner sc = new Scanner(System.in);
    //开启学生管理系统，并展示学生管理系统菜单
    public void start() {
        //Scanner sc = new Scanner(System.in);
        Ring:while (true) {
            System.out.println("[学生管理系统]");

            System.out.println("[请输入相应数字访问相关功能]");

            System.out.println("1 添加学生");

            System.out.println("2 删除学生");

            System.out.println("3 修改学生");

            System.out.println("4 查询学生");

            System.out.println("5 退出");

            String choice = sc.next();

            switch (choice) {
                case "1":
                    System.out.println("[添加学生]");
                    addStudent();
                    break;
                case "2":
                    System.out.println("[删除学生]");
                    break;
                case "3":
                    System.out.println("[修改学生]");
                    deleteStudentById();
                    break;
                case "4":
                    System.out.println("[查询学生]");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("[退出]");
                    break Ring;
                default:
                    System.out.println("[输入错误]");
                    break;

            }
        }
    }

    public void deleteStudentById() {
        String delId;
        while (true){

            System.out.println("请输入您需要删除的学生ID");
            delId= sc.next();
            boolean exists = studentService.isExists(delId);
            if (!exists) {
                System.out.println("您输入的ID不存在，请查证后输入：");
            }
            else {
                break;
            }
        }
        studentService.deleteStudentById(delId);
        System.out.println("删除成功");


    }

    public void findAllStudent() {

        //1.调用业务员中的获取方法，得道学生数组

       Student[] stus=studentService.findAllStudent();
       //2.判断数组中的地址是否为null
       if (stus == null) {
           System.out.println("查无信息，请添加后重试");
           return;
       }
       //3.遍历数组，获取学生信息并打印在控制台
       System.out.println("学号\t\t姓名\t年龄\t生日");

       for (int i = 0; i < stus.length; i++) {
           Student stu = stus[i];
           if (stu == null) {
               System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t\t"+stu.getBirthday());
           }
       }
    }

    public void addStudent() {
        //1.键盘接受学生信息
        //StudentService studentService = new StudentService();

        //Scanner sc = new Scanner(System.in);

        String stuId;

        while(true){
            System.out.println("输入学生id");
            stuId = sc.next();
            boolean flag=studentService.isExists(stuId);
            if (flag) {
                System.out.println("学号已存在，请重新输入。");
            }else {
                break;
            }
        }

        System.out.println("输入学生姓名");
        String stuName = sc.next();
        System.out.println("输入学生年龄");
        int stuAge = sc.nextInt();
        System.out.println("输入学生生日");

        //2.将学生信息封装为学生对象

        String stuBirthday = sc.next();
        Student stu = new Student();
        stu.setId(stuId);
        stu.setName(stuName);
        stu.setAge(stuAge);
        stu.setBirthday(stuBirthday);

        //3.将学生对象，传递给StudentService(业务员)中的addStudent()方法



        boolean result = studentService.addStudent(stu);

        if (result) {
            System.out.println("添加成功");
        }
        else {
            System.out.println("添加失败");
        }
    }
}
