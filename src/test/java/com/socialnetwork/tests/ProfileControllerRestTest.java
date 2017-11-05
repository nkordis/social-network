package com.socialnetwork.tests;

import javax.transaction.Transactional;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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
public class ProfileControllerRestTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private InterestService interestService;

	
	private MockMvc mocMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp(){
		this.mocMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	@WithMockUser(username="nikos@nikos")
	public void testSaveAndDeleteInterest() throws Exception{
		
		String interestText = "some interest_here";
		
		mocMvc.perform(post("/save-interest").param("name", interestText)).
		andExpect(status().isOk());
		
		Interest interest = interestService.get(interestText);
		assertNotNull("Interest should not be null", interest);
		assertEquals("Retrieved interest should match", interestText, interest.getName());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		SiteUser user = userService.get(email);
		Profile profile = profileService.getUserProfile(user);
		
		assertTrue("Profile should contain interest", profile.getInterests().contains(new Interest(interestText)));
		
		mocMvc.perform(post("/delete-interest").param("name", interestText)).
		andExpect(status().isOk());
		
		profile = profileService.getUserProfile(user);
		assertFalse("Profile should not contain interest", profile.getInterests().contains(new Interest(interestText)));

		
	}
	
}




