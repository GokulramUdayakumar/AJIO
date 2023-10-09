package com.ajio.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ajio_02_HomePage {
	WebDriver driver;

	public Ajio_02_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//img[@width='130px']")
	private WebElement AjioLogo;

	public WebElement getAjioLogo() {
		return AjioLogo;
	}
}
