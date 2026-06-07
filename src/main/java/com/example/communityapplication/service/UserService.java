package com.example.communityapplication.service;

import com.example.communityapplication.dto.LoginRequestDto;
import com.example.communityapplication.dto.LoginResponseDto;
import com.example.communityapplication.dto.UserRequestDto;
import com.example.communityapplication.dto.UserResponseDto;
import com.example.communityapplication.entity.User;
import com.example.communityapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class UserService {
    public UserResponseDto createUser(UserRequestDto request){
        User user = new User(
                UserRepository.getCurId(),
                request.getEmail(),
                request.getPassword(),
                request.getNickname(),
                request.getProfilePicture()
        );
        UserRepository.save(user.getId(), user);
        return new UserResponseDto(user);
    }

    public LoginResponseDto userLogin(LoginRequestDto request){
        String inputEmail = request.getEmail();
        String inputPassword = request.getPassword();
        User user = UserRepository.getUser(inputEmail);

        if(inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) return new LoginResponseDto(user);
        return null;
    }

    public UserResponseDto getUser(Long userId){
        User user = UserRepository.getUser(userId);
        return new UserResponseDto(user);
    }

    public UserResponseDto getUserProfilePicture(Long userId){
        User user = UserRepository.getUser(userId);
        return new UserResponseDto(user);
    }

    public UserResponseDto updateNickname(Long userId, UserRequestDto request){
        User user = UserRepository.getUser(userId);
        user.changeNickname(request.getNickname());
        return new UserResponseDto(user);
    }

    public UserResponseDto updatePassword( Long userId,  UserRequestDto request){
        User user = UserRepository.getUser(userId);
        user.changePassword(request.getPassword());
        return new UserResponseDto(user);
    }

    public UserResponseDto updateProfilePicture( Long userId,  UserRequestDto request){
        User user = UserRepository.getUser(userId);
        user.changeProfilePicture(request.getProfilePicture());
        return new UserResponseDto(user);
    }

    public void deleteUser(Long userId){
        UserRepository.delete(userId);
    }
}
