package com.example.spring_boot.service;

import com.example.spring_boot.model.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> getAllLessons(Long courseId);

    void addLesson(Long id, Lesson lesson);

    Lesson getLessonById(Long id);

    void updateLesson(Lesson lesson, Long id);

    void deleteLesson(Long id);
}
