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
}
