package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.bo.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentGroupService {
    List<Student> students = new ArrayList<>();

    public void init() {
        students.add(new Student(1,"成吉思汗"));
        students.add(new Student(2,"鲁班七号"));
        students.add(new Student(3,"太乙真人"));
        students.add(new Student(4,"钟无艳"));
        students.add(new Student(5,"花木兰"));
        students.add(new Student(6,"雅典娜"));
        students.add(new Student(7,"芈月"));
        students.add(new Student(8,"白起"));
        students.add(new Student(9,"刘禅"));
        students.add(new Student(10,"庄周"));
        students.add(new Student(11,"马超"));
        students.add(new Student(12,"刘备"));
        students.add(new Student(13,"哪吒"));
        students.add(new Student(14,"大乔"));
        students.add(new Student(15,"蔡文姬"));
    }

    public List<Student> getStudents() {
        return students;
    }
}
