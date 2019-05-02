package com.mmt.pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mmt.util.DateOperation;

import makemytrip.mmt.pom.Base;

public class HomePage extends Base{
	//DateOperation dateoperation;
	
public  HomePage() throws IOException{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//li[text()='Round Trip']")
WebElement roundtrip;

@FindBy (xpath="//input[@aria-autocomplete='list']")
WebElement autosuggest;

@FindBy(xpath="//input[@id='fromCity']")
WebElement from;

@FindBy (xpath="//input[@id='toCity']")
WebElement to;

@FindBy(xpath="//div[@class='DayPicker-Caption']/div")
WebElement caption;

@FindBy(xpath="//label[@for='departure']")
WebElement departure;

@FindBy(xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
WebElement button;

@FindBy(xpath="//label[@for='return']")
WebElement return_ele;

@FindBy(xpath="//a[@class='primaryBtn font24 latoBlack widgetSearchBtn ']")
WebElement search;
public  SearchPage HomePageOperations() throws InterruptedException, IOException {
	String title=driver.getTitle();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date dateandtime = new Date();
	String dateformat=dateFormat.format(dateandtime);
	if(prop.getProperty("type").equals("Round Trip")) {
    roundtrip.click();
	}
	String[] today=dateformat.split(" ");
	String dates=today[0];
	System.out.println("Today's date is"+dates) ;
	String[] date_split=dates.split("/");
	String day=date_split[0];
	String month=date_split[1];
	String years=date_split[2];
	DateOperation.Operation(day, month, years);
	Assert.assertEquals(title,"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday");
	String depart=prop.getProperty("from");
	System.out.println("departure is "+depart);
	String dest=prop.getProperty("to");
	System.out.println("Destination is "+dest);
	from.click();
	Thread.sleep(1000);
	autosuggest.sendKeys(depart);
	autosuggest.sendKeys(Keys.DOWN);
	Thread.sleep(1000);
	autosuggest.sendKeys(Keys.ENTER);
	
	Thread.sleep(1000);
	autosuggest.sendKeys(dest);
	autosuggest.sendKeys(Keys.DOWN);
	Thread.sleep(1000);
	autosuggest.sendKeys(Keys.ENTER);
	//departure.click();
	String month_dis=caption.getText();
	String[] month_dis1=month_dis.split("2");
	String month_displayed=month_dis1[0];
	
	while(month_displayed.equals(DateOperation.month_to_select)) {
		System.out.println(DateOperation.month_to_select);
	if(month_displayed.contains(DateOperation.month_to_select)) {
		if(DateOperation.date<=DateOperation.total) {
			driver.findElement(By.xpath("//div[@class='dateInnerCell']/p[text()="+DateOperation.date+"]")).click();
			System.out.println("Date clicked");
			break;
		}
		else {
			button.click();
		}   
	}
	}
	
	//System.out.println("The return date is "+ DateOperation.return_date);
	if(DateOperation.return_date>DateOperation.total) {
		int revamp_rd=DateOperation.return_date-DateOperation.total;
		Thread.sleep(2000);
		Thread.sleep(2000);
		button.click();
		Thread.sleep(2000);
		WebElement return_Dt=driver.findElement(By.xpath("//div[@class='dateInnerCell']/p[text()="+revamp_rd+"]"));
		return_Dt.click();
		System.out.println("return date is "+revamp_rd+" and is selected" );
	}else {
		int revamp_rd=DateOperation.return_date;
		driver.findElement(By.xpath("//div[@class='dateInnerCell']/p[text()="+revamp_rd+"]")).click();
	}
	Thread.sleep(10000);
	search.click();
	return new SearchPage();
	
}
}
