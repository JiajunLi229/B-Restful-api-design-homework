package com.thoughtworks.capability.gtb.restfulapidesign;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {

    private final StudentService studentService;
    GroupRepository groupRepository;

    public GroupService(StudentService studentService, GroupRepository groupRepository) {
        this.studentService = studentService;
        this.groupRepository = groupRepository;
    }


    public void groupAllocation() {
        List<Student> studentList = studentService.showStudentList(null);
        Collections.shuffle(studentList);

        for (int studentNumber = 0, GroupNumber = 0; studentNumber < studentList.size(); studentNumber++) {
            List<Group> GroupList = groupRepository.getGroupList();
            GroupList.get(GroupNumber).getStudentList().add(studentList.get(studentNumber));

            if (GroupNumber != 5) {
                GroupNumber++;
            } else {
                GroupNumber = 0;
            }
        }
    }

    public List<Student> getStoredStudent(Integer id) {
        return groupRepository.getStoredStudent(id);
    }
}
