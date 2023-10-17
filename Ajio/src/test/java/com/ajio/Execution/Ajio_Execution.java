package com.ajio.Execution;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ajio.genericutility.Ajio_BaseClass;
import com.ajio.pomrepo.Ajio_01_LoginPage;
import com.ajio.pomrepo.Ajio_02_HomePage;
import com.ajio.pomrepo.Ajio_03_MenPage;
import com.ajio.pomrepo.Ajio_04_ProductPage;
import com.ajio.pomrepo.Ajio_CartPage;
import com.ajio.pomrepo.Ajio_ShippingPage;

public class Ajio_Execution extends Ajio_BaseClass {

	@Test(priority = 1, enabled = false)
	public void Login() throws Exception {
		Ajio_01_LoginPage alp = new Ajio_01_LoginPage(driver);
		alp.getSignIn().click();
		alp.getMobileNumber().sendKeys(afileU.readTheDataFromPropertyFile("mobileno"));
		alp.getContinueButton().click();
		Thread.sleep(10000);
		alp.getStartShopping().click();
		Thread.sleep(5000);
	}

	@Test(priority = 2, enabled = true)
	public void HomePage() throws Exception {
		Ajio_02_HomePage hp = new Ajio_02_HomePage(driver);
		Ajio_03_MenPage amp = new Ajio_03_MenPage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(amp.getMen()).moveToElement(amp.getMenBrands()).moveToElement(amp.getNetplay()).click().build()
				.perform();
		Boolean value = amp.getNetplayVerify().isDisplayed();
		if (value == true) {
			Ajio_Execution ae = new Ajio_Execution();
			ae.netPlay(driver);
		} else {
			System.out.println("NetplayVerify Element Not Displayed");
			hp.getAjioLogo().click();
		}

	}

	public void netPlay(WebDriver driver) throws Exception {
		Ajio_03_MenPage amp = new Ajio_03_MenPage(driver);
		Ajio_04_ProductPage app = new Ajio_04_ProductPage(driver);
		Ajio_CartPage cp = new Ajio_CartPage(driver);
		Ajio_ShippingPage sp = new Ajio_ShippingPage(driver);

		amp.getMenShirts().click();
		amp.getPriceButton().click();
		amp.getPriceBelow().click();

		Select Price = new Select(amp.getSortBy());
		Price.selectByValue("prce-asc");

		amp.getFirstShirt().click();

		Set<String> handles = driver.getWindowHandles();
		Iterator it = handles.iterator();

		String parent = (String) it.next();
		String Child = (String) it.next();

		driver.switchTo().window(Child);

		for (WebElement ObjCurrent : app.getSize()) {
			System.out.println("Size Of Shirt is => " + ObjCurrent.getText());
			ObjCurrent.click();
			break;
		}
		app.getAddToBag().click();
		Thread.sleep(8000);
		app.getBagIcon().click();
		cp.VerifyCart(driver);
		sp.VerifyShippingPage(driver);
	}

	
}
