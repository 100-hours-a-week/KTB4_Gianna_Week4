package com.example.communityapplication.controller;

import com.example.communityapplication.dto.LoginRequestDto;
import com.example.communityapplication.dto.LoginResponseDto;
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

    @PostMapping("/signup")
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

    @PostMapping("/login")
    public LoginResponseDto userLogin(@RequestBody LoginRequestDto request){
        String inputEmail = request.getEmail();
        String inputPassword = request.getPassword();
        User user = UserRepository.getUser(inputEmail);

        if(inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) return new LoginResponseDto(user);
        return null;
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId){
        User user = UserRepository.getUser(userId);
        return new UserResponseDto(user);
    }

    @GetMapping("/{userId}/profilePicture")
    public String getUserProfilePicture(@PathVariable Long userId){
        User user = UserRepository.getUser(userId);
        return user.getProfilePicture();
    }

    @PatchMapping("/{userId}/nickname")
    public UserResponseDto updateNickname(@PathVariable Long userId, @RequestBody UserRequestDto requestDto){
        User user = UserRepository.getUser(userId);
        user.changeNickname(requestDto.getNickname());
        return new UserResponseDto(user);
    }

    @PatchMapping("/{userId}/password")
    public UserResponseDto updatePassword(@PathVariable Long userId, @RequestBody UserRequestDto requestDto){
        User user = UserRepository.getUser(userId);
        user.changePassword(requestDto.getPassword());
        return new UserResponseDto(user);
    }

    @PatchMapping("/{userId}/profile_picture")
    public UserResponseDto updateProfilePicture(@PathVariable Long userId, @RequestBody UserRequestDto requestDto){
        User user = UserRepository.getUser(userId);
        user.changeProfilePicture(requestDto.getProfile_picture());
        return new UserResponseDto(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        UserRepository.delete(userId);
    }
}