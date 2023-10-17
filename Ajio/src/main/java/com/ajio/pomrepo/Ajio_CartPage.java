package com.ajio.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ajio.genericutility.Ajio_ScreenShotUtility;
import com.ajio.genericutility.Ajio_WebDriverUtility;

public class Ajio_CartPage {
	WebDriver driver;
	public Ajio_ScreenShotUtility assU = new Ajio_ScreenShotUtility();
	public Ajio_WebDriverUtility awebdriverU = new Ajio_WebDriverUtility();

	public Ajio_CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyCart(WebDriver driver) throws Exception {
		Ajio_04_ProductPage app = new Ajio_04_ProductPage(driver);

		String cartExpected = "https://www.ajio.com/cart";
		String cartActual = driver.getCurrentUrl();
		awebdriverU.implicitWait(driver);
		if (cartActual.equals(cartExpected)) {
			app.getProceedToShipping().click();
		} else {
			System.out.println("Failed At => CartPageFailed");
			assU.tsWebPage(driver, "CartPageFailed");
		}
	}
}
