package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage{
	
	@FindBy(how=How.ID, using= "login2")
	public WebElement lnkLogin;
	
	@FindBy(how=How.ID, using= "loginusername")
	public WebElement txtEmail;
	
	@FindBy(how=How.ID,using="loginpassword")
	public WebElement txtPassword;
	
	@FindBy(how=How.XPATH,using="//button[text()='Log in']")
	public WebElement btnLogin;
	
	@FindBy(how=How.XPATH,using="//h5[@id='logInModalLabel']")
	public WebElement lblLogin;
	
	public void waitForLoginLableVisible() {
		WebDriverWait wait = new WebDriverWait(webDriver,10);
		wait.until(ExpectedConditions.visibilityOf(lblLogin));
	}
	
	public void enterUserName(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	
	public void clickLoginLnk() {
		WebDriverWait wait = new WebDriverWait(webDriver,10);
		wait.until(ExpectedConditions.elementToBeClickable(lnkLogin));
		lnkLogin.click();
	}
	
	public void clickLoginBtn() {
		btnLogin.click();
	}
}