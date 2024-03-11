package com.example.tlias.service.impl;

import com.example.tlias.mapper.EmpMapper;
import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.PageBean;
import com.example.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, short gender, LocalDate begin, LocalDate end){
        long count = empMapper.count();

        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start,pageSize,name,gender,begin,end);

        PageBean pageBean = new PageBean(count,empList); 
        return pageBean;
    }

    @Override
    public List<PageBean> test(){
        return empMapper.test();
    }

    @Override
    public void delete(List<Integer> ids){
        empMapper.delete(ids);
    }

    @Override
    public void post(Emp emp){
        emp.setCreate_time(LocalDateTime.now());
        emp.setUpdate_time(LocalDateTime.now());
        empMapper.post(emp);
    }

    @Override
    public Emp getById(Integer id){
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp){
        emp.setUpdate_time(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp){
        return empMapper.getUsernameAndPassword(emp);
    }

}
