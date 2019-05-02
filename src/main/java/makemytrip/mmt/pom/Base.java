package makemytrip.mmt.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.mmt.util.Waits;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
public Base() throws IOException{
	prop=new Properties();
	FileInputStream file= new FileInputStream("C:\\Windows.old.001\\Users\\Ajay\\java_interviewconcepts\\mmt.pom\\Datas.Properties");
	prop.load(file);
	}
public static void Initial() {
	if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		 if(prop.getProperty("btype").equalsIgnoreCase("incognito")) {
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("--incognito");
			 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			 driver=new ChromeDriver(capabilities);
		 }
		 else {
			 driver=new ChromeDriver();
		 }
	}
	else if(prop.getProperty("browser").equalsIgnoreCase("ff")) {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		
	}
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(Waits.implicit_Wait, TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(Waits.pageload_time, TimeUnit.SECONDS);
	 driver.get(prop.getProperty("url"));
	 

}
}



