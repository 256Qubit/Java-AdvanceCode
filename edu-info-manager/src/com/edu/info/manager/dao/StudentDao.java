package com.edu.info.manager.dao;

import com.edu.info.manager.domain.Student;

//Dao包 仓库管理 用于数据的增删改查
public class StudentDao {
    private static Student[] students = new Student[5];
    public boolean addStudent(Student stu) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student == null) {
                index =i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        else {
            students[index]=stu;
            return true;
        }
    }


    public Student[] findAllStudent() {

        return students;
    }


    public void deleteStudentById(String delId) {
        int index = getIndex(delId);

        students[index]=null;
    }
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            Student stu = students[i];
            if (stu != null&&stu.getId().equals(id)) {
                index=i;
                break;
            }
        }
        return index;
    }
}
