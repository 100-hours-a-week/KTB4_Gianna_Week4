package com.example.communityapplication.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {

//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
    private Long id;

    private String email;
    private String password;
    private String nickname;
    private String profilePicture;


    public User(Long id, String email, String password, String nickname, String profilePicture){
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profilePicture = profilePicture == null? "default_picture.jpg" : profilePicture;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void changeProfilePicture(String profile_picture) {
        this.profilePicture = profile_picture;
    }
}
