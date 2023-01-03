package com.sparta.hanghaeblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequestDto {
    private String username;
    private String password;
    private boolean admin = false;
    private String adminToken = "";
}
