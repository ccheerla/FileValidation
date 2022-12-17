package reusableMethods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	 WebDriver driver;
	 Properties properties;
	  final String propertyFilePath= "C:/Users/0212A3744/eclipse-workspace/FileUploadAndDownload/configuration/data.properties";
	
	  String fileExtension = "xlsx";
	   
	 public BaseClass(WebDriver driver){
	        this.driver = driver;
	    }
	 public BaseClass(){
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				properties = new Properties();
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("data.properties not found at " + propertyFilePath);
			}		
		}
	 public String getDriverPath(){
			String driverPath = properties.getProperty("driverPath");
			if(driverPath!= null) return driverPath;
			else throw new RuntimeException("driverPath not specified in the data.properties file.");		
		}
		
		public long getImplicitlyWait() {		
			String implicitlyWait = properties.getProperty("implicitlyWait");
			if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
			else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
		}
		public String  getPathDoc() {
			 String filePath = properties.getProperty("filePath");
				String extension3 = FilenameUtils.getExtension(filePath);
				if(filePath!= null && extension3.equalsIgnoreCase("doc") || extension3.equalsIgnoreCase("docx") ||
						extension3.equalsIgnoreCase("rtf") || extension3.equalsIgnoreCase("txt")
						|| extension3.equalsIgnoreCase("pdf")) return filePath;
				else throw new RuntimeException("Allows only doc,docx,rtf,txt and pdf format files");	
		 }
		public String getApplicationUrl() {
			String url = properties.getProperty("url");
			System.out.println(url);
			if(url != null) return url;
			else throw new RuntimeException("url not specified in the Configuration.properties file.");
		}
		public String getName() {
			String name = properties.getProperty("name");
			//System.out.println(name);
			if(name != null) return name;
			else throw new RuntimeException("url not specified in the Configuration.properties file.");
		}
		public String getPassword() {
			String pwrd = properties.getProperty("pwrd");
			//System.out.println(pwrd);
			if(pwrd != null) return pwrd;
			else throw new RuntimeException("url not specified in the Configuration.properties file.");
		}
		public String getSourcePath(){
			String sourcePath = properties.getProperty("sourcepath");
			String extension1 = FilenameUtils.getExtension(sourcePath);
			if(sourcePath!= null && extension1.equalsIgnoreCase(fileExtension)) 
			return sourcePath;
			else
				throw new RuntimeException("Either file path is empty or file extension is different");
		}
		public String getTargetPath(){
			String targetPath = properties.getProperty("targetpath");
			String extension2 = FilenameUtils.getExtension(targetPath);
			if(targetPath!= null && extension2.equalsIgnoreCase("xlsx")) return targetPath;
			else throw new RuntimeException("Either file path is empty or file extension is different");		
		}
		public String getResultPath(){
			String resultPath = properties.getProperty("resultpath");
			if(resultPath!= null ) return resultPath;
			else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
		}
}
