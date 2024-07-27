package com.NewsApp.NewsApp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@Builder
@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class UserCredentials {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int User_ID;
	
	@Column(nullable=false)
	private String User_Name;
	
	@Column(nullable=false)
	private String User_Email;
	
	@Column(nullable=false)
	private String Phone_Num;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserDetail_ID")
	@JsonManagedReference
	private UserDetail userDetail;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserAuth_ID")
	private UserAuthority userAuthority;


}
