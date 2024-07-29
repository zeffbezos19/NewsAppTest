package com.NewsApp.NewsApp.Service.News;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.NewsApp.NewsApp.DAO.News.UploadNewsRepo;
import com.NewsApp.NewsApp.Entities.News.NewsDeatil;


@Service
public class GetNewsbyRequest {
	
	private static final Logger logger=LoggerFactory.getLogger(GetNewsbyRequest.class);

	
	@Autowired
	UploadNewsRepo uploadNewsRepo;
	
	public Page<NewsDeatil> getTrendingNews(int pageNo){
		 // First page with 5 items
           Pageable paging = PageRequest.of(pageNo, 5, Sort.by("date").descending());    
           org.springframework.data.domain.Page<NewsDeatil> page =uploadNewsRepo.findAll(paging);
           
           return  page;
		
	}

}
