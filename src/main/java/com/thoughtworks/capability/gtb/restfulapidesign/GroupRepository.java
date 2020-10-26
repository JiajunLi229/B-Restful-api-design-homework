package com.thoughtworks.capability.gtb.restfulapidesign;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class GroupRepository {
    private List<Group> groupList = new ArrayList<>();

    public GroupRepository() {
        Group group1 = new Group(1, "1", "note", new ArrayList<>());
        Group group2 = new Group(2, "2", "note", new ArrayList<>());
        Group group3 = new Group(3, "3", "note", new ArrayList<>());
        Group group4 = new Group(4, "4", "note", new ArrayList<>());
        Group group5 = new Group(5, "5", "note", new ArrayList<>());
        Group group6 = new Group(6, "6", "note", new ArrayList<>());

        groupList.add(group1);
        groupList.add(group2);
        groupList.add(group3);
        groupList.add(group4);
        groupList.add(group5);
        groupList.add(group6);
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public List<Student> getStoredStudent(Integer id) {

        return groupList.stream().filter(group -> group.getId().equals(id)).map(Group::getStudentList).findFirst().orElse(null);


    }

    public Group changeGroupName (Integer id, String name) {
        Group returnedGroup = groupList.stream().filter(group -> group.getId().equals(id)).findFirst().orElse(null);
        if (returnedGroup != null) {
            returnedGroup.setName(name);
        }
        return returnedGroup;
    }


}
