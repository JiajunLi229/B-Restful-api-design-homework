package com.thoughtworks.capability.gtb.restfulapidesign;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
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

    @GetMapping
    public List<Group> getGroupList() {
        return groupService.getGroupList();
    }

    @GetMapping("/{id}")
    public List<Student> getStoredStudent(@PathVariable("id") Integer id) {
        return groupService.getStoredStudent(id);
    }

    @PatchMapping
    public void groupAllocation() {
        groupService.groupAllocation();
    }

    @PostMapping("/{id}")
    public Group changeGroupName(@PathVariable Integer id, @RequestParam(name = "name") String name) {
        return groupService.changeGroupName(id, name);
    }
}
