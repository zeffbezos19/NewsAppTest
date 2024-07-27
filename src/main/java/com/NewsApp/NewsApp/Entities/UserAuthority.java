package com.NewsApp.NewsApp.Entities;

import com.NewsApp.NewsApp.Entities.Enum.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/*
 @AllArgsConstructor(exclude = {"compiledRegex"})
 

*/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class UserAuthority {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UserAuth_id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_ID")
	@JsonBackReference
	@ToString.Exclude //use to avoid infite loop of tostrring method of lombok --for more ->https://stackoverflow.com/questions/54653734/lombok-java-lang-stackoverflowerror-null-on-tostring-method
	private java.util.List<UserCredentials> uderCredentials;
	
}
