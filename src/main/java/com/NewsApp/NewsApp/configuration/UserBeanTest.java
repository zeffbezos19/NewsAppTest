package com.NewsApp.NewsApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.NewsApp.NewsApp.Entities.UserAuthority;
import com.NewsApp.NewsApp.Entities.UserCredentials;
import com.NewsApp.NewsApp.Entities.UserDetail;
import com.NewsApp.NewsApp.Entities.Enum.Language;
import com.NewsApp.NewsApp.Entities.Enum.RevenueType;
import com.NewsApp.NewsApp.Entities.Enum.Role;

@Configuration
public class UserBeanTest {

	@Bean(name = "user02")
	@Scope("prototype")
	public UserCredentials getUser01() {
		
		UserCredentials userCredentials=new UserCredentials();
		userCredentials.setUser_Name("User01");
		userCredentials.setUser_Email("user01@gmial.com");
		userCredentials.setPhone_Num("6262655644");
		
		UserAuthority userAuthority=UserAuthority.builder()
            .role(Role.User_Viewer).build();
		
		userCredentials.setUserAuthority(userAuthority);
		//new UserAuthority().setRole(Role.Super_ower)
		
		
		UserDetail userDetail=UserDetail.builder()
				.language(Language.Hindi)
				.revenueType(RevenueType.subscriptions).build();
		userCredentials.setUserDetail(userDetail);
		
		return userCredentials;
		
	}
	
	@Bean(name = "user02")
	@Scope("prototype")
	public UserCredentials getUser02(){
		
		UserCredentials userCredentials=new UserCredentials();
		userCredentials.setUser_Name("User02");
		userCredentials.setUser_Email("user02@gmial.com");
		userCredentials.setPhone_Num("62626511144");
		
		UserAuthority userAuthority=UserAuthority.builder()
            .role(Role.User_Viewer).build();
		
		userCredentials.setUserAuthority(userAuthority);
		//new UserAuthority().setRole(Role.Super_ower)
		
		
		UserDetail userDetail=UserDetail.builder()
				.language(Language.English)
				.revenueType(RevenueType.Ads).build();
		userCredentials.setUserDetail(userDetail);
		
		return userCredentials;
		
	}
	
	
}
