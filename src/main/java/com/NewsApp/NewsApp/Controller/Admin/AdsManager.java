package com.NewsApp.NewsApp.Controller.Admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NewsApp.NewsApp.Controller.User.UserActionController;

@RestController
@RequestMapping("/ads")
public class AdsManager {
	
	private static final Logger logger=LoggerFactory.getLogger(UserActionController.class);
	
	
	@PostMapping("/uploadads")
	public ResponseEntity<?> PublishAds() {
		
		
		logger.info("Ads add to DB");
		return ResponseEntity.ok("Upload ads successfully");
	}
	
	@PostMapping("/adsset")
	public ResponseEntity<?> SetadsonBanner() {
		
		
		logger.info("Ads On banner");
		return ResponseEntity.ok("banner ads show");
	}
	
	@PostMapping("/adsremove")
	public ResponseEntity<?> RemoveadsonBanner() {
		
		
		logger.info("remove");
		return ResponseEntity.ok("banner ads show");
	}
	
	@PostMapping("/adsorder")
	public ResponseEntity<?> setBannerOrder() {
		
		
		logger.info("set order");
		return ResponseEntity.ok("order set");
	}

}
