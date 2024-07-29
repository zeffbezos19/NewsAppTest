package com.NewsApp.NewsApp.Entities.Ads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AdsEnglishMapper {
	
	private int AdsEnglishDetail_ID;
    private String Headline;
    private String Contain;
}
