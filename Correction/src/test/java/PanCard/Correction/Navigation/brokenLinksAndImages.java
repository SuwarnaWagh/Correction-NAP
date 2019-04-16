package PanCard.Correction.Navigation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinksAndImages {

	public static WebDriver driver = null; 
	public static String UrlName = "https://www.flipkart.com/";
	public static String link_response;
	public static String image_response;
	public static HttpURLConnection connection;
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		 	System.setProperty("webdriver.chrome.driver", "I://driver//chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get(UrlName);//load url	  
		  driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();//close the pop up
		  List<WebElement> activeLinks, activeImages;//we are first gathering all the anchor(//a) and image(//img) tags in a List<WebElement> activeLinks, activeImages.
		  activeLinks = driver.findElements(By.xpath("//div[@class='col']//a"));//extract all links (a tag) under the class 'col'
		  
		  System.out.println("******************Number of links :  "+activeLinks.size()+"******************");
		  for (WebElement e: activeLinks) {//verify response of each link(href)
			  
	// HttpURLConnection class is used to  make HTTP requests to the web server hosting the links and see the response returned by the server. Based on the response we can figure out if the link is broken or not.
			  connection = (HttpURLConnection)new URL(e.getAttribute("href")).openConnection();
			  link_response = connection.getResponseMessage();//to check links are working and save the response in link_response
			  System.out.println(e.getAttribute("href") + " : " + link_response);
		  }
		  
		  
		  activeImages = driver.findElements(By.xpath("//div[@class='col']//img"));//extract all links (a tag) under this class 'col'
		  System.out.println("******************Number of images :  "+activeImages.size()+"******************");
		  for (WebElement e: activeImages) {
			  connection = (HttpURLConnection)new URL(e.getAttribute("src")).openConnection();
			  image_response = connection.getResponseMessage();
			  System.out.println(e.getAttribute("src") + " : " + image_response);
		  }
		
		  System.out.println("*********************Verified All images & Links*********************");
	}

}
