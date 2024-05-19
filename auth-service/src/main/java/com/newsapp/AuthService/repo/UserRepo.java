package com.newsapp.AuthService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsapp.AuthService.model.UserInfo;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, String> {

Optional<UserInfo> findByUseremailAndPassword(String email, String password);

}
