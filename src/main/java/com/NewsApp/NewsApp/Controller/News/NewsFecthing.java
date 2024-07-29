package com.NewsApp.NewsApp.Controller.News;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NewsApp.NewsApp.Controller.User.UserActionController;
import com.NewsApp.NewsApp.DAO.News.UploadNewsRepo;
import com.NewsApp.NewsApp.Entities.News.NewsDeatil;
import com.NewsApp.NewsApp.Service.News.GetNewsbyRequest;

@RestController
@RequestMapping("/getnews")
public class NewsFecthing {
	
	private static final Logger logger=LoggerFactory.getLogger(UserActionController.class);
   
     @Autowired
     GetNewsbyRequest getNewsbyRequest;
	
	@GetMapping("/trending")
	public ResponseEntity<?> fetchtrendingNews(){
		
		Page<NewsDeatil> page= (Page<NewsDeatil>) getNewsbyRequest.getTrendingNews(0);
		logger.info("get trending news{}",page);
		
		return new ResponseEntity<>(page,HttpStatus.OK);
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
