package com.example.communityapplication.controller;

import com.example.communityapplication.dto.UserRequestDto;
import com.example.communityapplication.dto.UserResponseDto;
import com.example.communityapplication.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto request) {
        String profile_picture = request.getProfile_picture();

        User user = new User(
                request.getEmail(),
                request.getPassword(),
                request.getNickname(),
                profile_picture
        );
        return new UserResponseDto(user);
    }
}