package com.example.communityapplication.controller;

import com.example.communityapplication.dto.LoginRequestDto;
import com.example.communityapplication.dto.LoginResponseDto;
import com.example.communityapplication.dto.UserRequestDto;
import com.example.communityapplication.dto.UserResponseDto;
import com.example.communityapplication.response.ApiResponse;
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
    public ApiResponse<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto request) {
        UserResponseDto userResponse = userService.createUser(request);
        return ApiResponse.of("signup_success", userResponse);
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponseDto> userLogin(@Valid @RequestBody LoginRequestDto request){
        LoginResponseDto userResponse =  userService.userLogin(request);
        return ApiResponse.of("login_sucess", userResponse);
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserResponseDto> getUser(@PathVariable Long userId){
        UserResponseDto userResponse =  userService.getUser(userId);
        return ApiResponse.of("get_data_success", userResponse);
    }

    @PatchMapping("/{userId}/nickname")
    public ApiResponse<UserResponseDto> updateNickname(@PathVariable Long userId, @Valid  @RequestBody UserRequestDto request){
        UserResponseDto userResponse = userService.updateNickname(userId, request);
        return ApiResponse.of("patch_success", userResponse);
    }

    @PatchMapping("/{userId}/password")
    public ApiResponse<UserResponseDto> updatePassword(@PathVariable Long userId, @Valid  @RequestBody UserRequestDto request){
        UserResponseDto userResponse =  userService.updatePassword(userId, request);
        return ApiResponse.of("patch_success", userResponse);
    }

    @PatchMapping("/{userId}/profilePicture")
    public ApiResponse<UserResponseDto> updateProfilePicture(@PathVariable Long userId, @Valid  @RequestBody UserRequestDto request){
        UserResponseDto userResponse = userService.updateProfilePicture(userId, request);
        return ApiResponse.of("patch_success", userResponse);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}