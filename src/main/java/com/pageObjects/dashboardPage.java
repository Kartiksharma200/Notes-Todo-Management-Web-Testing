package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dashboardPage {
	
	WebDriver driver;
	
	//Locators
	private By NotesMaster = By.xpath("//p[@class='text-[20px] font-bold']");
	private By writeNotes = By.xpath("//strong[normalize-space()='Write Notes']");
	private By noteTittle = By.xpath("//input[@placeholder='Notes Title']");
	private By note = By.xpath("//div[@class='ql-editor ql-blank']//p");
	private By noteSaveBtn = By.xpath("//strong[normalize-space()='Save Changes']");
	private By createNoteBooks = By.xpath("//strong[normalize-space()='Create NoteBook']");
	private By noteBookTittle = By.xpath("//input[@id='title']");
	private By createBookBtn = By.xpath("//body//div//div//div//div[1]//div[1]//div[2]//button[2]");
	private By profile = By.xpath("//button[@class='flex items-center space-x-2 z-20 relative bg-primary-50 rounded-md p-2']//*[name()='svg']");
	private By logoutBtn = By.xpath("//li[normalize-space()='Logout']");
	//Constructors
	public dashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Methods for Create Note Books
	public void clickOnCreateNoteBook() {
		driver.findElement(createNoteBooks).click();
	}
	
	public void writeNoteBookTittle(String BookTittle) {
		driver.findElement(noteBookTittle).sendKeys(BookTittle);
	}
	
	public void submitCreateNoteBook() {
		driver.findElement(createBookBtn).click();
	}
	
	public void verifyCreateNoteBook() {
		WebElement popOfCreateBook = driver.findElement(By.xpath("//div[@id='5']"));
		if(popOfCreateBook.isDisplayed()) {
			System.out.println("<-----------Successfully Create Book------->");
		}else {
			System.out.println("<-----------failed to Create Book---------->");
		}
	}
	
	//Methods for Logout 
	public void clickOnProfile() {
		driver.findElement(profile).click();
	}
	
	public void logoutAccount() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(logoutBtn).click();
	}
	
	
	public void verifyLogout() throws InterruptedException {
		Thread.sleep(3000);
		String accUrl = driver.getCurrentUrl();
		String expUrl = "https://notes-makers.vercel.app/pages/login";
		if(accUrl.equals(expUrl)) {
			System.out.println("<--------------Successful Logout----------->");
		}else {
			System.out.println("<-------------failed to Logout-------------->");
		}
	}
	
	
	
	//Methods for Create an Notes
	public void writeNotes() {
		driver.findElement(writeNotes).click();
	}
	
	public void verifyNotesPage() {
		String accUrl = driver.getCurrentUrl();
		String expUrl = "https://notes-makers.vercel.app/pages/create";
		if (accUrl.equals(expUrl)) {
			System.out.println("<-------On the Notes Page-------->");
		}else {
			System.out.println("<-------Verify the note pages-------->");
		}
	}
	
	public void makeNotesTittle(String tittle) {
		driver.findElement(noteTittle).sendKeys(tittle);
	}
	
	public void makenotes(String notes) {
		driver.findElement(note).sendKeys(notes);
	}
	
	public void saveNotes() throws InterruptedException {
		driver.findElement(noteSaveBtn).click();
		Thread.sleep(3000);
		WebElement deleteNotes = driver.findElement(By.xpath("//body/div/div/main/div/div/button[2]"));
		if(deleteNotes.isDisplayed()) {
			System.out.println("<-------Successful Save Notes-------->");
		}else {
			System.out.println("<-------Failed to Save Notes--------->");
		}
	}
	
	public void redirectToHomepage() {
		driver.findElement(NotesMaster).click();
	}
	
	

}
