package com.NewsApp.NewsApp.Service.News;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

import org.apache.el.stream.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.NewsApp.NewsApp.Controller.User.UserActionController;
import com.NewsApp.NewsApp.DAO.News.UploadNewsRepo;
import com.NewsApp.NewsApp.Entities.Enum.Category;
import com.NewsApp.NewsApp.Entities.News.NewsArticlesEng;
import com.NewsApp.NewsApp.Entities.News.NewsArticlesHindi;
import com.NewsApp.NewsApp.Entities.News.NewsDeatil;
import com.NewsApp.NewsApp.Entities.News.NewsMapperEnglish;
import com.NewsApp.NewsApp.Entities.News.NewsMapperHindi;

import jakarta.validation.constraints.AssertFalse.List;

@Service
public class NewsUpload {
    
	
	
	@Autowired
	private UploadNewsRepo uploadNews;
	
	private String FOLDER_PATH="C:\\Users\\ashwa\\OneDrive\\Documents\\MyFile\\";
	
	private static final Logger logger=LoggerFactory.getLogger(UserActionController.class);

	@Transactional
    public String uploadImageToFileSystem(MultipartFile file,NewsMapperHindi hindi,NewsMapperEnglish Englis) throws IOException {
       // String filePath=FOLDER_PATH+file.getOriginalFilename();

        logger.info("now uploading of news start.........");
        String imagePath = saveImage(file);
        logger.info("Image Url.........");
        
        NewsDeatil newsDeatil=uploadNews.save(NewsDeatil.builder()
        		                   .ImageUrl(imagePath)
        		          
        		                   .type(file.getContentType())
        		                   .category(Category.Business)
        		                   .newsArticlesEng(NewsArticlesEng.builder().Headline(Englis.getHeadline())
        		                		            .Contain(Englis.getContain()).build()
        		                		   )
        		                   .newsArticlesHindi(NewsArticlesHindi.builder().Headline(hindi.getHeadline())
        		                		                .Contain(hindi.getContain()).build()
        		                		   ).build()
        		);
        
        

        //file.transferTo(new File(filePath));

        
        logger.info("now uploaded Done.........");
        
        if (newsDeatil != null) {
            return "file uploaded successfully : XXXXXXXXXXXXXXXXXX";
        }
        return null;
    }
	
    
	
      @Transactional 
      public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
       
        
    	
        
        logger.error("  fileName {}",uploadNews.findByName(fileName));
       // String filePath=fileData.get().getFilePath();
        //byte[] images = Files.readAllBytes(new File(filePath).toPath());
       // return images;
        return null;
    	
    }
      
      
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
                  .path("/download/")
                  .path(fileName)
                  .toUriString();
          
          return downloadUrl; // Save this URL in the database
      }
      
}
