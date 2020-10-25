package com.thoughtworks.capability.gtb.restfulapidesign;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @GetMapping
    public List<Student> showStudentList(@RequestParam(name = "gender", required = false) String gender) {
        return studentService.showStudentList(gender);
    }

    @GetMapping("/{id}")
    public Student getSingleStudent(@PathVariable("id") Integer studentID) throws Exception {
        return studentService.getSingleStudent(studentID);
    }
}
