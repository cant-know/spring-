package com.example.tlias.controller;

import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.PageBean;
import com.example.tlias.pojo.Result;
import com.example.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, short gender,
                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate end){
        log.info("查询页数:{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageBean pageBean =  empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public Result test(){
        List<PageBean> empList = empService.test();
           return Result.success(empList);
    }

    @RequestMapping(value = "/emps/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除信息");
        empService.delete(ids);
        return Result.success();
    }

    @RequestMapping(value = "/emps",method = RequestMethod.POST)
    @ResponseBody
    public Result post(@RequestBody Emp emp){
        log.info("新增员工");
        empService.post(emp);
        return Result.success();
    }

    @RequestMapping(value = "/emps/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询员工信息,{}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @RequestMapping(value = "/emps",method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息");
        empService.update(emp);
        return Result.success();
    }
}
