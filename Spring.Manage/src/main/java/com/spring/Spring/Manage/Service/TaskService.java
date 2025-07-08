package com.spring.Spring.Manage.Service;

import com.spring.Spring.Manage.Entities.taskEntities;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


@Service
public class TaskService {
    private ArrayList<taskEntities> allTask = new ArrayList<>();
    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    int taskid = 1;
    public taskEntities addTask(String title , String description , String deadline) throws ParseException {
        taskEntities task = new taskEntities();
        task.setId(taskid);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadLine(deadlineFormatter.parse(deadline));
        allTask.add(task);
        taskid++;
        return task;
    }

       public ArrayList<taskEntities> getAllTask(){
            return allTask;
        }

    public taskEntities gettaskByid(int id){
        for(taskEntities task : allTask){
            if(task.getId()==id){
                return task;
            }
        }
        return null;
    }

    public taskEntities updateTask(int id , String description , String deadline , Boolean completed) throws ParseException {
        taskEntities task = gettaskByid(id);
        if(task == null){
            return null;
        }

        if(description != null){
            task.setDescription(description);
        }
        if(deadline != null){
            task.setDeadLine(deadlineFormatter.parse(deadline));
        }
        if(completed != null){
            task.setCompleted(completed);
        }
        return task;
    }


}
