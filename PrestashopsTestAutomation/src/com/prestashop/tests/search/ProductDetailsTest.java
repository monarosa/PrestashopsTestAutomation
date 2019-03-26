package com.prestashop.tests.search;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ProductPage;
import com.prestashop.pages.ResultsPage;
import com.prestashop.utilities.Configuration;
import com.prestashop.utilities.TestBaseClass;

public class ProductDetailsTest extends TestBaseClass {
	String searchQuery ="Printed Summer Dress";

	
	
	
	/*
	 * Search test 1
	open the prestashop application
	search for "Printed Summer Dress"
	verify a result for "Printed Summer Dress" is displayed

	 */
	@Test (priority = 0)
	public void searchTest(){
		HomePage homePage = new HomePage(driver);
		homePage.search_query.sendKeys(searchQuery+Keys.ENTER);
		ResultsPage resultsPage =new ResultsPage(driver);
		assertTrue(resultsPage.result(searchQuery).isDisplayed());
		
	}
	
	/*
	 * 
	     on the search results page click on a  result for "Printed Summer Dress" is displayed
	     verify that product name is displayed correctly in the products page
	 */
	
	@Test   (priority = 4)
	public void productDetailsTest(){
		ResultsPage resultsPage =new ResultsPage(driver);
		resultsPage.result(searchQuery).click();
		ProductPage productPage = new ProductPage(driver);
		assertEquals(productPage.name.getText(), searchQuery);
	}
	
	@Test   (priority = 5)
	public void anotherTEst(){
//		ResultsPage resultsPage =new ResultsPage(driver);
//		resultsPage.result(searchQuery).click();
//		ProductPage productPage = new ProductPage(driver);
//		assertEquals(productPage.name.getText(), searchQuery);
	}
	
}
































