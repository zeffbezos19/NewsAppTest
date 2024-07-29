package com.NewsApp.NewsApp.Entities.Ads;

import com.NewsApp.NewsApp.Entities.UserCredentials;
import com.NewsApp.NewsApp.Entities.UserDetail;
import com.NewsApp.NewsApp.Entities.Enum.Language;
import com.NewsApp.NewsApp.Entities.Enum.RevenueType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
@Builder
public class Ads {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Ads_Id;

	
	@Column(nullable=false)
    private String type;
	@Column(nullable=false)
    private String ImageUrl;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AdsHindi_ID")
	private AdsHindiDetail AdsHindiDetail;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AdsEng_ID")
	private AdsEnglishDetail AdsEnglishDetail;
	

	
}
