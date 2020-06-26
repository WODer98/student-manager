package com.wod.controller;

import com.wod.entity.Teacher;
import com.wod.service.TeacherService;
import com.wod.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author：童达
 * @date：2020/6/6 15:47
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping(value = "/login/auth",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseMessage login(@RequestParam String username,
                                 @RequestParam String password){
        Teacher teacher = new Teacher(username,password);
        boolean result = teacherService.findTeacherWithTeacherAccountAndTeacherPassword(teacher);
        return  result ? ResponseMessage.success() : ResponseMessage.error();
    }

}
