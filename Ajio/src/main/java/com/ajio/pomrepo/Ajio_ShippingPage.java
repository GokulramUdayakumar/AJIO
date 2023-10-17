package com.ajio.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ajio.genericutility.Ajio_ScreenShotUtility;
import com.ajio.genericutility.Ajio_WebDriverUtility;

public class Ajio_ShippingPage {
	WebDriver driver;
	public Ajio_ScreenShotUtility assU = new Ajio_ScreenShotUtility();
	public Ajio_WebDriverUtility awebdriverU = new Ajio_WebDriverUtility();

	public Ajio_ShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyShippingPage(WebDriver driver) throws Exception {
		Ajio_04_ProductPage app = new Ajio_04_ProductPage(driver);
		
		String shippingExpected = "https://www.ajio.com/shipping";
		String shippingActual = driver.getCurrentUrl();
		if (shippingActual.equals(shippingExpected)) {
			awebdriverU.implicitWait(driver);
			app.getProceedToPayment().click();
			Thread.sleep(8000);
		} else {
			System.out.println("Failed At => ShipppingPageFailed");
			assU.tsWebPage(driver, "ShipppingPageFailed");
		}
	}
}
