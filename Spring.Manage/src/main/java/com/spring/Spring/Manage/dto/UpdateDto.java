package com.spring.Spring.Manage.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateDto {
    private String description;
    private String deadline;
    private Boolean completed;
}
