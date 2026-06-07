package com.example.communityapplication.repository;

import com.example.communityapplication.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static Long lastId = 0L;
    private static final Map<Long, User> userRepository = new HashMap<>();

    public static Long getCurId(){
        return lastId++;
    }
    public static void  save (Long userId, User user){
        userRepository.put(userId,user);
    }
    public static User getUser(Long userId){
        return userRepository.get(userId);
    }
    public static User getUser(String email){
        for(Long i =1L; i<= userRepository.size(); i++){
            if(userRepository.get(i).isSameEmail(email)) {
                return userRepository.get(i);
            }
        }
        return null;
    }
    public static void delete(Long userId){
        userRepository.remove(userId);
    }
}
