package com.newsapp.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.newsapp.userservice.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
	 User findByUseremail(String useremail);

}
