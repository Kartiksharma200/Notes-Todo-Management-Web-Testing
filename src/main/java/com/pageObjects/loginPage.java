package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	  WebDriver driver;

	    // Locators
	    private By emailField = By.xpath("//input[@id='email']");
	    private By passwordField = By.xpath("//input[@id='password']");
	    private By loginButton = By.xpath("//body//div//div//main//div//div//div//div//div//button//strong[contains(text(),'Login')]");

	    public loginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void enterEmail(String email) {
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }
	

}
