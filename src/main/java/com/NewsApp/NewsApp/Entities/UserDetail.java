package com.NewsApp.NewsApp.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.NewsApp.NewsApp.Entities.Enum.Language;
import com.NewsApp.NewsApp.Entities.Enum.RevenueType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UserDetail_ID;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Language language;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RevenueType revenueType;
	

	
	@OneToOne(mappedBy ="userDetail")
	@JsonManagedReference
	@ToString.Exclude
	private UserCredentials userCredentials;

	
}
