package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    TaskMapper taskMapper;

    @Test
    void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title", "content");

        //Then
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(taskDto.getId(), task.getId());
    }

    @Test
    void mapToTaskDto() {
        //Given
        Task task = new Task(1L, "title", "content");

        //Then
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(task.getId(), taskDto.getId());
    }

    @Test
    void mapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "title1", "content");
        Task task2 = new Task(2L, "title2", "content");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(taskList.size(), taskDtoList.size());
    }
}