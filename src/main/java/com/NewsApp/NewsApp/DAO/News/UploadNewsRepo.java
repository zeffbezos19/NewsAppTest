package com.NewsApp.NewsApp.DAO.News;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NewsApp.NewsApp.Entities.News.NewsDeatil;

import java.time.LocalDate;
import java.util.List;


public interface UploadNewsRepo extends JpaRepository<NewsDeatil, Integer>{

	
	 List<NewsDeatil> findByDate(LocalDate date);

      
	// Optional<NewsDeatil> findByName(String fileName);
	 //List<NewsDeatil> findByName(String name);

	 //Optional<?> findByNews_ID(int news_ID);
}
