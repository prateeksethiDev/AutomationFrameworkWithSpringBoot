package com.test.framework.pages;

import javax.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.test.framework.annotations.PageObject;

@Component
@PageObject
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BasePage implements IWebDriverAware{

	@Autowired
	protected WebDriver webDriver;
	
	@PostConstruct
	public void initPage() {
		PageFactory.initElements(webDriver, this);
	}
	
	public WebDriver getWebDriver() {
	    return webDriver;
	  }
	
	public void launchURL(String url) {
        webDriver.get(url);
    }
	
}
