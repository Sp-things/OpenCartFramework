package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	
	
	@BeforeClass
	public void registerSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}
	
	//MSexcel: .xlsx : read using apache POI
	
	
	@DataProvider
	public Object[][] getUserRegTestData() {
		return new Object[][] {
			{"vishal", "mehta", "9876543211", "vishal@123", "yes"},
			{"jyothi", "sharma", "9876543212", "jyothi@123", "no"},
			{"Archana", "verma", "9876543209", "arch@123", "yes"}
		};
	}
	
	@DataProvider
	public Object[][] getUserRegData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
	}
	
	@Test(dataProvider = "getUserRegData")
	public void userRegisterTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		Assert.assertTrue(
				registerPage.
					userRegisteration(firstName, lastName, telephone, password, subscribe));
	}
	

}
