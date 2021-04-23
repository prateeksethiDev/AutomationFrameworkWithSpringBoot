package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.LoginPage;


class DemoApplicationTests extends BaseTest{
	
	@Autowired
	private LoginPage loginPage;
	
	@Autowired
	private HomePage homePage;
	
	//String interpolation happens		
		@Value("${app.username}")
		private String username;
		
		@Value("${app.password}")
		private String password;

	@Test
	void contextLoads() {
		homePage.clickLoginLnk();
		homePage.waitForLoginLableVisible();
		homePage.enterUserName(username);
		homePage.enterPassword(password);
		homePage.clickLoginBtn();
	}

}
