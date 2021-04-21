package com.pages;

import javax.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BasePage {

	@Autowired
	protected WebDriver webDriver;
	
	@PostConstruct
	public void initPage() {
		PageFactory.initElements(webDriver, this);
	}
	
}
