package com.spring.Spring.Manage.Controller;

import com.spring.Spring.Manage.Entities.taskEntities;
import com.spring.Spring.Manage.Service.TaskService;
import com.spring.Spring.Manage.dto.DTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<taskEntities> gettaskById(@PathVariable int id){
        var taskbyid = taskService.gettaskByid(id);
        if(taskbyid == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(taskbyid);
    }

   @PostMapping("/addTask")
   public ResponseEntity<taskEntities> addTask(@RequestBody DTo body) {
       var task = taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
       return ResponseEntity.ok(task);
   }
}
