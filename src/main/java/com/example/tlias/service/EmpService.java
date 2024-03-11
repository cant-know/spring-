package com.example.tlias.service;

import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {

    PageBean page(Integer page, Integer pageSize, String name, short gender, LocalDate begin, LocalDate end);

    List<PageBean> test();

    void delete(List<Integer> ids);

    void post(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
