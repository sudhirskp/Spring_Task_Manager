package com.spring.Spring.Manage.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTaskdto {
    private String title;
    private String description;
    private String deadline;
}
