package com.NewsApp.NewsApp.Controller.News;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NewsApp.NewsApp.Controller.User.UserActionController;

@RestController
@RequestMapping("/getnews")
public class NewsFecthing {
	
	private static final Logger logger=LoggerFactory.getLogger(UserActionController.class);

	
	@GetMapping("/trending")
	public ResponseEntity<?> fetchtrendingNews(){
		
		logger.info("get trending news");
		return ResponseEntity.ok("get trending new");
	}
	
	
	@GetMapping("/banner")
	public ResponseEntity<?> fetchBanner(){
		
		logger.info("get Banner");
		return ResponseEntity.ok("get banner");
	}
	
	
	@GetMapping("/glob")
	public ResponseEntity<?> fetchGlobleNews(){
		
		logger.info("get Globe news");
		return ResponseEntity.ok("get Golbe new");
	}
	
	@GetMapping("/cat")
	public ResponseEntity<?> fetchNewsOnCatagory(){
		
		logger.info("get Cat news");
		return ResponseEntity.ok("get cat new");
	}
	
	

}
