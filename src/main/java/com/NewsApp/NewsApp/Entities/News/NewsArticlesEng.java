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
public class NewsArticlesEng {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int NewsArticlesEng_ID;
	
	
	@Column(nullable = false)
	private String Headline;
	
	@Lob
	private String Contain;
	
	
}
