package com.spring.Spring.Manage.Controller;

import com.spring.Spring.Manage.Entities.taskEntities;
import com.spring.Spring.Manage.Service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alltasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<taskEntities>> gettask(){
        var tasks = taskService.getAllTask();

        return ResponseEntity.ok(tasks);
    }
}
