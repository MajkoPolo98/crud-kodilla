package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DbServiceTest {

    @InjectMocks
    DbService dbService;

    @Mock
    TaskRepository taskRepository;

    @Test
    void getAllTasks() {
        //Given
        Task task1 = new Task(1L, "title1", "content");
        Task task2 = new Task(2L, "title2", "content");
        List<Task> taskList = List.of(task1, task2);

        when(taskRepository.findAll()).thenReturn(taskList);

        //When
        List<Task> tasks = dbService.getAllTasks();

        //Then
        assertEquals(taskList.size(), tasks.size());

    }

    @Test
    void saveTask() {
        //Given
        Task task1 = new Task(1L, "title1", "content");

        when(taskRepository.save(task1)).thenReturn(task1);

        //When
        Task task = dbService.saveTask(task1);

        //Then
        assertEquals(task1.getId(), task.getId());
    }

    @Test
    void getTask() {
        //Given
        Task task1 = new Task(1L, "title1", "content");

        when(taskRepository.findById(task1.getId())).thenReturn(Optional.ofNullable(task1));

        //When
        Optional<Task> task = dbService.getTask(task1.getId());

        //Then
        assertEquals(task1.getId(), task.get().getId());
    }

}