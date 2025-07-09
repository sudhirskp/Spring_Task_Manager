package com.spring.Spring.Manage.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks/{taskid}/notes")
public class NoteController {

    @GetMapping("")
    public String getNotes(@PathVariable("taskid") Integer taskid) {
        return "hello";
    }
}
