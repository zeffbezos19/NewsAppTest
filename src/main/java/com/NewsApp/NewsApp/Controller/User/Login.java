package com.NewsApp.NewsApp.Controller.User;

import java.security.PublicKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Login")
public class Login {
	private static final Logger logger=LoggerFactory.getLogger(UserActionController.class);
	
	
	@PostMapping("/facebook")
	public ResponseEntity<?> LogWithFacebook() {
		
		//FaceBook loggin Code
		logger.info("facebook");
		return ResponseEntity.ok("Log with faceBook");
	}
	
	@PostMapping("/google")
	public ResponseEntity<?> LogWithGoogle() {
		
		//Google loggin Code
		logger.info("Google");
		return ResponseEntity.ok("Log with Google");
	}
	
	
	

}
