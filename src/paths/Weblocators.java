package paths;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Weblocators {
	WebDriver driver ;
//	public void webpage() throws InterruptedException {
//		
//		
//		String loc="wiz-iframe-intent";
//	    String loc2="//div[@class='btn close-button']";
//		   
//		   
//		   //click on ‘Choose file’ to upload the desired file
//		   //Uploading the file using sendKeys
//		   
//		  
//		   driver.findElement(By.xpath("//input[@type='email']")).sendKeys("chandana.cheerla4@gmail.com");
//		   driver.findElement(By.name("Password")).sendKeys("Password@123");
//		   driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("8898556788");
//		
//	}

	 public String getloc1(){
			String loc1 = "wiz-iframe-intent";
			 return loc1;
	 }
	 public String getloc2(){
			String loc2 = "//input[@id='file-upload']";
			 return loc2;
	 }
	 
	 public String  getFullname() {
		 String fullName="//input[@type='email']";
		return fullName;
	 }
	 public String  getPassword() {
		 String password="Password";
		return password;
	 }
}

