package com.example.tlias.controller;

import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.Result;
import com.example.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody Emp emp){
        log.info("员工登录:{}",emp);
        Emp e = empService.login(emp);
        return e != null?Result.success(e):Result.error("用户名或密码错误");
    }
}
