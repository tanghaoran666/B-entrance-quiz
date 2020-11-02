package com.thoughtworks.capability.gtb.entrancequiz.bo;

import java.util.List;

// TODO GTB-完成度: - Group对象应该包含name属性
public class Group {
    private int id;
    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Group(int id, List<Student> students) {
        this.id = id;
        this.students = students;
    }
}
