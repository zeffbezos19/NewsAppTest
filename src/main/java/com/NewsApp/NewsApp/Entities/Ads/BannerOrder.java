package com.NewsApp.NewsApp.Entities.Ads;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BannerOrder {
	
	    @JsonProperty("Id")
	    private int id;

	    @JsonProperty("order")
	    private int order;

	    @JsonProperty("Category")
	    private String category;
	

}
