package com.NewsApp.NewsApp.Controller.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.Reporter;

import com.NewsApp.NewsApp.DAO.TestRepo;
import com.NewsApp.NewsApp.DAO.News.HindiNews;
import com.NewsApp.NewsApp.Entities.UserCredentials;
import com.NewsApp.NewsApp.Entities.News.NewsArticlesEng;
import com.NewsApp.NewsApp.Entities.News.NewsArticlesHindi;



@RestController
@RequestMapping("/test")
public class userTest {

	@Autowired
	public Logger logger;
	@Autowired
	TestRepo testRepo;
	//Logger log = LoggerFactory.getLogger(LogController.class);
    @Autowired	
    @Qualifier("user02")
	UserCredentials user;
    
    @Autowired
    NewsArticlesEng newsArticlesEng;
    
    @Autowired
    NewsArticlesHindi newsArticlesHindi;
    
    
    @Autowired
    HindiNews hindiNews;
    
	@Autowired
	TestRepo t1;
	
	
	@GetMapping("/check")
	public String CheckMethod(){
		//System.out.println(user.toString());
		logger.info("Log level: INFOxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		//t1.save(this.user);
		Optional<UserCredentials> userVal= t1.findById(1);
		if(userVal==null) {
			return "get null vall";
		}else {
			logger.info("Log level: INFOxxxxxxrterterterxxxxxxxxxxxxxxxxx{}",userVal.get());
		}
		
		return "run cfccccvds ok";
    }
	
	@PostMapping("/Userdata")
	public Boolean Adduser(@RequestBody Optional<UserCredentials> user){
		 
		//log.info("Log level: INFO");
		logger.info("Log level: INFO"); 
	
		t1.save(this.user);
		//UserCredentials

		//testRepo.save();
		return true;
	}
	
	@GetMapping("/NewsTest")
	public String getNewsdata() {
		
		System.out.println(newsArticlesEng);
		System.err.println(newsArticlesHindi);
		
		hindiNews.save(newsArticlesHindi);
		
		return "work fine";
	}
	
}
