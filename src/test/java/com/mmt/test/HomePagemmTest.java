package com.mmt.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmt.pages.HomePage;
import com.mmt.pages.SearchPage;

import makemytrip.mmt.pom.Base;

public class HomePagemmTest extends Base{
static HomePage homepage;	
static SearchPage searchpage;
public HomePagemmTest() throws IOException {
	super();
}


@BeforeMethod()
public void Setup() throws IOException{

	Initial();
	homepage=new HomePage();
	
}
@Test()
public static void Test1()throws IOException, InterruptedException {
	searchpage=homepage.HomePageOperations();
}

@AfterMethod
public void last() {
driver.close();
}
}
