package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page.Date_picker_page;

public class Date_picker_test {
	
	WebDriver driver;
	
	@BeforeTest
	public void Setup()
	{
		driver=new EdgeDriver();
	}
	
	@BeforeMethod
	public void Start()
	{
		driver.get("https://www.rrbapply.gov.in/#/auth/home?flag=true");
		driver.manage().window().maximize();
	}
	
	@Test
	public void Run()
	{
		Date_picker_page dpp=new Date_picker_page(driver);
		driver.findElement(By.xpath("/html/body/app-root/app-home/app-registration/div[6]/div/div[3]/button")).click();
		dpp.calender();
		dpp.year("2004");
		dpp.month("Nov", "17");
	}
	
	@AfterMethod
	public void Finish()
	{
		System.out.println("Test Complete");
	}
	
	@AfterTest
	public void quit()
	{
		driver.quit();
	}

}
