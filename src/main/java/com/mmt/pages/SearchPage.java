package com.mmt.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import makemytrip.mmt.pom.Base;

public class SearchPage extends Base {

	public SearchPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']")
	List<WebElement> departure_flight;
	
	@FindBy(xpath="//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']")
	List<WebElement> return_flight;
	
	@FindBy(xpath="//span[text()='Non Stop']")
	WebElement non_stop;
	
	@FindBy(xpath="//label[@for='filter_stop1']")
	WebElement one_stop;
	public void SearchPageOperation(){
		
		int total_df=departure_flight.size();
		int total_rf=return_flight.size();
		System.out.println("Total number of departure flight is "+ total_df);
		System.out.println("Total number of return flight is"+total_rf);
		
	}
	public void NonStop() throws InterruptedException {
		
		non_stop.click();
		int total_nonstopdf=departure_flight.size();
		System.out.println("Total number of non stop departure flight is"+total_nonstopdf);
		int total_nonstoprf=return_flight.size();
		System.out.println("Total number of non stop return flight is"+total_nonstoprf);
	}
	
	public void OneStop() throws InterruptedException {
		
		one_stop.click();
		int total_onestopdf=departure_flight.size();
		System.out.println("Total number of one stop departure flight is "+total_onestopdf );
		int total_onestoprf=return_flight.size();
		System.out.println("Total number of one stop return flight is "+total_onestoprf);
	}
}
