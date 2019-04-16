package PanCard.Correction.Navigation;

import org.testng.annotations.Test;

import PanCard.Correction.POM;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class FillData_DataDrivenFramework {
	POM p1;
	WebDriver driver;
	List<WebElement> correctionLink;
	WebElement dropDown,dateDropDown,monthDropDown,stateDropDown,ISDDropDown,cpDropDown,CountryPOIDropDown,CountryPOADropDown,CountryPOBDropDown,proofPanDropDown;
	Select s,s1,s2,s3,s4,s5,s6,s7,s8,s9;
	String filepath = "C://Users//Admin//Desktop//TestData.xlsx";
	FileInputStream fis ;
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	 XSSFRow row;
  @Test
  public void DataDriven() {
	  
	  sheet = workbook.getSheet("Sheet1");
	 
	  
	  driver.get("https://tin.tin.nsdl.com/pan/changerequest.html");
	  p1.correctionaLink(driver);
	  
	  JavascriptExecutor jse = ((JavascriptExecutor)driver);
	  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	 
	  
	  dropDown = p1.panApplicantStatus(driver);//panApplicantStatus
	 
	  s = new Select(dropDown) ;
	  s.selectByVisibleText("Individual");
	  driver.findElement(By.xpath("//input[@type='submit']")).submit();
	  
	  driver.findElement(By.id("PAN_CTZN_FLG_YES")).click();//isApplicantIndian
	  driver.findElement(By.name("PAN_NUM")).sendKeys(sheet.getRow(1).getCell(0).toString());//
	  driver.findElement(By.xpath("//input[@name='PAN_MN_TITL'][@value='3']")).click();
	  driver.findElement(By.name("PAN_LST_MN_NM")).sendKeys(sheet.getRow(1).getCell(1).toString());//PAN_LST_MN_NM
	  driver.findElement(By.name("PAN_FST_MN_NM")).sendKeys(sheet.getRow(1).getCell(2).toString());//PAN_FST_MN_NM
	  driver.findElement(By.name("PAN_MDL_MN_NM")).sendKeys(sheet.getRow(1).getCell(3).toString());//PAN_MDL_MN_NM
	  driver.findElement(By.name("PAN_LST_FTHR_NM")).sendKeys(sheet.getRow(1).getCell(4).toString());//PAN_LST_FTHR_NM
	  driver.findElement(By.name("PAN_FST_FTHR_NM")).sendKeys(sheet.getRow(1).getCell(5).toString());//PAN_FST_FTHR_NM
	  driver.findElement(By.name("PAN_MDL_FTHR_NM")).sendKeys(sheet.getRow(1).getCell(6).toString());//PAN_MDL_FTHR_NM
	  
	  dateDropDown = driver.findElement(By.name("PAN_DT_BRTH_DD"));//dateOfBirth
	  s1 = new Select(dateDropDown) ;
	  s1.selectByValue("30");
	  
	  monthDropDown = driver.findElement(By.name("PAN_DT_BRTH_MM"));//monthOfBirth
	  s2 = new Select(monthDropDown) ;
	  s2.selectByValue("06");
	 	
	  driver.findElement(By.name("PAN_DT_BRTH_YYYY")).sendKeys(sheet.getRow(1).getCell(7).toString());
	  driver.findElement(By.xpath("//input[@name='PAN_SEX'][@value='F']")).click();
	  driver.findElement(By.xpath("//input[@name='PAN_CMNC_ADDR_FLG'][@value='R']")).click();
	  driver.findElement(By.name("PAN_RO1_ADDR1")).sendKeys(sheet.getRow(1).getCell(8).toString());
	  driver.findElement(By.name("PAN_RO1_ADDR2")).sendKeys(sheet.getRow(1).getCell(9).toString());
	  driver.findElement(By.name("PAN_RO1_ADDR3")).sendKeys(sheet.getRow(1).getCell(10).toString());
	  driver.findElement(By.name("PAN_RO1_ADDR4")).sendKeys(sheet.getRow(1).getCell(11).toString());
	  driver.findElement(By.name("PAN_RO1_ADDR5")).sendKeys(sheet.getRow(1).getCell(12).toString());
	  
	  stateDropDown = driver.findElement(By.name("PAN_RO1_STATE"));//state
	  s3 = new Select(stateDropDown) ;
	  s3.selectByValue("19");
	  
	  driver.findElement(By.name("PAN_RO1_PIN")).sendKeys(sheet.getRow(1).getCell(13).toString());
	  
	  ISDDropDown = driver.findElement(By.name("PAN_TEL_CC"));//ISDCode
	  s4 = new Select(ISDDropDown) ;
	  s4.selectByValue("91");
	  
	  driver.findElement(By.id("panmobnum")).click();
	  driver.findElement(By.id("pantelnum2")).sendKeys(sheet.getRow(1).getCell(14).toString());
	  driver.findElement(By.name("PAN_EMAIL")).sendKeys(sheet.getRow(1).getCell(15).toString());
	  driver.findElement(By.id("PAN_UID_FLG_A")).click();
	  driver.findElement(By.id("PAN_AADHAR_NUM")).sendKeys(sheet.getRow(1).getCell(16).toString());
	  driver.findElement(By.id("PAN_ADH_MN_NM")).sendKeys(sheet.getRow(1).getCell(17).toString());
	  driver.findElement(By.name("PAN_VERIFY_NAME")).sendKeys(sheet.getRow(1).getCell(18).toString());
	  
	  cpDropDown = driver.findElement(By.name("PAN_TEL_CC"));//telephone
	  s5 = new Select(cpDropDown) ;
	  s5.selectByValue("91");
	  
	  driver.findElement(By.name("PAN_NOCOPY")).sendKeys(sheet.getRow(1).getCell(19).toString());
	  driver.findElement(By.name("PAN_PLACE")).sendKeys(sheet.getRow(1).getCell(20).toString());
	  
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
  public void beforeTest() throws FileNotFoundException,IOException {
	  
	  p1 = new POM();
	  driver = p1.callChromedriver();
	 
	  fis = new FileInputStream(filepath);
	  workbook = new XSSFWorkbook(fis);
}

  @AfterTest
  public void afterTest() {
  }

}
