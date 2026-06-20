package com.example.communityapplication.service;

import com.example.communityapplication.dto.LoginResponseDto;

import com.example.communityapplication.dto.ProfilePictureResponseDto;
import com.example.communityapplication.dto.UserResponseDto;
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
    public UserResponseDto create(String email, String password, String nickname, String profilePicture){
        Users user = new Users( email, password,nickname,profilePicture);
        usersRepository.save(user);
        return new UserResponseDto(user);
    }

    public LoginResponseDto userLogin(String email, String password) throws IllegalAccessException {
        Users user = usersRepository.findByEmail(email);

        if(!password.equals(user.getPassword())) throw new IllegalAccessException();
        return new LoginResponseDto(user);
    }

    public UserResponseDto getUser(Long userId){
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
        return new UserResponseDto(user);
    }

    public ProfilePictureResponseDto getUserProfilePicture(Long userId){
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));

        return new ProfilePictureResponseDto(user.getProfilePicture());
    }

    public void updateNickname(Long userId, String newNickname){
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
        user.changeNickname(newNickname);
        usersRepository.save(user);
    }

    public void updatePassword( Long userId,  String newPassword){
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
        user.changePassword(newPassword);
        usersRepository.save(user);
    }

    public void updateProfilePicture( Long userId,  String newProfilePicture){
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
        user.changeProfilePicture(newProfilePicture);
        usersRepository.save(user);
    }

//    public void deleteUser(Long userId){
//        UserRepository.delete(userId);
//    }
}
