package com.NewsApp.NewsApp.Controller.Admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NewsApp.NewsApp.Controller.User.UserActionController;

@RestController
@RequestMapping("/admin")
public class PublishNews {
	
	private static final Logger logger=LoggerFactory.getLogger(UserActionController.class);
	
	
	@PostMapping("/uploadnews")
	public ResponseEntity<?> PublishNews() {
		
		
		logger.info("news add to DB");
		return ResponseEntity.ok("Upload news successfully");
	}
	
	

	
	@PostMapping("/addCat")
	public ResponseEntity<?> AddCatogary() {
		
		
		logger.info("Add catagory successfully");
		return ResponseEntity.ok("catagory add");
	}
	
	
	
	
	
}
