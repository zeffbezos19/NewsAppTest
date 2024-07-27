package com.NewsApp.NewsApp.Controller.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserAction")
public class UserActionController {
	private static final Logger logger=LoggerFactory.getLogger(UserActionController.class);
	
	@PostMapping("/buyplan")
	public ResponseEntity<?> BuyPlan() {
		
		
		logger.info("buy plan logger is working");
		return ResponseEntity.ok("U buy plan successfully");
	}
	
	@PatchMapping("/Lan/{Language}")
	public ResponseEntity<?> Changelanguage(@PathVariable("Language") String Language) {
		
		
		logger.info(" language");
		return ResponseEntity.ok("you change your language");
	}

}
