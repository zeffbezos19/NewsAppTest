package com.NewsApp.NewsApp.Entities.News;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class NewsArticlesHindi {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int NewsArticlesHindi_ID;
	
	//plz check what happen when we create hindi String 
	@Column(nullable = false)
	private String Headline;
	
	
	//i have to implement check null
	@Lob
	private String Contain;
	
	
	
}
