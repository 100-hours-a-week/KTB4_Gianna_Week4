package com.example.communityapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Entity
public class DeletedUsers {
    @Id
    private Long id;
    private String email;
    private String nickname;
    public DeletedUsers(Long id, String email, String nickname){
        this.id =  id;
        this.email = email;
        this.nickname = nickname;
    }
}
