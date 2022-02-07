package com.example.hjtodolist.todolist.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
public class CheckListDto {
    private Long seq;
    private String todo;
    private Date create_at;
    private String deadline;
}
