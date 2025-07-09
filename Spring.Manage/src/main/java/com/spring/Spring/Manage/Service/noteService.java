package com.spring.Spring.Manage.Service;


import com.spring.Spring.Manage.Entities.noteEntities;
import com.spring.Spring.Manage.Entities.taskEntities;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class noteService {
    private TaskService taskService;
    private HashMap<Integer, TaskNoteHolder> notesHolder = new HashMap<>();

   public noteService(TaskService taskService) {
        this.taskService = taskService;
    }

    class TaskNoteHolder {
        protected int noteid = 1;
        protected ArrayList<noteEntities> notes = new ArrayList<>();
    }

    public ArrayList<noteEntities> getNotes(int taskid) {
        taskEntities task = taskService.gettaskByid(taskid);
        if (task == null) {
            return null;
        }
        if (notesHolder.get(taskid) == null) {
            notesHolder.put(taskid, new TaskNoteHolder());
        }
        return notesHolder.get(taskid).notes;
    }

    public noteEntities addNote(int taskid, String title, String body) {
        taskEntities task = taskService.gettaskByid(taskid);
        if (task == null) {
            return null;
        }
        if (notesHolder.get(taskid) == null) {
            notesHolder.put(taskid, new TaskNoteHolder());
        }

        TaskNoteHolder holder = notesHolder.get(taskid);
        noteEntities note = new noteEntities();
        note.setId(holder.noteid);
        note.setTitle(title);
        note.setBody(body);
        holder.notes.add(note);
        holder.noteid++;
        return note;
    }
}
