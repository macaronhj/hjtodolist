package com.example.hjtodolist.todolist.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CheckListDto {
    private Long seq;
    private String todo;
    private LocalDateTime create_at;
    private LocalDateTime deadline;
}
