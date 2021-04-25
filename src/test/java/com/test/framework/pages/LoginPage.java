package com.test.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.test.framework.annotations.PageObject;

@PageObject
@Component
public class LoginPage extends BasePage{
	
	@FindBy(how = How.ID,using = "UserName")
	public WebElement txtUserName;
	
	@FindBy(how = How.ID,using = "Password")
	public WebElement txtPassword;
	
	@FindBy(how=How.CSS,using = " input[value='Log in']")
	public WebElement btnlogin;
	
	public void login(String userName,String password) {
		System.out.println("username and password "+userName+"---"+password);
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys(password);
		btnlogin.click();
	}
}