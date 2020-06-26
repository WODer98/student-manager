package com.wod.controller;

import com.wod.entity.Student;
import com.wod.entity.StudentScores;
import com.wod.service.ScoresService;
import com.wod.service.StudentService;
import com.wod.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author：童达
 * @date：2020/6/6 17:10
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ScoresService scoresService;

    @PostMapping(value = "/login/auth",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseMessage login(@RequestParam String username,
                                 @RequestParam String password,
                                 HttpSession session){
        Student student = new Student(username,password);
        boolean result = studentService.findStudentWithStudentAccountAndStudentPassword(student);
        session.setAttribute("studentAccount",student.getStudentAccount());
        session.setAttribute("studentName",student.getStudentName());
        return result ? ResponseMessage.success() : ResponseMessage.error();
    }

    @GetMapping("/scores/personal")
    @ResponseBody
    public ResponseMessage selectScoresPersonal(HttpSession session){
        //获取当前登录的学生
        String studentAccount = (String) session.getAttribute("studentAccount");
        if (studentAccount == null){
            return ResponseMessage.error().addObject("msg","没有查询的学生id");
        }
        List<StudentScores> studentScoresList = scoresService.selectScoresPersonal(studentAccount);
        return studentScoresList.size() >0 ? ResponseMessage.success().addObject("scores",studentScoresList)
                : ResponseMessage.error();
    }
}
