package com.example.projectdemospring.controller;

import com.example.projectdemospring.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController//default trả về data json
@RequestMapping(path = "api/hello")//đường dẫn
public class HelloController {
    @RequestMapping(path = "world", method = RequestMethod.GET)
     public String say(){
         return "hello world";
     }
     @RequestMapping(path = "talk", method = RequestMethod.GET)
     public String talk(){
         return "Talk to world";
     }
    @RequestMapping(path = "student", method = RequestMethod.GET)
     public Student getStudent(){
        return Student.builder()
                .rollNumber("A002")
                .fullName("Lap NV")
                .phone("0398408820")
                .build();
     }
}
