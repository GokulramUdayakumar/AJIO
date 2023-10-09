package com.ajio.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Ajio_WebDriverUtility {

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
}
