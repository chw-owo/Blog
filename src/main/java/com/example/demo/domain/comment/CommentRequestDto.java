package com.example.demo.domain.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private String username;
    private String comment;
}