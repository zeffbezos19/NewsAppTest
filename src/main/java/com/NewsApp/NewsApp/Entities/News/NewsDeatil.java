package com.NewsApp.NewsApp.Entities.News;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import com.NewsApp.NewsApp.Entities.Enum.Category;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class NewsDeatil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int News_ID;
	

	@JsonFormat(pattern = "yyyy-MM-dd")
	@CreationTimestamp(source = SourceType.DB)	
	private LocalDate date;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Category category;
	
	@Column(nullable=false)
    private String type;
	@Column(nullable=false)
    private String ImageUrl;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "NewsHindi_ID")
	private NewsArticlesHindi newsArticlesHindi;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "NewsEng_ID")
	private NewsArticlesEng newsArticlesEng;
	

	

	
	
	
}
