package com.example.communityapplication.repository;

import com.example.communityapplication.entity.DeletedUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeletedUsersRepository extends JpaRepository<DeletedUsers, Long> {
}
