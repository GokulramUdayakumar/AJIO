package com.ajio.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ajio_01_LoginPage {
	WebDriver driver;

	public Ajio_01_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSignIn() {
		return SignIn;
	}

	public WebElement getMobileNumber() {
		return MobileNumber;
	}

	public WebElement getContinueButton() {
		return ContinueButton;
	}

	public WebElement getStartShopping() {
		return StartShopping;
	}

	@FindBy(xpath = "//span[text()='Sign In / Join AJIO']")
	private WebElement SignIn;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement MobileNumber;

	@FindBy(xpath = "//input[@class='login-btn']")
	private WebElement ContinueButton;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement StartShopping;
}
