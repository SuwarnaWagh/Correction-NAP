package PanCard.Correction;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ObjectRepository {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Suwarna\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.get("http://newtours.demoaut.com/");
    	List<WebElement> links = driver.findElements(By.className("mouseOut"));
    	links.size();
    	for (int i =0 ; i < links.size() ; i++){
    		String compareString = links.get(i).getText();
    		if(compareString.equals("REGISTER")){
    			links.get(i).click();
    			break;
    		}
    	}
    	
    	driver.findElement(By.name("firstName")).sendKeys("bas");
    	driver.findElement(By.name("lastName")).sendKeys("bas");
    	driver.findElement(By.name("phone")).sendKeys("sa");
    	driver.findElement(By.id("userName")).sendKeys("s");
    	driver.findElement(By.name("address1")).sendKeys("s");
    	driver.findElement(By.name("address2")).sendKeys("s");
    	driver.findElement(By.name("city")).sendKeys("s");
    	driver.findElement(By.name("state")).sendKeys("s");
    	driver.findElement(By.name("postalCode")).sendKeys("s");
    	WebElement CountryName = driver.findElement(By.name("country"));
    	Select s = new Select(CountryName);
    	s.selectByVisibleText("INDIA");
    	driver.findElement(By.id("email")).sendKeys("baaaa1");
    	driver.findElement(By.name("password")).sendKeys("baaaaaa1");
    	driver.findElement(By.name("confirmPassword")).sendKeys("baaaaaa1");
    	driver.findElement(By.name("register")).click();
    	//td/p/a/font/b Note: Your user name is
    	
    	if(driver.findElement(By.xpath("//td/p/a/font/b")).getText().contains("Note: Your user name is")){
    		System.out.println("User registration completed successfully");
    	}
    	driver.findElement(By.xpath("//td/p/font/a[01]")).click();
    	
    	driver.findElement(By.name("userName")).sendKeys("baaaa1");
    	driver.findElement(By.name("password")).sendKeys("baaaaaa1");
    	driver.findElement(By.name("login")).click();
    	Thread.sleep(5000);
    	System.out.println(driver.getTitle());
    	assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
	}	
}
