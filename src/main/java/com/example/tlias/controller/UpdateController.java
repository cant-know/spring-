package com.example.tlias.controller;

import com.example.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Controller
public class UpdateController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("上传文件");
        String path =  image.getOriginalFilename();
        int index = path.lastIndexOf(".");
        String extendName = path.substring(index);
        String newName = UUID.randomUUID().toString() + extendName;
        image.transferTo(new File("D:\\project" + newName));
        return Result.success();
    }
}
