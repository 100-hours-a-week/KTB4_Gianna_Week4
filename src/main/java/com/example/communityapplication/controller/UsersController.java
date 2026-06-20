package com.example.communityapplication.controller;

import com.example.communityapplication.dto.*;
import com.example.communityapplication.response.ApiResponse;
import com.example.communityapplication.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/signup")
    public ApiResponse<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto request) {
        UserResponseDto userResponseDto = usersService.create(request.getEmail(), request.getPassword(),request.getNickname(),request.getProfilePicture());
        return ApiResponse.of("signup_success", userResponseDto);
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponseDto> userLogin(@Valid @RequestBody LoginRequestDto request) throws IllegalAccessException {
        LoginResponseDto userResponse;
        try {
            userResponse = usersService.userLogin(request.getEmail(), request.getPassword());
        } catch (IllegalAccessException e) {
            throw new IllegalAccessException();
        }
        return ApiResponse.of("login_sucess", userResponse);
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserResponseDto> getUser(@PathVariable Long userId){
        UserResponseDto userResponse =  usersService.getUser(userId);
        return ApiResponse.of("get_data_success", userResponse);
    }

    @PatchMapping("/{userId}/nickname")
    public ApiResponse<UserUpdateResponseDto> updateNickname(@PathVariable Long userId, @Valid  @RequestBody UserUpdateRequestDto request){
        usersService.updateNickname(userId, request.getNickname());
        return ApiResponse.of("patch_success", null);
    }

//    @PatchMapping("/{userId}/password")
//    public ApiResponse<UserResponseDto> updatePassword(@PathVariable Long userId, @Valid  @RequestBody UserRequestDto request){
//        UserResponseDto userResponse =  userService.updatePassword(userId, request);
//        return ApiResponse.of("patch_success", userResponse);
//    }
//
//    @PatchMapping("/{userId}/profilePicture")
//    public ApiResponse<UserResponseDto> updateProfilePicture(@PathVariable Long userId, @Valid  @RequestBody UserRequestDto request){
//        UserResponseDto userResponse = userService.updateProfilePicture(userId, request);
//        return ApiResponse.of("patch_success", userResponse);
//    }
//
//    @DeleteMapping("/{userId}")
//    public void deleteUser(@PathVariable Long userId){
//        userService.deleteUser(userId);
//    }
}