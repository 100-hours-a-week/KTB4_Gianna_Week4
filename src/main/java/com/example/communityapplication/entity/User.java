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
    private String profile_picture;

    public User(Long id, String email, String password, String nickname, String profile_picture){
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profile_picture = profile_picture == null? "default_picture.jpg" :profile_picture;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void changeProfilePicture(String profile_picture) {
        this.profile_picture = profile_picture;
    }
}
