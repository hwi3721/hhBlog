package com.sparta.hanghaeblog.entity;

import com.sparta.hanghaeblog.dto.BlogRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Blog extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Blog(String username, String contents, String password, String title) {
        this.title = title;
        this.password = password;
        this.username = username;
        this.contents = contents;
    }

    public Blog(BlogRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }

    public void update(BlogRequestDto blogRequestDto) {
        this.username = blogRequestDto.getUsername();
        this.password = blogRequestDto.getPassword();
        this.contents = blogRequestDto.getContents();
        this.title = blogRequestDto.getTitle();
    }


}