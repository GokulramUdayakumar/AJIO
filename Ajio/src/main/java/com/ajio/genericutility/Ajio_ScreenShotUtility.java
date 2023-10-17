package com.ajio.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ajio_ScreenShotUtility {
	String timeStamp = LocalDateTime.now().toString().replace(":", "-");

	public void tsWebPage(WebDriver driver, String screenshotName) throws IOException {
		// TakesScreenshot ts = (TakesScreenshot) driver;
		File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File permFile = new File("./errorshots/" + timeStamp + "-" + screenshotName + ".png");
		FileUtils.copyFile(tempFile, permFile);
	}

	public void tsWebElement(WebElement key, String screenshotName) throws IOException {
		File tempFile = key.getScreenshotAs(OutputType.FILE);
		File permFile = new File("./errorshots/" + timeStamp + "-" + screenshotName + ".png");
		FileUtils.copyFile(tempFile, permFile);
	}
}