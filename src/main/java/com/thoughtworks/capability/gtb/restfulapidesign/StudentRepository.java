package com.thoughtworks.capability.gtb.restfulapidesign;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class StudentRepository {
    private static final List<Student> studentList = new ArrayList<>();

    private StudentRepository() {
        studentList.add(new Student(1, "Jiajun", "male", "mfker"));
    }

    public List<Student> showStudentList(String gender) {
        if (gender == null) {
            return studentList;
        }
        return studentList.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudent(Integer studentID) {
        studentList.removeIf(student -> student.getId().equals(studentID));
    }

        public Student getSingleStudent(Integer studentID) throws Exception {
        for (Student student: studentList) {
            if (student.getId().equals(studentID)) {
                return student;
            }
        }
        throw new InstanceNotFoundException();
    }

}
