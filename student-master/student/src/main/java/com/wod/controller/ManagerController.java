package com.wod.controller;

import com.wod.entity.Manager;
import com.wod.service.ManagerService;
import com.wod.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author：童达
 * @date：2020/6/5 15:57
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping(value = "/login/auth",produces = {"application/json;charset=UTF-8"})
    @ResponseBody   //序列化-->类型转换-->Json
    public ResponseMessage login(@RequestParam String username,
                                 @RequestParam String password){
        Manager manager = new Manager(username,password);
        boolean result = managerService.findManagerWithUsernameAndPassword(manager);
        return result ? ResponseMessage.success() : ResponseMessage.error();
    }
}
