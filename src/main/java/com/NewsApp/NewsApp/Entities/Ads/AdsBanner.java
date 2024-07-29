package com.NewsApp.NewsApp.Entities.Ads;

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
@Entity
@Builder
public class AdsBanner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Banner_Id;
	@Column(nullable = false)
	private String BannerCategory;
	
	@Lob
	private String ImageUrl;
	
	@Lob
	private String Hindi_Header;
	
	@Lob
	private String Hindi_Contain;
	
	@Lob
	private String English_Hearder;
	
	@Lob
	private String English_Contain;
	
	@Column(nullable = false)
	private int Item_order;
	
	
}
