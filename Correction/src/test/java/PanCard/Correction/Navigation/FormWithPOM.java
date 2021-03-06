package PanCard.Correction.Navigation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PanCard.Correction.POM;

public class FormWithPOM {
	
	POM p1 ; 
	WebDriver driver;
	List<WebElement> correctionLink;
	WebElement dropDown,dateDropDown,monthDropDown,stateDropDown,ISDDropDown,cpDropDown,CountryPOIDropDown,CountryPOADropDown,CountryPOBDropDown,proofPanDropDown;
	Select s,s1,s2,s3,s4,s5,s6,s7,s8,s9;
	
  @Test
  public void usingPOM() {
	  driver.get("https://tin.tin.nsdl.com/pan/changerequest.html");
	  p1.correctionaLink(driver);
	  
	  JavascriptExecutor jse = ((JavascriptExecutor)driver);
	  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	 
	  
	  dropDown = p1.panApplicantStatus(driver);//panApplicantStatus
	 
	  s = new Select(dropDown) ;
	  s.selectByVisibleText("Individual");
	  driver.findElement(By.xpath("//input[@type='submit']")).submit();
	  
	  driver.findElement(By.id("PAN_CTZN_FLG_YES")).click();//isApplicantIndian
	  driver.findElement(By.name("PAN_NUM")).sendKeys("ACJPW3037E");//
	  driver.findElement(By.xpath("//input[@name='PAN_MN_TITL'][@value='3']")).click();
	  driver.findElement(By.name("PAN_LST_MN_NM")).sendKeys("WAGH");//PAN_LST_MN_NM
	  driver.findElement(By.name("PAN_FST_MN_NM")).sendKeys("SUWARNA");//PAN_FST_MN_NM
	  driver.findElement(By.name("PAN_MDL_MN_NM")).sendKeys("MARUTI");//PAN_MDL_MN_NM
	  driver.findElement(By.name("PAN_LST_FTHR_NM")).sendKeys("WAGH");//PAN_LST_FTHR_NM
	  driver.findElement(By.name("PAN_FST_FTHR_NM")).sendKeys("MARUTI");//PAN_FST_FTHR_NM
	  driver.findElement(By.name("PAN_MDL_FTHR_NM")).sendKeys("KASHINATH");//PAN_MDL_FTHR_NM
	  
	  dateDropDown = driver.findElement(By.name("PAN_DT_BRTH_DD"));//dateOfBirth
	  s1 = new Select(dateDropDown) ;
	  s1.selectByValue("30");
	  
	  monthDropDown = driver.findElement(By.name("PAN_DT_BRTH_MM"));//monthOfBirth
	  s2 = new Select(monthDropDown) ;
	  s2.selectByValue("06");
	 	
	  driver.findElement(By.name("PAN_DT_BRTH_YYYY")).sendKeys("1991");
	  driver.findElement(By.xpath("//input[@name='PAN_SEX'][@value='F']")).click();
	  driver.findElement(By.xpath("//input[@name='PAN_CMNC_ADDR_FLG'][@value='R']")).click();
	  driver.findElement(By.name("PAN_RO1_ADDR1")).sendKeys("OM HEIGHTS,B-403");
	  driver.findElement(By.name("PAN_RO1_ADDR2")).sendKeys("FURSUNGIGAON ROAD");
	  driver.findElement(By.name("PAN_RO1_ADDR3")).sendKeys("NEAR PMT BUS STOP");
	  driver.findElement(By.name("PAN_RO1_ADDR4")).sendKeys("FURSUNGI");
	  driver.findElement(By.name("PAN_RO1_ADDR5")).sendKeys("PUNE");
	  
	  stateDropDown = driver.findElement(By.name("PAN_RO1_STATE"));//state
	  s3 = new Select(stateDropDown) ;
	  s3.selectByValue("19");
	  
	  driver.findElement(By.name("PAN_RO1_PIN")).sendKeys("412308");
	  
	  ISDDropDown = driver.findElement(By.name("PAN_TEL_CC"));//ISDCode
	  s4 = new Select(ISDDropDown) ;
	  s4.selectByValue("91");
	  
	  driver.findElement(By.id("panmobnum")).click();
	  driver.findElement(By.id("pantelnum2")).sendKeys("8149131461");
	  driver.findElement(By.name("PAN_EMAIL")).sendKeys("SUWARNASAPRE@GMAIL.COM");
	  driver.findElement(By.id("PAN_UID_FLG_A")).click();
	  driver.findElement(By.id("PAN_AADHAR_NUM")).sendKeys("727973505197");
	  driver.findElement(By.id("PAN_ADH_MN_NM")).sendKeys("SUWARNA MARUTI WAGH");
	  driver.findElement(By.name("PAN_VERIFY_NAME")).sendKeys("SUWARNA MARUTI WAGH");
	  
	  cpDropDown = driver.findElement(By.name("PAN_TEL_CC"));//telephone
	  s5 = new Select(cpDropDown) ;
	  s5.selectByValue("91");
	  
	  driver.findElement(By.name("PAN_NOCOPY")).sendKeys("2");
	  driver.findElement(By.name("PAN_PLACE")).sendKeys("PUNE");
	  
	  CountryPOIDropDown = p1.proofOfIdentity(driver);//proofOfIdentity,proofOfAddress,proofOfBirth
	  s6 = new Select(CountryPOIDropDown) ;
	  s6.selectByValue("9");
	  
	  CountryPOADropDown = p1.proofOfAddress(driver);//proofOfAddress
	  s7 = new Select(CountryPOADropDown) ;
	  s7.selectByValue("8");
	  
	  CountryPOBDropDown = p1.proofOfBirth(driver);//proofOfBirth
	  s8 = new Select(CountryPOBDropDown) ;
	  s8.selectByValue("0010");
	  
	  proofPanDropDown = driver.findElement(By.name("PAN_PRF_PAN"));//proofOfPan
	  s9 = new Select(proofPanDropDown) ;
	  s9.selectByValue("1");
  }
  @BeforeTest
  public void beforeTest() {
	  p1 = new POM();
	  driver = p1.callChromedriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}
