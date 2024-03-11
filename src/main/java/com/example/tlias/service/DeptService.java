package com.example.tlias.service;
import com.example.tlias.pojo.Dept;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {
    void add(Dept dept);

    List<Dept> list();

    void delete(Integer id);
}
