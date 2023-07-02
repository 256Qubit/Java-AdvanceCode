package com.edu.info.manager.service;

import com.edu.info.manager.dao.StudentDao;
import com.edu.info.manager.domain.Student;

//Service包，业务员用于负责业务逻辑的处理
public class StudentService {
    private StudentDao studentDao = new StudentDao();
    public boolean addStudent(Student stu) {
        //1.创建StudentDao(仓库管理)

        return studentDao.addStudent(stu);
    }

    public boolean isExists(String stuId) {

        Student[] stus=studentDao.findAllStudent();

        boolean exists = false;

        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student !=null&&student.getId().equals(stuId)){
                exists =true;
                break;
            }
        }
        return exists;
    }

    public Student[] findAllStudent() {
        //1.调用库管对象的findALLstudent获取学生对象数组
        Student[] allStudent = studentDao.findAllStudent();
        //2.判断数组中是否有学生信息
        //数组中只要存在一个不是null的元素，那就代表有学生信息
        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            Student stu=allStudent[i];
            if (stu != null) {
                flag=true;
                break;
            }
        }
        if (flag){
            return allStudent;
        }else {
            return null;
        }
    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }
}
