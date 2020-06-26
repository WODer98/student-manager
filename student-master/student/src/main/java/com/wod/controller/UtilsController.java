package com.wod.controller;

import com.wod.entity.*;
import com.wod.service.ScoresService;
import com.wod.service.StudentService;
import com.wod.service.TeacherService;
import com.wod.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author：童达
 * @date：2020/6/9 10:48
 */
@Controller
@RequestMapping("/u")
public class UtilsController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ScoresService scoresService;

    @GetMapping("/student/all")
    @ResponseBody
    public ResponseMessage findAllStudent() {
        List<Student> studentList = studentService.findAllStudents();
        return studentList.size() > 0 ?
                ResponseMessage.success().addObject("studentList", studentList)
                : ResponseMessage.error();
    }

    @GetMapping("/student/delete/{studentAccount}")
    @ResponseBody
    public ResponseMessage deleteStudentByAccount(@PathVariable String studentAccount
                                     ){
         boolean result = studentService.deleteStudentByStudentAccount(studentAccount);
         return result ? ResponseMessage.success() : ResponseMessage.error();
    }

    @GetMapping("/teacher/all")
    @ResponseBody
    public ResponseMessage findAllTeacher(){
        List<Teacher> teacherList = teacherService.selectAllTeacher();
        return teacherList.size() > 0 ?
                ResponseMessage.success().addObject("teacherList",teacherList)
                : ResponseMessage.error();
    }

    @GetMapping("/teacher/scores")
    @ResponseBody
    public ResponseMessage selectStudentScores(){
        List<StudentScores> studentScores = scoresService.selectStudentScores();
        return studentScores.size() > 0 ?
                ResponseMessage.success().addObject("studentScores",studentScores)
                : ResponseMessage.error();
    }

    @PostMapping("/teacher/scores/add")
    @ResponseBody
    public ResponseMessage insertScores(@RequestParam String score,
                             @RequestParam String studentAccount,
                             @RequestParam String courseId){

        Scores scores = new Scores(score,studentAccount,courseId);
        boolean result = scoresService.insert(scores);
        if (result){
            return ResponseMessage.success();
        }else {
            return ResponseMessage.error().addObject("msg","该学生的同一科目已有成绩，请检查后输入！3秒钟后重新跳转");
        }
    }

    @GetMapping("/teacher/scores/avg")
    @ResponseBody
    public ResponseMessage selectAvgScoresSubject(){
        List<AvgScoresSubject> avgScoresSubjectList = scoresService.selectAvgScoresSubject();
        avgScoresSubjectList.forEach(System.out::println);
        return avgScoresSubjectList.size()>0 ?
                ResponseMessage.success().addObject("avgSubjects",avgScoresSubjectList) :
                ResponseMessage.error();
    }

    @RequestMapping("/teacher/update")
    @ResponseBody
    public ResponseMessage updateByPrimaryKey(@RequestParam String teacherAccount,
                                              @RequestParam String password){
        Teacher teacher = new Teacher(teacherAccount,password);
        int result = teacherService.updateByPrimaryKey(teacher);
        return result == 1 ? ResponseMessage.success():
                ResponseMessage.error();
    }
}
