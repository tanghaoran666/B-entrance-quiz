package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.bo.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:1234")
public class StudentsController {
    @Autowired
    StudentGroupService studentGroupService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = studentGroupService.getStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/student")
    public ResponseEntity createStudent(@RequestBody String name){
        studentGroupService.createStudent(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
