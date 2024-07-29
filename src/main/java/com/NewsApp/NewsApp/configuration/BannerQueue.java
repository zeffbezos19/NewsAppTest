package com.NewsApp.NewsApp.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Component;

import com.NewsApp.NewsApp.Entities.Ads.AdsBanner;


@Component
public class BannerQueue {

	    private static final int MAX_SIZE = 10;
	    private final ConcurrentLinkedQueue<AdsBanner> queue = new ConcurrentLinkedQueue<>();

	    public void addProduct(AdsBanner product) {
	        if (queue.size() >= MAX_SIZE) {
	            queue.poll(); // Remove the oldest product if the queue is full
	        }
	        queue.offer(product);
	    }

	    public List<AdsBanner> getProduct() {
	    	List<AdsBanner> banners = new ArrayList<>();
	    	queue.forEach(data -> 
	    	{System.out.println("Do your thing.");
	    	 System.out.println(data.toString());
	    	  banners.add(data);
	    	});
	        //return queue.poll();
	    	return banners;
	    }

	    public boolean isEmpty() {
	        return queue.isEmpty();
	    }
	    
	    public boolean EmptyTheQueue() {
	         queue.clear(); 
	         if(queue.isEmpty()) {
	        	 return true;
	         }
	         return false;
	    }
	    
	
}
