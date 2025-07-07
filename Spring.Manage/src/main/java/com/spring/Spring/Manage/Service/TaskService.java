package com.spring.Spring.Manage.Service;
import com.spring.Spring.Manage.Entities.taskEntities;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;


@Service
public class TaskService {
    private ArrayList<taskEntities> allTask = new ArrayList<>();

    int taskid = 1;
    public taskEntities addTask(String title , String description , String deadline){
        taskEntities task = new taskEntities();
        task.setId(taskid);
        task.setTitle(title);
        task.setDescription(description);
        //task.setDeadLine(new Date(deadline));
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


}
