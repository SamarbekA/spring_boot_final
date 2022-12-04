package com.example.spring_boot.service;

import com.example.spring_boot.model.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<Student> getStudentList();

    List<Student> getAllStudents(Long groupId);

    void addStudent(Long id,Student student) throws IOException;

    Student getStudentById(Long id);

    void updateStudent(Student student, Long id);

    void deleteStudent(Long id);

    void assignStudent(Long groupId,Long studentId) throws IOException;
}