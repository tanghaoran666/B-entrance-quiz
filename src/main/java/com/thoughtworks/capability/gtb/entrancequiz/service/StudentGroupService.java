package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.bo.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentGroupService {
    List<Student> students = new ArrayList<>();
    {
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

    public void createStudent(String name) {
        Student student = new Student(students.size()+1,name);
        students.add(student);
    }

    public Map getGroups() {
        Map<Integer,List<Student>> groups = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            groups.put(i,new ArrayList<>());
        }
        List<Student> randomLists = new ArrayList<>();
        for (Student student : students) {
            randomLists.add(student);
        }
        Collections.shuffle(randomLists);
        int groupIndex = 1;
        for (int i = 0; i < randomLists.size(); i++) {
            groups.get(groupIndex).add(randomLists.get(i));
            groupIndex++;
            if(groupIndex == 7) groupIndex=1;
        }
        Map<String,List<Student>> groupMap = new HashMap<>();
        groupMap.put("one",groups.get(1));
        groupMap.put("two",groups.get(2));
        groupMap.put("three",groups.get(3));
        groupMap.put("four",groups.get(4));
        groupMap.put("five",groups.get(5));
        groupMap.put("six",groups.get(6));
        return groupMap;

    }
}
