package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



/**
 * 
 * @author prateek.sethi<br>
 * 
 * @apiNote
 * This class acts as a parent class for all the Test classes.
 * we are overriding the springTestContextPrepareTestInstance method of class AbstractTestNGSpringContextTests to resolve the 
 * webDriver dependency in @BeforeSuite annotated method.
 * Also, this class is annotated with @SpringBootTest, which bootstrap the entire container. This will create a ApplicationContext 
 * that will be utilized in our tests.
 *
 */
@SpringBootTest
@Profile("default")
public class BaseTest extends AbstractTestNGSpringContextTests{
	
	@Value("${app.url}")
	private String appUrl;
	
	@Autowired
	protected WebDriver webDriver;
	
	@BeforeTest
	protected void setup() {
		webDriver.get(appUrl);
		webDriver.manage().window().maximize();
	}
	
	@BeforeSuite(alwaysRun=true)
	@Override
	protected void springTestContextPrepareTestInstance() throws Exception {
		super.springTestContextPrepareTestInstance();
		System.out.println("Going to start Running Tests!! "+"\uD83D\uDE00");
	}
	
}