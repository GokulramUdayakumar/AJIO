package com.ajio.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ajio_03_MenPage {
	WebDriver driver;

	public Ajio_03_MenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getMen() {
		return Men;
	}

	public WebElement getMenBrands() {
		return MenBrands;
	}

	public WebElement getNetplay() {
		return Netplay;
	}

	public WebElement getNetplayVerify() {
		return NetplayVerify;
	}

	public WebElement getMenShirts() {
		return MenShirts;
	}
	
	public WebElement getPriceButton() {
		return PriceButton;
	}

	public WebElement getPriceBelow() {
		return PriceBelow;
	}
	
	public WebElement getSortBy() {
		return SortBy;
	}

	public WebElement getFirstShirt() {
		return FirstShirt;
	}

	@FindBy(xpath = "//a[text()='MEN']")
	private WebElement Men;

	@FindBy(xpath = "//a[text()='MEN']/..//li[2]//a[text()='BRANDS']")
	private WebElement MenBrands;

	@FindBy(xpath = "//span[text()='EXCLUSIVE BRANDS']/../../../div[2]//a[text()='Netplay']")
	private WebElement Netplay;

	@FindBy(xpath = "//div[@class='products']/div[1]/h1/div[2]")
	private WebElement NetplayVerify;

	@FindBy(xpath = "(//div[@class='facet-linkhead'])[2]")
	WebElement MenShirts;

	@FindBy(xpath = "//span[text()='price']")
	WebElement PriceButton;

	@FindBy(xpath = "(//div[@class='facet-linkhead'])[7]")
	WebElement PriceBelow;
	
	@FindBy(xpath = "//div[@class='filter-dropdown']/select")
	WebElement SortBy;

	@FindBy(xpath = "(//div[@class='items'])[98]/div/div/div[1]")
	WebElement FirstShirt;	
}
