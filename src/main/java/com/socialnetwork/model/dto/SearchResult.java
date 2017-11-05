package com.socialnetwork.model.dto;

import java.util.Set;

import com.socialnetwork.model.entity.Interest;
import com.socialnetwork.model.entity.Profile;

public class SearchResult {

	private Long userId;
	private String firstName;
	private String surName;
	private Set<Interest> interests;
	
	public SearchResult(Profile profile){
		this.userId = profile.getId();
		this.firstName = profile.getUser().getFirstname();
		this.surName = profile.getUser().getSurname();
		this.interests = profile.getInterests();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Set<Interest> getInterests() {
		return interests;
	}

	public void setInterests(Set<Interest> interests) {
		this.interests = interests;
	}

	@Override
	public String toString() {
		return "SearchResult [userId=" + userId + ", firstName=" + firstName + ", surName=" + surName + ", interests="
				+ interests + "]";
	}
	
	
	
}
