/**
 *  Login Page
 */
package com.olenick.avatar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author dpiriz
 *
 */
public class Login {

	WebDriver driver;
	WebElement txtUser, txtPassword;
	String prodBaseUrl = "http://www.improvingcare.com";
	String devBaseUrl = "http://icare-dev";
	
	public Login (WebDriver pDriver) {
		driver = pDriver; 
	}
	
	public Login open(boolean dev) {
		if (dev) { driver.get(devBaseUrl); } else { driver.get(prodBaseUrl);};
		detectWebElements();
		return this;
	}
	
	public Landing login(String user, String pass) throws InterruptedException {
		setUser(user);
		setPassword(pass);
		txtPassword.submit();
		Landing landingPage = new Landing(driver, true);
		return landingPage;
	}

	
	
	/*
	 * 
	 *  ----------------------------------------------------------------------------
	 *                              COMMON METHODS
	 *  ---------------------------------------------------------------------------- 
	 * 
	 */
	
	private void detectWebElements() {
		txtUser = driver.findElement(By.id("userIDTF"));
		txtPassword = driver.findElement(By.id("passwordTF"));
	}
	
	private void setPassword(String pass) {
		txtPassword.clear();
		txtPassword.sendKeys(pass);
	}

	private void setUser(String user) {
		txtUser.clear();
		txtUser.sendKeys(user);
	}
	
}
