package com.mmt.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mmt.util.Waits;

public class s {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Waits.implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Waits.pageload_time, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		
		WebElement RT=driver.findElement(By.xpath("//li[text()='Round Trip']"));
		RT.click();
		WebElement from=driver.findElement(By.xpath("//input[@id='fromCity']"));
		from.click();
		Thread.sleep(3000);
		WebElement autosuggest=driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
		autosuggest.sendKeys("MAA");
		Thread.sleep(2000);
		autosuggest.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		autosuggest.sendKeys(Keys.ENTER);
		
        WebElement to=driver.findElement(By.xpath("//input[@id='toCity']"));
        to.click();		
		Thread.sleep(2000);
		autosuggest.sendKeys("DEL");
		autosuggest.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		autosuggest.sendKeys(Keys.ENTER);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date datef = new Date();
		String dt=dateFormat.format(datef);
		String[] today=dt.split(" ");
		String dates=today[0];
		String[] date_split=dates.split("/");
		String day=date_split[0];
		String month=date_split[1];
		String years=date_split[2];
		
		int date=Integer.parseInt(day)+1;
		String mon=month;
		String mon3=mon.replace("0", "");
		int mon4=Integer.parseInt(mon3);
		System.out.println(mon3);
		String year=years;
		Map<Integer,Integer> m_d1=new HashMap<Integer,Integer>();
		m_d1.put(1, 31);
		m_d1.put(2, 28);
		m_d1.put(3, 31);
		m_d1.put(4, 30);
		m_d1.put(5, 31);
		m_d1.put(6, 30);
		m_d1.put(7, 31);
		m_d1.put(8, 31);
		m_d1.put(9, 30);
		m_d1.put(10, 31);
		m_d1.put(11, 30);
		m_d1.put(12, 31);
		
		Map<String,String> m_d=new HashMap<String,String>();
		m_d.put("1","Jan");
		m_d.put("2", "Feb");
		m_d.put("3", "Mar");
		m_d.put("4", "Apr");
		m_d.put("5", "May");
		m_d.put("6", "Jun");
		m_d.put("7", "Jul");
		m_d.put("8", "Aug");
		m_d.put("9", "Sep");
		m_d.put("10", "Oct");
		m_d.put("11", "Nov");
		m_d.put("12", "Dec");
		
      driver.findElement(By.xpath("//label[@for='departure']")).click();
		String actual=m_d.get(mon3);
		System.out.println("actual = "+actual);
     String mon1=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div/text()")).getText();
     System.out.println("mon1 = "+mon1);
		if(mon1.contains(actual)) {
			int total=m_d1.get(mon4);
			
			if(date<=total) {
			driver.findElement(By.xpath("//div[@class='dateInnerCell']/p[text()="+date+"]")).click();
			System.out.println("Date clicked");
		}
			else {
				System.out.println("invalid date");
			}
		}
		driver.quit();
	
	}

}
