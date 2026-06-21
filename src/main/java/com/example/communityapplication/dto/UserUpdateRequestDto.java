package com.example.communityapplication.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    @Size(min = 2)
    @Size(max = 10)
    private String nickname;

    @Size(min = 8)
    @Size(max = 16)
    private String password;

    private String profilePicture;
}
