package com.sparta.hanghaeblog.dto;

import lombok.Getter;

@Getter
public class BlogRequestDto {
    private String title;
    private String username;
    private String password;
    private String contents;
}