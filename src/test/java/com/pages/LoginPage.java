package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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