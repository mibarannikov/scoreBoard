package com.tasksbb.scoreboard.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class Response {
    private Long id;
    private String title;

    public Response(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
