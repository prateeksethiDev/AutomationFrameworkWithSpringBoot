package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import com.pages.HomePage;
import com.pages.LoginPage;

@SpringBootTest
@Profile("default")
class DemoApplicationTests {
	
	@Autowired
	private LoginPage loginPage;
	
	@Autowired
	private HomePage homePage;
	
	//String interpolation happens
		@Value("${app.url}")
		private String appUrl;
		
		@Value("${app.username}")
		private String username;
		
		@Value("${app.password}")
		private String password;

	@Test
	void contextLoads() {
		homePage.getUrl(appUrl);
		homePage.clickLoginLnk();
		homePage.waitForLoginLableVisible();
		homePage.enterUserName(username);
		homePage.enterPassword(password);
		homePage.clickLoginBtn();
	}

}
