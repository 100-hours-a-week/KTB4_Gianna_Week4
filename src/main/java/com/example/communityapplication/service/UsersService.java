package com.example.communityapplication.service;

import com.example.communityapplication.entity.Users;
import com.example.communityapplication.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    public Users create(String email, String password, String nickname, String profilePicture){
        Users user = new Users( email, password,nickname,profilePicture);
        usersRepository.save(user);
        return  user;
    }
//
//    public LoginResponseDto userLogin(LoginRequestDto request){
//        String inputEmail = request.getEmail();
//        String inputPassword = request.getPassword();
//        User user = UserRepository.getUser(inputEmail);
//
//        if(inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) return new LoginResponseDto(user);
//        return null;
//    }
//
//    public UserResponseDto getUser(Long userId){
//        User user = UserRepository.getUser(userId);
//        return new UserResponseDto(user);
//    }
//
//    public UserResponseDto getUserProfilePicture(Long userId){
//        User user = UserRepository.getUser(userId);
//        return new UserResponseDto(user);
//    }
//
//    public UserResponseDto updateNickname(Long userId, UserRequestDto request){
//        User user = UserRepository.getUser(userId);
//        user.changeNickname(request.getNickname());
//        return new UserResponseDto(user);
//    }
//
//    public UserResponseDto updatePassword( Long userId,  UserRequestDto request){
//        User user = UserRepository.getUser(userId);
//        user.changePassword(request.getPassword());
//        return new UserResponseDto(user);
//    }
//
//    public UserResponseDto updateProfilePicture( Long userId,  UserRequestDto request){
//        User user = UserRepository.getUser(userId);
//        user.changeProfilePicture(request.getProfilePicture());
//        return new UserResponseDto(user);
//    }
//
//    public void deleteUser(Long userId){
//        UserRepository.delete(userId);
//    }
}
