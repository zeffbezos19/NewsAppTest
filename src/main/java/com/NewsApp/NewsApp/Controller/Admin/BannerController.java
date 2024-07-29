package com.NewsApp.NewsApp.Controller.Admin;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NewsApp.NewsApp.Entities.Ads.AdsBanner;
import com.NewsApp.NewsApp.Entities.Ads.BannerOrder;
import com.NewsApp.NewsApp.Service.Ads.BannerService;


@RestController
@RequestMapping("/banner")
public class BannerController {
	
	private static final Logger logger=LoggerFactory.getLogger(BannerController.class);

     @Autowired
     BannerService bannerService;
	
	@PostMapping("/order")
	public ResponseEntity<?> SetBannerOrder(@RequestBody BannerOrder[] order)throws IOException
	{
		//here we get order of news and banner 
		//our service update adsbanner table and by fetch news and ads and put to database table of adsbanner;

		bannerService.ArrangeBannerTable(order);
		logger.info("array of ids and order {}",order);
		return null;
	}
	


	@GetMapping("/get")
	public ResponseEntity<?> GetBannerOrder()throws IOException
	{
		//service check if queue is empty fetch to db or if not fetch data to queue
		
		logger.info("fetching banner data XXXXXXXXXXXXXXXX");
		List<AdsBanner> banners=bannerService.getDataofBanner();
		  if (banners != null) {
	            return new ResponseEntity<>(banners, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	
	}
	
}
