package com.example.communityapplication.repository;

import com.example.communityapplication.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Map<Long, User> userRepository = new HashMap<>();
    public static void  save (Long userId, User user){
        userRepository.put(userId,user);
    }
    public static User getUser(Long userId){
        return userRepository.get(userId);
    }
    public static void delete(Long userId){
        userRepository.remove(userId);
    }
}
