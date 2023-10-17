package com.ajio.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Ajio_BaseClass {
	public WebDriver driver;
	public ITestResult results;
	public Ajio_ExcelUtility aexcelU = new Ajio_ExcelUtility();
	public Ajio_FileUtility afileU = new Ajio_FileUtility();
	public Ajio_ScreenShotUtility assU = new Ajio_ScreenShotUtility();
	public Ajio_WebDriverUtility awebdriverU = new Ajio_WebDriverUtility();

	@BeforeSuite
	public void OpenBrowser() throws IOException {
		String browsername = afileU.readTheDataFromPropertyFile("browsername");
		if (browsername.equals("chrome")) {
			ChromeOptions optC = new ChromeOptions();
			optC.addArguments("--disable-notifications");
			driver = new ChromeDriver(optC);
		} else if (browsername.equals("edge")) {
			EdgeOptions optE = new EdgeOptions();
			optE.addArguments("--disable-notifications");
			driver = new EdgeDriver(optE);
		}
	}

	@BeforeTest
	public void PreConditions() {
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void OpenWebSite() throws Exception {
		driver.get(afileU.readTheDataFromPropertyFile("url"));
	}

	@AfterMethod
	public void AfterMethod(ITestResult result) throws IOException {
		String testName = result.getName();
		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("Test Failed ScreenShotName is => " + testName);
			assU.tsWebPage(driver, testName);
		}
	}

	// @AfterClass
	public void MinimiseBrowser() throws Exception {
		driver.manage().window().minimize();
		driver.close();
	}

	// @AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

	// @AfterSuite
	public void CleanCookies() {
		System.out.println("@AfterSuite - Clean the cookies");
		driver.manage().deleteAllCookies();
	}
}
