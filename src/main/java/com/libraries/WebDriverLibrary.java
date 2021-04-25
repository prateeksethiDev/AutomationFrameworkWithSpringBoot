package com.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
public class WebDriverLibrary {
	
	
	
//	@Bean
//	@ConditionalOnProperty(name = "browser",havingValue = "chrome")
//	@Scope(scopeName = "driverscope")
//	public WebDriver getChromeDriver() {
//		WebDriverManager.chromiumdriver().setup();
//		return new ChromeDriver();
//	}
//	
//	@Bean
//	@ConditionalOnProperty(name = "browser",havingValue = "firefox")
//	@Scope(scopeName = "driverscope")
//	public WebDriver getFirefoxDriver() {
//		WebDriverManager.firefoxdriver().setup();
//		return new FirefoxDriver();
//	}
}