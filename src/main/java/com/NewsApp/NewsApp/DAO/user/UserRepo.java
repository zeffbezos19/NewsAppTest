package com.NewsApp.NewsApp.DAO.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NewsApp.NewsApp.Entities.UserCredentials;

@Repository
public interface UserRepo extends JpaRepository<UserCredentials, Integer>{
	
	

}
