package com.example.tlias.controller;

import com.example.tlias.pojo.Result;
import com.example.tlias.service.DeptService;
import com.example.tlias.pojo.Dept;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @ResponseBody
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @RequestMapping(value = "/depts/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result Delete(@PathVariable Integer id){
        log.info("删除部门表:{}",id);
        deptService.delete(id);
        return Result.success();
    }

    @RequestMapping(value = "/depts",method = RequestMethod.POST)
    @ResponseBody
    public Result Add(@RequestBody Dept dept){
        log.info("查询部门表:{}",dept);
        deptService.add(dept);
        return Result.success();
    }
}
