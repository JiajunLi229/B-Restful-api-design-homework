package com.thoughtworks.capability.gtb.restfulapidesign;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class StudentRepository {
    private static final List<Student> studentList = new ArrayList<>();

    private StudentRepository() {
        studentList.add(new Student(1, "Jiajun", "male", "mfker"));
    }

    public List<Student> showStudentList() {
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudent(Integer studentID) {
        studentList.removeIf(student -> student.getId().equals(studentID));
    }

}
