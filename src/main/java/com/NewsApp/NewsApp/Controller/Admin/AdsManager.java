package com.NewsApp.NewsApp.Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;      
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.NewsApp.NewsApp.Controller.User.UserActionController;
import com.NewsApp.NewsApp.Entities.Ads.AdsEnglishMapper;
import com.NewsApp.NewsApp.Entities.Ads.AdsHindiMapper;
import com.NewsApp.NewsApp.Service.Ads.AdsService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/ads")
public class AdsManager {
	                            
	private static final Logger logger=LoggerFactory.getLogger(UserActionController.class);
	
	private String FOLDER_PATH="C:\\Users\\ashwa\\OneDrive\\Documents\\AdsFile\\";
	
	
	@Autowired
	AdsService adsService;
	@Autowired
	private ObjectMapper objectMapper;
	
	@PostMapping("/uploadads")
	public ResponseEntity<?> PublishAds(@RequestParam("Image")MultipartFile file,@RequestParam("AdsHindi")String AdsHindi,@RequestParam("AdsEnglish")String AdsEnglish)throws IOException
	{
		
		AdsHindiMapper hindiNews= objectMapper.readValue(AdsHindi, AdsHindiMapper.class);
		AdsEnglishMapper englishNews= objectMapper.readValue(AdsEnglish, AdsEnglishMapper.class);
		logger.info("{}  {}",hindiNews,englishNews);
		String uploadImage = adsService.uploadImageToFileSystem(file,hindiNews,englishNews);
	    
		
		if(uploadImage==null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
				
		
		logger.info("Ads add to DB");
		return ResponseEntity.ok("Upload ads successfully");
	}
	
	
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<?> getImage(@PathVariable String fileName) throws IOException {
		logger.info("image value   {}",fileName);
        Path path = Paths.get(FOLDER_PATH + File.separator + fileName);
        byte[] imageBytes = Files.readAllBytes(path);
       
        return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageBytes);
    }

	
	
	
//	@PostMapping("/adsset")
//	public ResponseEntity<?> SetadsonBanner() {
//		
//		
//		logger.info("Ads On banner");
//		return ResponseEntity.ok("banner ads show");
//	}
//	
//	@PostMapping("/adsremove")
//	public ResponseEntity<?> RemoveadsonBanner() {
//		
//		
//		logger.info("remove");
//		return ResponseEntity.ok("banner ads show");
//	}
//	
//	@PostMapping("/adsorder")
//	public ResponseEntity<?> setBannerOrder() {
//		
//		
//		logger.info("set order");
//		return ResponseEntity.ok("order set");
//	}

}
