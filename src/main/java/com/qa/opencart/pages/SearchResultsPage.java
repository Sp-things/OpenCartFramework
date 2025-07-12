package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class SearchResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private final By resultsProduct = By.cssSelector("div.product-thumb");
	
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	@Step("getting the product count on results page")
	public int getResultsProductCount() {
		int searchCount = 
				eleUtil.waitForAllElementsVisible(resultsProduct, AppConstants.MEDIUM_DEFAULT_TIMEOUT).size();
		System.out.println("total number of search products: "+ searchCount);
		return searchCount;
	}
	
	
	public ProductInfoPage selectProduct(String productName) {
		System.out.println("product name: "+ productName);
		eleUtil.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}
	
	

}
