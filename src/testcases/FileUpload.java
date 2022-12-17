package testcases;

import reusableMethods.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import paths.Weblocators;

@Test
public class FileUpload {	
	WebDriver driver;
	BaseClass baseClass;
	Weblocators webLocators;
	
	@BeforeMethod
	public void setUp() throws Exception {
		this.driver = driver;
		baseClass= new BaseClass();
		System.setProperty("webdriver.chrome.driver", baseClass.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseClass.getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,380)");
		Thread.sleep(3000);
	}
	
	@Test
	public void testCase1() throws InterruptedException {
		
		webLocators = new Weblocators();
		baseClass= new BaseClass();
		WebElement browse = driver.findElement(By.xpath(webLocators.getloc2()));
		browse.sendKeys(baseClass.getPathDoc());
		System.out.println("File is Uploaded Successfully");
		 driver.findElement(By.xpath(webLocators.getFullname())).sendKeys(baseClass.getName());
		 driver.findElement(By.name(webLocators.getPassword())).sendKeys(baseClass.getPassword());
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,-380)");
			 Thread.sleep(3000);
	}
   @AfterMethod
   public void closeBrowser() {
	   driver.close();
   }
}
