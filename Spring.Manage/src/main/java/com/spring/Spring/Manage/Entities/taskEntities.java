package com.spring.Spring.Manage.Entities;


import lombok.Data;

import java.util.Date;

@Data
public class taskEntities {
    private int id;
    private String Title;
    private String description;
    private Date DeadLine;
    private boolean completed;
}
