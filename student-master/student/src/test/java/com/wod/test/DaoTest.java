package com.wod.test;

import com.wod.dao.ManagerMapper;
import com.wod.dao.ScoresMapper;
import com.wod.dao.StudentMapper;
import com.wod.dao.TeacherMapper;
import com.wod.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

/**
 * @Author：童达
 * @date：2020/6/4 17:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DaoTest {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private ScoresMapper scoresMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void testStudentInsert(){
        Student student = new Student("2001003","王五","wrq");
        studentMapper.insert(student);
        System.out.println("插入成功！");
    }

    @Test
    public void testManagerSelectByExample(){
        ManagerExample managerExample = new ManagerExample();
        managerExample.createCriteria().andUsernameEqualTo("manager").andPasswordEqualTo("123");
        List<Manager> managerList = managerMapper.selectByExample(managerExample);
        managerList.forEach(System.out::println);
    }

    @Test
    public void  testStudentDeleteByStudentAccount(){
       /*
       可以执行，结果正确
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudentAccountEqualTo("2001003");
        int result = studentMapper.deleteByExample(studentExample);*/
       //可以执行，结果正确
       int result = studentMapper.deleteByPrimaryKey("2001004");
        System.out.println(result);
    }

    @Test
    public void testSelectAllStudnet(){
        List<Student> studentList = studentMapper.selectAllStudent();
        studentList.forEach(System.out::println);
    }

    @Test
    public void testSelectStudentScores(){
        List<StudentScores> studentScores = scoresMapper.selectStudentScores();
        studentScores.forEach(System.out::println);
    }

    @Test
    public void insertScores(){
        Scores scores = new Scores();
        scores.setStudentAccount("2001010");
        scores.setScore("85");
        scores.setCourseId("C004");
       int result = scoresMapper.insert(scores);
        System.out.println(result);
    }

    @Test
    public void testSelectAvgScoresSubject(){
        List<AvgScoresSubject> avgScoresSubjectList = scoresMapper.selectAvgScoresSubject();
        avgScoresSubjectList.forEach(System.out::println);
        System.out.println("--------------------------------------");
        for (int i=0;i<avgScoresSubjectList.size();i++){
            AvgScoresSubject avgScoresSubject = (AvgScoresSubject)avgScoresSubjectList.get(i);
            System.out.println("课程号："+avgScoresSubject.getCourseId()+"，课程名："+avgScoresSubject.getCourseName()+"，平均成绩："+avgScoresSubject.getAvgScore());
        }
    }

    @Test
    public void testSelectScoresPersonal(){
        List<StudentScores> studentScoresList = scoresMapper.selectScoresPersonal("2001003");
        for (int i=0;i<studentScoresList.size();i++){
            StudentScores studentScores = (StudentScores) studentScoresList.get(i);
            System.out.println("课程号："+studentScores.getCourseId()+"，课程名："+studentScores.getCourseName()+"，成绩："+studentScores.getScore());
        }
    }

    @Test
    public void testUpdateByPrimaryKeySelective(){
        Teacher teacher = new Teacher("1001002","15434");
        int result = teacherMapper.updateByPrimaryKeySelective(teacher);
        System.out.println(result);
    }
}
