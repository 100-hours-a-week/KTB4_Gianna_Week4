package com.example.communityapplication.dto;

import com.example.communityapplication.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponseDto {
    private String email;

    public LoginResponseDto(User user){
        this.email = user.getEmail();
    }
}
