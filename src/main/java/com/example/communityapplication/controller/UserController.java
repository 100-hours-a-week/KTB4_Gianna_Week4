package com.example.communityapplication.controller;

import com.example.communityapplication.dto.UserRequestDto;
import com.example.communityapplication.dto.UserResponseDto;
import com.example.communityapplication.entity.User;
import com.example.communityapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}")
@RequiredArgsConstructor
public class UserController {
    private Long lastId = 0L;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto request) {
        lastId++;

        User user = new User(
                lastId,
                request.getEmail(),
                request.getPassword(),
                request.getNickname(),
                request.getProfile_picture()
        );
        UserRepository.save(user.getId(),user);
        return new UserResponseDto(user);
    }

    @GetMapping
    public UserResponseDto getUser(@PathVariable Long userId){
        User user = UserRepository.getUser(userId);
        return new UserResponseDto(user);
    }

    @GetMapping("/profilePicture")
    public String getUserProfilePicture(@PathVariable Long userId){
        User user = UserRepository.getUser(userId);
        return user.getProfilePicture();
    }

    @PatchMapping("/nickname")
    public UserResponseDto updateNickname(@PathVariable Long userId, @RequestBody UserRequestDto requestDto){
        User user = UserRepository.getUser(userId);
        user.changeNickname(requestDto.getNickname());
        return new UserResponseDto(user);
    }

    @PatchMapping("/password")
    public UserResponseDto updatePassword(@PathVariable Long userId, @RequestBody UserRequestDto requestDto){
        User user = UserRepository.getUser(userId);
        user.changePassword(requestDto.getPassword());
        return new UserResponseDto(user);
    }

    @PatchMapping("/profile_picture")
    public UserResponseDto updateProfilePicture(@PathVariable Long userId, @RequestBody UserRequestDto requestDto){
        User user = UserRepository.getUser(userId);
        user.changeProfilePicture(requestDto.getProfile_picture());
        return new UserResponseDto(user);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long userId){
        UserRepository.delete(userId);
    }
}