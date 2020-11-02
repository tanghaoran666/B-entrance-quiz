package com.thoughtworks.capability.gtb.entrancequiz.api;

// TODO GTB-工程实践: - 未使用的import语句
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.bo.Group;
import com.thoughtworks.capability.gtb.entrancequiz.bo.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:1234")
public class StudentsController {

    // TODO GTB-知识点: - 推荐使用构造器注入
    @Autowired
    StudentGroupService studentGroupService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = studentGroupService.getStudents();
        return ResponseEntity.ok(students);
    }

    // TODO GTB-知识点: - 违反Restful实践, url不合理
    @PostMapping("/student")
    public ResponseEntity createStudent(@RequestBody String name){
        studentGroupService.createStudent(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getGroups(){
        List<Group> groups = studentGroupService.getGroups();
        return ResponseEntity.ok(groups);
    }

    @PostMapping("/groups")
    // TODO GTB-知识点: - 违反Restful实践, Post请求成功后应该返回201
    public ResponseEntity<List<Group>> divideGroups(){
        studentGroupService.divideGroups();
        List<Group> groups = studentGroupService.getGroups();
        return ResponseEntity.ok(groups);
    }

}
