package com.example.demo.domain.memo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoRequestDto {
    private String title;
    private String contents;
    private String username;
}
