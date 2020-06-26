package com.wod.service;

import com.wod.dao.StudentMapper;
import com.wod.entity.Student;
import com.wod.entity.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：童达
 * @date：2020/6/6 17:02
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询单个学生的信息
     * @param student
     * @return
     */
    public boolean findStudentWithStudentAccountAndStudentPassword(Student student){
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudentAccountEqualTo(student.getStudentAccount())
                .andStudentPasswordEqualTo(student.getStudentPassword());
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        return studentList != null && studentList.size() == 1;
    }

    /**
     * 根据StudentAccount删除学生
     * @param studentAccount
     * @return
     */
    public boolean deleteStudentByStudentAccount(String  studentAccount){
        int result = studentMapper.deleteByPrimaryKey(studentAccount);
        return result == 1;

    }

    /**
     * 查询所有学生的信息
     */
    public List<Student> findAllStudents(){
        return studentMapper.selectAllStudent();
    }
}
