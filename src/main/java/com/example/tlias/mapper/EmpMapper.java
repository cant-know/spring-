package com.example.tlias.mapper;

import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.PageBean;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select count(*) from emp")
    public long count();

//    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(@Param("start") Integer start,@Param("pageSize") Integer pageSize,String name, short gender, LocalDate begin, LocalDate end);

    @Select("select * from emp")
    public List<PageBean> test();

    @Select("select * from emp")
    public List<Emp> list();

//    @Delete("delete from emp where id in #{ids}")
    void delete(@Param("ids") List<Integer> ids);

    @Insert("INSERT INTO emp(username,name,gender,image,job,entrydate,dept_id,create_time,update_time) " +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{dept_id},#{create_time},#{update_time})")
    void post(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getUsernameAndPassword(Emp emp);
}
