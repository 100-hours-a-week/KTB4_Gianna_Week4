package com.example.communityapplication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8)
    @Size(max = 16)
    private String password;

    @NotBlank
    @Size(min = 2)
    @Size(max = 10)
    private String nickname;

    private String profilePicture;
}