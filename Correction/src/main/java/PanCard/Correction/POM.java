package PanCard.Correction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class POM {
	
	public static final String driverName = "webdriver.chrome.driver";
	public static final String driverPath = "I://driver//chromedriver.exe";
	WebDriver driver = null; 
	
	public WebDriver callChromedriver() {
		 System.setProperty(driverName,driverPath);
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  return driver;
	}
	
	  
	
	public WebElement panApplicantStatus(WebDriver driver) {
		return driver.findElement(By.xpath("//select[@name='PAN_APPLCNT_STATUS']"));
	}
	
	public void correctionaLink(WebDriver driver) {
		
		List<WebElement> correctionLink = driver.findElements(By.xpath("//*[@id='main-container']//a"));
		correctionLink.get(0).click();
	}
	//proofOfIdentity,proofOfAddress,proofOfBirth
	public WebElement proofOfIdentity(WebDriver driver) {
		return driver.findElement(By.id("selectAccordingToCountryPOI"));
	}
	public WebElement proofOfAddress(WebDriver driver) {
		return driver.findElement(By.id("selectAccordingToCountryPOA"));
	}
	public WebElement proofOfBirth(WebDriver driver) {
		return driver.findElement(By.id("selectAccordingToCountryPOB"));
	}

	
}