package com.thoughtworks.capability.gtb.restfulapidesign;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.InstanceNotFoundException;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteStudent(Integer studentId) {
        studentRepository.deleteStudent(studentId);
    }

    public List<Student> showStudentList(String gender) {
        return studentRepository.showStudentList(gender);
    }

    public Student getSingleStudent(Integer studentID) throws Exception {
        return studentRepository.getSingleStudent(studentID);
    }

    public Student updateStudent(Integer id, Student student) throws Exception {
        return studentRepository.updateStudent(id, student);
    }
}
