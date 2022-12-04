package com.example.spring_boot.service.impl;

import com.example.spring_boot.model.Course;
import com.example.spring_boot.repository.CourseRepository;
import com.example.spring_boot.repository.GroupRepository;
import com.example.spring_boot.service.GroupService;
import lombok.RequiredArgsConstructor;
import com.example.spring_boot.model.Group;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;



    @Override
    public List<Group> getAllListGroups() {
        return groupRepository.findAll();
    }

    @Override
    public List<Group> getAllGroups(Long courseId) {
        return courseRepository.getById(courseId).getGroupList();
    }

    @Override
    public void addGroup(com.example.spring_boot.model.Group group, Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        course.addGroup(group);
        group.addCourse(course);
        groupRepository.save(group);

    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public void updateGroup(com.example.spring_boot.model.Group group, Long id) {
        Group group1 = groupRepository.findById(id).get();
        group1.setGroupName(group.getGroupName());
        group1.setId(group.getId());
        group1.setImage(group.getImage());
        groupRepository.save(group1);

    }

    @Override
    public void deleteGroup(Long id) {
        Group group = getGroupById(id);
        for (Course c: group.getCourseList()) {
            c.getGroupList().remove(group);
        }
        group.setCourseList(null);
        groupRepository.delete(group);
    }



    @Override
    public void assignGroup(Long courseId, Long groupId) throws IOException {
        Group group = groupRepository.findById(groupId).get();
        Course course = courseRepository.findById(courseId).get();
        if (course.getGroupList() != null) {
            for (Group g : course.getGroupList()) {
                if (g.getId() == courseId) {
                    throw new IOException("This group already exists!");
                }
            }
        }
        group.addCourse(course);
        course.addGroup(group);
        courseRepository.save(course);
        groupRepository.save(group);
    }
}