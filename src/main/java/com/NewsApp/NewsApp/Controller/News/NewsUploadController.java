package com.NewsApp.NewsApp.Controller.News;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.multipart.MultipartFile;

import com.NewsApp.NewsApp.Controller.User.UserActionController;
import com.NewsApp.NewsApp.DAO.News.UploadNewsRepo;
import com.NewsApp.NewsApp.Entities.News.NewsArticlesEng;
import com.NewsApp.NewsApp.Entities.News.NewsArticlesHindi;
import com.NewsApp.NewsApp.Entities.News.NewsDeatil;
import com.NewsApp.NewsApp.Entities.News.NewsMapperEnglish;
import com.NewsApp.NewsApp.Entities.News.NewsMapperHindi;
import com.NewsApp.NewsApp.Service.News.NewsUpload;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.Resource;

@RestController
public class NewsUploadController {

	@Autowired
	private NewsUpload newsUpload;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private UploadNewsRepo uploadNews;
	
	private String FOLDER_PATH="C:\\Users\\ashwa\\OneDrive\\Documents\\MyFile\\";

	
	private static final Logger logger=LoggerFactory.getLogger(UserActionController.class);
	
	@PostMapping("/fileSystem")
	public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("Image")MultipartFile file,@RequestParam("NewsHindi")String NewsHindi,@RequestParam("NewsEng")String NewsEng) throws IOException {
	
		NewsMapperHindi hindiNews= objectMapper.readValue(NewsHindi, NewsMapperHindi.class);
		NewsMapperEnglish englishNews= objectMapper.readValue(NewsEng, NewsMapperEnglish.class);
		logger.info("{}  {}",hindiNews,englishNews);
		String uploadImage = newsUpload.uploadImageToFileSystem(file,hindiNews,englishNews);
	    
		
		if(uploadImage==null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
				
		logger.info("Uploading image and news also");
		
		return ResponseEntity.ok("upload successful");
	}
	
	//http://localhost:8080/download/a07e12dd-015b-4f56-8dd1-34613f03e364_img005.jpg
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<?> getImage(@PathVariable String fileName) throws IOException {
		logger.info("image value   {}",fileName);
        Path path = Paths.get(FOLDER_PATH + File.separator + fileName);
        byte[] imageBytes = Files.readAllBytes(path);
       
        return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageBytes);
    }
	
    @GetMapping("/newsid/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id) {
        Optional<NewsDeatil> news=uploadNews.findById(id);
        if (news != null) {
            return new ResponseEntity<>(news, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	
	
}
