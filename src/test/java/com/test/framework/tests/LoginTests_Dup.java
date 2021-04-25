package com.test.framework.tests;

import org.testng.annotations.Test;

import com.test.framework.pages.HomePage;
import com.test.framework.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.testng.annotations.Test;

@SpringBootTest
class LoginTests_Dup extends BaseTest{
	
	//String interpolation happens		
		@Value("${app.username}")
		private String username;
		
		@Value("${app.password}")
		private String password;
		
		@Value("${app.url}")
		private String appUrl;

	@Test
	@DirtiesContext
	void loginTest2() {
		HomePage homePage=getPage(HomePage.class);
		homePage.launchURL(appUrl);
		homePage.clickLoginLnk();
		homePage.waitForLoginLableVisible();
		homePage.enterUserName(username);
		homePage.enterPassword(password);
		homePage.clickLoginBtn();
	}

}