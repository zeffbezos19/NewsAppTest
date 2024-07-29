package com.NewsApp.NewsApp.Service.Ads;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.NewsApp.NewsApp.Controller.User.UserActionController;
import com.NewsApp.NewsApp.DAO.Ads.AdsRepo;
import com.NewsApp.NewsApp.DAO.News.UploadNewsRepo;
import com.NewsApp.NewsApp.Entities.Ads.Ads;
import com.NewsApp.NewsApp.Entities.Ads.AdsEnglishDetail;
import com.NewsApp.NewsApp.Entities.Ads.AdsEnglishMapper;
import com.NewsApp.NewsApp.Entities.Ads.AdsHindiDetail;
import com.NewsApp.NewsApp.Entities.Ads.AdsHindiMapper;
import com.NewsApp.NewsApp.Entities.Enum.Category;
import com.NewsApp.NewsApp.Entities.News.NewsArticlesEng;
import com.NewsApp.NewsApp.Entities.News.NewsArticlesHindi;
import com.NewsApp.NewsApp.Entities.News.NewsDeatil;
import com.NewsApp.NewsApp.Entities.News.NewsMapperEnglish;
import com.NewsApp.NewsApp.Entities.News.NewsMapperHindi;

@Service
public class AdsService {

	
	@Autowired
	private AdsRepo adsRepo;
	
	private String FOLDER_PATH="C:\\Users\\ashwa\\OneDrive\\Documents\\AdsFile\\";
	
	private static final Logger logger=LoggerFactory.getLogger(UserActionController.class);

	@Transactional
    public String uploadImageToFileSystem(MultipartFile file,AdsHindiMapper hindi,AdsEnglishMapper Englis) throws IOException {
       // String filePath=FOLDER_PATH+file.getOriginalFilename();

        logger.info("now uploading of Ads start.........");
        String imagePath = saveImage(file);
        logger.info("Image Url.........{}",imagePath);
        
        Ads ads=adsRepo.save(Ads.builder()
        		                   .ImageUrl(imagePath)
        		                   
        		                   .type(file.getContentType())
        		                   .AdsHindiDetail(AdsHindiDetail.builder()
        		                		   .AdsHindiDetail_ID(0)
        		                		   .Headline(hindi.getHeadline())
        		                		   .Contain(hindi.getContain())
        		                		   .build())
        		                   .AdsEnglishDetail(AdsEnglishDetail.builder()
        		                		   .AdsEnglishDetail_ID(0)
        		                		   .Headline(Englis.getHeadline())
        		                		   .Contain(Englis.getContain()).build()) 
        		                   .build());
        
        		          
        	
       
        

        //file.transferTo(new File(filePath));

        
        logger.info("Ads uploaded Done.........");
        
        if (ads != null) {
            return "file uploaded successfully : XXXXXXXXXXXXXXXXXX";
        }
        return null;
        
    }
	
    
	
//      @Transactional 
//      public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
//       
//        
//    	
//        
//        logger.error("  fileName {}",adsRepo.findByAdsName(fileName));
//       // String filePath=fileData.get().getFilePath();
//        //byte[] images = Files.readAllBytes(new File(filePath).toPath());
//       // return images;
//        return null;
//    	
//    }
      
      
      //method to genetratedUrl and change image name
      @Transactional
      private String saveImage(MultipartFile imageFile) throws IOException {
          if (imageFile == null || imageFile.isEmpty()) {
              return null;
          }

          String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
          Path path = Paths.get(FOLDER_PATH + File.separator + fileName);
          Files.createDirectories(path.getParent());
          Files.write(path, imageFile.getBytes());
          
          // Generate download URL
          String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                  .path("/ads/download/")
                  .path(fileName)
                  .toUriString();
          
          return downloadUrl; // Save this URL in the database
      }
}
