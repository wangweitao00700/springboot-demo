package com.example.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/index.html")
    public String toIndex() {
        return "index";
    }
    @RequestMapping("/students.html")
    public String students(Map<String,Object> map){
        System.out.println("呵呵呵呵");
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            Student student = new Student();
            student.setName("张三"+i);
            student.setAge(23+i);
            list.add(student);
        }
        map.put("sList",list);
        logger.info("studentsList:{}",list);
        return "students";
    }

    @RequestMapping("/student/{name}.html")
    public String student(@PathVariable(name = "name")String name,Map<String,Object> map){
        Student student = new Student();
        student.setName(name);
        student.setAge(23);
        map.put("student",student);
        return "student";
    }
}
