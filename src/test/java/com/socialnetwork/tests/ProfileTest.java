package com.socialnetwork.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.socialnetwork.App;
import com.socialnetwork.model.entity.Interest;
import com.socialnetwork.model.entity.Profile;
import com.socialnetwork.model.entity.SiteUser;
import com.socialnetwork.service.InterestService;
import com.socialnetwork.service.ProfileService;
import com.socialnetwork.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebAppConfiguration
@Transactional
public class ProfileTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private InterestService interestService;

	
	private SiteUser[] users = {
			new SiteUser("hgjhgjkkk@nikos.com","sdvsdv"),
			new SiteUser("sfhgjkkk@nikos.com","sdvsdv"),
			new SiteUser("hgadfjhgjkkk@nikos.com","sdvsdv"),
	};
	
	private String[][] interests = {
			{"music", "guitar_xxxxx", "plants"},
			{"music", "music", "philosophy_uhuhuhu"},
			{"philosophy_uhuhuhu", "football"},
	};
	
	@Test
	@WithMockUser(username="good@user") // I fix it!? so the user with username = user to be authenticated?
	public void testInterests(){
		
		for(int i=0;i<users.length;i++){
			SiteUser user = users[i]; 
			String[] interestArray = interests[i];
			
			userService.register(user);
			
			HashSet<Interest> interestSet = new HashSet<>();
			
			for(String interestText: interestArray){
				Interest interest = interestService.createIfNotExists(interestText);   
				interestSet.add(interest);
				
				assertNotNull("Interest should not be null", interest);
				assertNotNull("Interest should have an Id", interest.getId());
				assertEquals("Text should match", interestText, interest.getName());
			}
			
			Profile profile = new Profile(user);
			profile.setInterests(interestSet);
			profileService.save(profile);
			
			Profile retrievedProfile = profileService.getUserProfile(user);
			
			assertEquals("Interest set should match", interestSet, retrievedProfile.getInterests());
		}
		
	}
	
	
	
}





