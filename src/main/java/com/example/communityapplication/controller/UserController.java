package com.example.communityapplication.controller;

import com.example.communityapplication.dto.UserRequestDto;
import com.example.communityapplication.dto.UserResponseDto;
import com.example.communityapplication.entity.User;
import com.example.communityapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
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

    @GetMapping("/{user_id}")
    public UserResponseDto getUser(@PathVariable Long user_id){
        User user = UserRepository.getUser(user_id);
        return new UserResponseDto(user);
    }

    @PatchMapping("/{user_id}/nickname")
    public UserResponseDto updateNickname(@PathVariable Long user_id, @RequestBody UserRequestDto requestDto){
        User user = UserRepository.getUser(user_id);
        user.changeNickname(requestDto.getNickname());
        return new UserResponseDto(user);
    }

    @PatchMapping("/{user_id}/password")
    public UserResponseDto updatePassword(@PathVariable Long user_id, @RequestBody UserRequestDto requestDto){
        User user = UserRepository.getUser(user_id);
        user.changePassword(requestDto.getPassword());
        return new UserResponseDto(user);
    }

    @PatchMapping("/{user_id}/profile_picture")
    public UserResponseDto updateProfilePicture(@PathVariable Long user_id, @RequestBody UserRequestDto requestDto){
        User user = UserRepository.getUser(user_id);
        user.changeProfilePicture(requestDto.getProfile_picture());
        return new UserResponseDto(user);
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable Long user_id){
        UserRepository.delete(user_id);
    }
}