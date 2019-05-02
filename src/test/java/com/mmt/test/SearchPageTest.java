package com.mmt.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmt.pages.HomePage;
import com.mmt.pages.SearchPage;

import makemytrip.mmt.pom.Base;

public class SearchPageTest extends Base{
HomePage homepage;
SearchPage searchpage;

	public SearchPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void SearchpageInit() throws IOException, InterruptedException {
		Initial();
		homepage=new HomePage();
		searchpage=new SearchPage();
		
		
	}

	@Test()
	public void SearchPageOperationTest() throws IOException, InterruptedException {
		searchpage=homepage.HomePageOperations();
		searchpage.SearchPageOperation();
		searchpage.OneStop();
		searchpage.NonStop();
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
}
