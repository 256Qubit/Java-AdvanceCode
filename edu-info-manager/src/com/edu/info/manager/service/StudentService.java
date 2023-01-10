package com.edu.info.manager.service;

import com.edu.info.manager.dao.StudentDao;
import com.edu.info.manager.domain.Student;

//Service包，业务员用于负责业务逻辑的处理
public class StudentService {
    public boolean addStudent(Student stu) {
        //1.创建StudentDao(仓库管理)

        StudentDao studentDao = new StudentDao();

        return studentDao.addStudent(stu);
    }
}
