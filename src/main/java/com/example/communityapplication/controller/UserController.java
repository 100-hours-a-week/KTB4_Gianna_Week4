package com.example.communityapplication.controller;

import com.example.communityapplication.dto.LoginRequestDto;
import com.example.communityapplication.dto.LoginResponseDto;
import com.example.communityapplication.dto.UserRequestDto;
import com.example.communityapplication.dto.UserResponseDto;
import com.example.communityapplication.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto request) {
        return userService.createUser(request);
    }

    @PostMapping("/login")
    public LoginResponseDto userLogin(@Valid @RequestBody LoginRequestDto request){
        return userService.userLogin(request);
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @GetMapping("/{userId}/profilePicture")
    public UserResponseDto getUserProfilePicture(@PathVariable Long userId){
        return userService.getUserProfilePicture(userId);
    }

    @PatchMapping("/{userId}/nickname")
    public UserResponseDto updateNickname(@PathVariable Long userId, @Valid  @RequestBody UserRequestDto request){
        return userService.updateNickname(userId, request);
    }

    @PatchMapping("/{userId}/password")
    public UserResponseDto updatePassword(@PathVariable Long userId, @Valid  @RequestBody UserRequestDto request){
       return userService.updatePassword(userId, request);
    }

    @PatchMapping("/{userId}/profile_picture")
    public UserResponseDto updateProfilePicture(@PathVariable Long userId, @Valid  @RequestBody UserRequestDto request){
      return userService.updateProfilePicture(userId, request);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}