package com.NewsApp.NewsApp.Service.Ads;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.NewsApp.NewsApp.Controller.Admin.BannerController;
import com.NewsApp.NewsApp.DAO.Ads.AdsBannerRepo;
import com.NewsApp.NewsApp.DAO.Ads.AdsRepo;
import com.NewsApp.NewsApp.DAO.News.UploadNewsRepo;
import com.NewsApp.NewsApp.Entities.Ads.Ads;
import com.NewsApp.NewsApp.Entities.Ads.AdsBanner;
import com.NewsApp.NewsApp.Entities.Ads.BannerOrder;
import com.NewsApp.NewsApp.Entities.News.NewsDeatil;
import com.NewsApp.NewsApp.configuration.BannerQueue;

@Service
public class BannerService {
	
	@Autowired
	AdsRepo AdsRepo;
	@Autowired
	UploadNewsRepo uploadNewsRepo;
	@Autowired
	AdsBannerRepo adsBannerRepo;
	@Autowired
    private BannerQueue bannerQueue;
	
	private static final Logger logger=LoggerFactory.getLogger(BannerService.class);

	
	@Transactional
	public boolean ArrangeBannerTable(BannerOrder[] order) {
		
        Arrays.sort(order, (o1, o2) -> Integer.compare(o1.getOrder(), o2.getOrder()));
		
        bannerQueue.EmptyTheQueue();
        
		 for (int i = 0; i < order.length; i++) {
		        //System.out.println(order[i])
			 if(order[i].getCategory().charAt(0)=='n') {
				 System.out.println("news");
				 Optional<NewsDeatil> newsDeatil =uploadNewsRepo.findById(order[i].getId());
                
				// System.out.println(newsDeatil);
				 
				 AdsBanner adsBannerdata = new AdsBanner();;
				 
				 newsDeatil.ifPresent(data->{
					 adsBannerdata.setImageUrl(data.getImageUrl());
					 adsBannerdata.setHindi_Contain(data.getNewsArticlesHindi().getContain());
					 adsBannerdata.setHindi_Header(data.getNewsArticlesHindi().getHeadline());
					 adsBannerdata.setEnglish_Contain(data.getNewsArticlesEng().getContain());
					 adsBannerdata.setEnglish_Hearder(data.getNewsArticlesEng().getHeadline());
				
				 });
				 
				 adsBannerdata.setBannerCategory(order[i].getCategory());
				 adsBannerdata.setItem_order(order[i].getOrder());
				 System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				 System.out.println(adsBannerdata.toString());
				 
				 //now insert into table
				 AdsBanner adsdata=adsBannerRepo.save(adsBannerdata);
				 logger.info("save to table ....new....{}",adsdata);	
						 
				 
				 
			    bannerQueue.addProduct(adsdata);
				 
			 }else {
				 System.out.println("ads"); 
				 Optional<Ads> ads=AdsRepo.findById(order[i].getId());
				 AdsBanner adsBannerdata = new AdsBanner();;
				 
				 ads.ifPresent(data->{
					 adsBannerdata.setImageUrl(data.getImageUrl());
					 adsBannerdata.setHindi_Contain(data.getAdsHindiDetail().getContain());
					 adsBannerdata.setHindi_Header(data.getAdsHindiDetail().getHeadline());
					 adsBannerdata.setEnglish_Contain(data.getAdsEnglishDetail().getContain());
					 adsBannerdata.setEnglish_Hearder(data.getAdsEnglishDetail().getHeadline());
				
				 });
				 
				 adsBannerdata.setBannerCategory(order[i].getCategory());
				 adsBannerdata.setItem_order(order[i].getOrder());
				 
				 AdsBanner adsdata=adsBannerRepo.save(adsBannerdata);
				 logger.info("save to table ...ads.....{}",adsdata);	
						 
				 
				 
			    bannerQueue.addProduct(adsdata);
				 System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				 System.out.println(adsBannerdata.toString());
				// System.out.println(ads);
			 }
		    }
		
		 System.out.println("yyyyyyyyyyyyyyyyyyyxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			
		 //bannerQueue.getProduct();
		 return true;
	}


	public List<AdsBanner> getDataofBanner() {
		// TODO Auto-generated method stub
		
		logger.info("processing  banner data XXXXXXXXXXXXXXXX");
		if(bannerQueue.isEmpty()) {
			 System.out.println("fecching for db....");
			 List<AdsBanner> banner= adsBannerRepo.findAll();
			 if(banner.size()==0) {
				 return null; }
			 else {
				 banner.forEach(data-> bannerQueue.addProduct(data));
				 logger.info("banner cache is empty() of putting data");
				 return bannerQueue.getProduct();
				 }
		}else {
			System.out.println("fecching for cache....");
			return bannerQueue.getProduct();
		}
		
		
		
	}

}
