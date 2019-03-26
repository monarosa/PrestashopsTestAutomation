package com.prestashop.tests.contactus;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import javax.security.auth.PrivateCredentialPermission;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.utilities.Configuration;
import com.prestashop.utilities.StringCommons;
import com.prestashop.utilities.TestBaseClass;

public class PhoneNumberTest extends TestBaseClass {

	String callUsNowExpectedTxt = "Call us now: 0123-456-789";
	String expectedPhoneNum = "0123456789";

	/*
	 * 
	 * test the phone number area
	 */
	@Test(priority = 0)
	public void phoneNumberAreaTest() {

		HomePage homePage = new HomePage(driver);
		String actualCallTxt = homePage.callUsNow.getText();
		assertTrue(homePage.callUsNow.isDisplayed());
		assertEquals(actualCallTxt, callUsNowExpectedTxt);

		String actualPhomeNum = StringCommons.extractNumberFromString(actualCallTxt);
		assertEquals(actualPhomeNum, expectedPhoneNum);
		assertEquals(Long.parseLong(actualPhomeNum), Long.parseLong(expectedPhoneNum));

		// assertTrue(resultsPage.result(searchQuery).isDisplayed());

	}

	@Test(priority = 1)
	public void priceTest() {

		HomePage homePage = new HomePage(driver);
		List<WebElement> prices = homePage.allPrices;
		System.out.println("original list size " + prices.size());

		// Predicate<WebElement> emptyElementRemover = t -> t.length()==0;
		// t.getText().trim().length()==0;
		// prices.removeIf(emptyElementRemover);
		// System.out.println("new list size after removeIf" +prices.size());
		//
		for (int i = 0; i < prices.size(); i++) {
			String priceTxt = prices.get(i).getText();
			System.out.println(priceTxt.substring(1));
			double priceAsNumber = Double.parseDouble(priceTxt.substring(1));
			if (priceAsNumber > 30)
				System.out.println(priceAsNumber);

		}
		prices.removeIf(price -> Double.parseDouble(price.getText().substring(1)) > 30);
		//
		// prices.forEach(e->System.out.println(e.getText()));
		//
		// System.out.println(prices.size());

	}

	@Test
	public void sendMessage() {

	}
}
// prices.removeIf(price -> Double.parseDouble(price.getText().substring(1))>30
// );
//
// prices.forEach(e->System.out.println(e.getText()));
