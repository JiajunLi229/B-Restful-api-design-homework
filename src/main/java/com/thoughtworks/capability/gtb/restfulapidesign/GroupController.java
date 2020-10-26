package com.thoughtworks.capability.gtb.restfulapidesign;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    public List<Student> getStoredStudent(@PathVariable("id") Integer id) {
        return groupService.getStoredStudent(id);
    }

    @PatchMapping
    public void groupAllocation() {
        groupService.groupAllocation();
    }
}
