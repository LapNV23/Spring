package com.example.projectdemospring.controller;

import com.example.projectdemospring.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * http"//localhost:8080/api/v1/students | GET | return list student
 * http"//localhost:8080/api/v1/students | POST | create list student
 * http"//localhost:8080/api/v1/students/1 | DELETE | remove student
 * http"//localhost:8080/api/v1/students/1 | GET | find student by id
 * http"//localhost:8080/api/v1/students/1 | PUT | update student
 *
 */
@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    //full option CRUD

    private static List<Student> list;

    public StudentController() {
        list = new ArrayList<>();
        list.add(Student.builder().rollNumber("A002").fullName("NV Lap").build());
        list.add(Student.builder().rollNumber("A003").fullName("NV").build());
        list.add(Student.builder().rollNumber("A004").fullName("Van").build());
        list.add(Student.builder().rollNumber("A005").fullName("Nguyen").build());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll(){
        return list;
    }

    // Path Variable
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Student findById(@PathVariable String id){
        int foundIndex = -1;
        for(int i = 0; i<list.size();i++){
            if (list.get(i).getRollNumber().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return null;
        }
        return list.get(foundIndex);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        list.add(student);
        return student;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public boolean deleteById(@PathVariable String id){
        int foundIndex = -1;
        for (int i =0;i<list.size();i++){
            if (list.get(i).getRollNumber().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return false;
        }
        list.remove(foundIndex);
        return true;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public  Student updateById(@PathVariable String id, @RequestBody Student updateStudent){
        int foundIndex = -1;
        for (int i =0;i<list.size();i++){
            if (list.get(i).getRollNumber().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return null;
        }
        Student existing = list.get(foundIndex);
        existing.setFullName(updateStudent.getFullName());
        return existing;
    }
}
