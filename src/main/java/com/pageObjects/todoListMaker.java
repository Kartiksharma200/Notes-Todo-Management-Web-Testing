package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class todoListMaker {
	
	private WebDriver driver;
	
	//Constructor
	public todoListMaker(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	
	By profileTodo = By.xpath("//li[normalize-space()='To-Do List']");
	By todoTittle = By.xpath("//input[contains(@placeholder,'Write Todo')]");
	By todoPriority = By.xpath("//select[1]");
	By todoAddBtn = By.xpath("//strong[normalize-space()='Add']");
	
	
	//Methods
	
	public void clickOnProfileTodoList() {
		driver.findElement(profileTodo).click();
	}
	
	public void makeTittleOfTodo(String Todo) {
		driver.findElement(todoTittle).sendKeys(Todo);
	}
	
	public void selectPriority(String priority) {
		WebElement drop = driver.findElement(todoPriority);
		drop.click();
		Select select = new Select(drop);
		select.selectByVisibleText(priority);
	}
	
	public void clickOnAddBtn() {
		driver.findElement(todoAddBtn).click();
		System.out.println("<---------Add New Todo---------> ");
	}

}
