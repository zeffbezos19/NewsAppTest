package com.NewsApp.NewsApp.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NewsApp.NewsApp.Entities.UserCredentials;

public interface TestRepo extends JpaRepository<UserCredentials, Integer> {

	//UserCredentials save(UserCredentials user);
	
	//Optional<UserCredentials> findbyUser_ID(long id);
	
}
