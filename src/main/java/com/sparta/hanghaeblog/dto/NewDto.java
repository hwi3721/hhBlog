package com.sparta.hanghaeblog.dto;

import com.sparta.hanghaeblog.entity.Blog;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
public class NewDto {
    private Long id;
    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
    private String title;
    private String username;
    private String contents;

    public NewDto(Blog target) {
        this.id = target.getId();
        this.createdAt = target.getCreatedAt();
        this.modifiedAt = target.getModifiedAt();
        this.title = target.getTitle();
        this.username = target.getUsername();
        this.contents = target.getContents();
    }
}