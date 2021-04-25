package com.test.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.SimpleThreadScope;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
@ComponentScan("com.test.framework")
public class TestConfig {
	WebDriver driver;
	@Bean
    public CustomScopeConfigurer newCustomScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        SimpleThreadScope threadScope = new SimpleThreadScope();
        configurer.addScope("thread", threadScope);
        return configurer;
    }

    @Bean
    @ConditionalOnProperty(name = "browser",havingValue = "firefox")
    @Scope(scopeName = "thread")
    public WebDriver getDriver() {
    	WebDriverManager.firefoxdriver().setup();
    	driver=new FirefoxDriver();
    	return driver;
    }
    
    @Bean
    @ConditionalOnProperty(name = "browser",havingValue = "chrome")
    @Scope(scopeName = "thread")
    public WebDriver getChrome() {
    	WebDriverManager.chromedriver().setup();
    	driver= new ChromeDriver();
    	return driver;
    }
}
