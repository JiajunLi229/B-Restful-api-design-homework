package com.thoughtworks.capability.gtb.restfulapidesign.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private Integer id;
    private String name;
    private String note;
    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }
}
