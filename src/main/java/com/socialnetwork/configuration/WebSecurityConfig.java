package com.socialnetwork.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.socialnetwork.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		
		http
			.authorizeRequests()
				.antMatchers(
						"/",
						"/about",
						"/register",
						"/verifyemail",
						"/registrationconfirmed",
						"/invaliduser",
						"/expiredtoken",
						"/confirmregister",
						"/search",
						"/profilephoto/*"
						)
				.permitAll()
				.antMatchers(
						"/js/*",
						"/css/*",
						"/img/*"
						).
				permitAll()
			   .antMatchers(
					   "/addstatus",
					   "/viewstatus",
					   "/editstatus",
					   "/deletestatus"
					   )
			   .hasRole("ADMIN")
			   .antMatchers(
					   "/profile"
					   
					   )
			   .authenticated()
			   .anyRequest()
			   .denyAll()
			   .and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
			.logout()
				.permitAll();
		
		//@formatter:on

		super.configure(http);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}
	
	

}
