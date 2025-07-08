package com.spring.Spring.Manage.Controller;

import com.spring.Spring.Manage.Entities.taskEntities;
import com.spring.Spring.Manage.Service.TaskService;
import com.spring.Spring.Manage.dto.CreateTaskdto;
import com.spring.Spring.Manage.dto.ErrorResponseDto;
import com.spring.Spring.Manage.dto.UpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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


    @PatchMapping("/{id}")
    public ResponseEntity<taskEntities> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateDto body) throws ParseException {
        var task = taskService.updateTask(id , body.getDescription() , body.getDeadline() , body.getCompleted());
        if(task == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

   @PostMapping("/addTask")
   public ResponseEntity<taskEntities> addTask(@RequestBody CreateTaskdto body) throws ParseException {
       var task = taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
       return ResponseEntity.ok(task);
   }

   @ExceptionHandler(Exception.class)
   public ResponseEntity<ErrorResponseDto> handleException(Exception ex) {

        if(ex instanceof ParseException) return ResponseEntity.badRequest().body(new ErrorResponseDto("invalid date format"));

        ex.printStackTrace(); // for dev side
       return ResponseEntity.internalServerError().body(new ErrorResponseDto("something went wrong"));
   }
}
