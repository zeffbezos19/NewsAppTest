package com.NewsApp.NewsApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.NewsApp.NewsApp.Entities.News.NewsArticlesEng;
import com.NewsApp.NewsApp.Entities.News.NewsArticlesHindi;

@Configuration
public class NewsBeantest {
	
	@Bean(name = "eng")
	@Scope("prototype")
	public NewsArticlesEng setNewsArticlesEng(){
		
		return NewsArticlesEng.builder()
				                        .Headline("this is news Head line ")
				                        .Contain("this is conail of news app")
				                        .build();
		
		
	}
	
	
	@Bean(name = "hindi")
	@Scope("prototype")
	public NewsArticlesHindi setNewsArticlesHindi(){
		
		return NewsArticlesHindi.builder()
				.NewsArticlesHindi_ID(5)
				                        .Headline("this is news Head line ")
				                        .Contain("")
				                        .build();
		
		
	}
	

}
