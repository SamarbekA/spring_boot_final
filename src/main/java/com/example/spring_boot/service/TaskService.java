package com.example.spring_boot.service;

import com.example.spring_boot.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks(Long lessonId);

    void addTask(Long id, Task task);

    Task getTaskById(Long id);

    void updateTask(Task task, Long id);

    void deleteTask(Long id);
}
