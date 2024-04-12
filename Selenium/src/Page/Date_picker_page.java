package Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Date_picker_page {
	
	WebDriver driver;
	public Date_picker_page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By calender_btn=By.name("effectiveDate");
	By back_arrow=By.xpath("//*[@id=\"prel_form_dateOfBirth\"]/div/lib-angular-mydatepicker-calendar/div/div/lib-selection-bar/div/div[1]/button");
	By mnth_btn=By.xpath("//*[@id=\"prel_form_dateOfBirth\"]/div/lib-angular-mydatepicker-calendar/div/div/lib-selection-bar/div/div[2]/button[1]");
	By year_btn=By.xpath("//*[@id=\"prel_form_dateOfBirth\"]/div/lib-angular-mydatepicker-calendar/div/div/lib-selection-bar/div/div[2]/button[2]");
	By mnth_year=By.xpath("//*[@id=\"prel_form_dateOfBirth\"]/div/lib-angular-mydatepicker-calendar/div/div/lib-selection-bar/div/div[2]");
	By frnt_arrow=By.xpath("//*[@id=\"prel_form_dateOfBirth\"]/div/lib-angular-mydatepicker-calendar/div/div/lib-selection-bar/div/div[3]/button");
	
	By year_table=By.xpath("//*[@id=\"prel_form_dateOfBirth\"]/div/lib-angular-mydatepicker-calendar/div/div/lib-selection-bar/div/div[2]/button");
	
	public void calender()
	{
		driver.findElement(calender_btn).click();
	}
	
	public void year(String year)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String act_year=driver.findElement(year_btn).getText();
		if(!act_year.equals(year))
		{
			driver.findElement(year_btn).click();
			while(true)
			{
				String table_year=driver.findElement(year_table).getText();
				String split_year[]=table_year.split(" - ");
				String year1=split_year[0], year2=split_year[1];
				int year_1=Integer.parseInt(year1), year_2=Integer.parseInt(year2), year_=Integer.parseInt(year);
				if(year_>=year_1 && year_<=year_2)
				{
					break;
				}
				else
					driver.findElement(back_arrow).click();
			}
			By calender_year=By.xpath("/html/body/app-root/app-home/app-registration/div[2]/div/div/div[1]/div/div/div/div/form/div[1]/div[6]/div/dp-date-picker/"
					+ "div/lib-angular-mydatepicker-calendar/div/div/lib-year-view/table/tbody/tr/td/span[contains(text(),'"+year+"')]");
			driver.findElement(calender_year).click();
		}
	}
	
	public void month(String month, String day)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		while(true)
		{
			String act_month=driver.findElement(mnth_btn).getText();
			if(act_month.equals(month))
			{
				break;
			}
			else
			{
				driver.findElement(mnth_btn).click();
				By calender_month=By.xpath("/html/body/app-root/app-home/app-registration/div[2]/div/div/div[1]/div/div/div/div/form/div[1]/div[6]/div/dp-date-picker/"
										+ "div/lib-angular-mydatepicker-calendar/div/div/lib-month-view/table/tbody/tr/td/span[2][contains(text(),'"+month+"')]");
				driver.findElement(calender_month).click();
			}
		}
		By calender_day=By.xpath("/html/body/app-root/app-home/app-registration/div[2]/div/div/div[1]/div/div/div/div/form/div[1]/div[6]/div/dp-date-picker/"
									+ "div/lib-angular-mydatepicker-calendar/div/div/lib-day-view/table/tbody/tr/td/span[contains(text(),'"+day+"')]");
		int links=driver.findElements(calender_day).size();
		WebElement daysel = null;
		for(int i=0;i<links;i++)
		{
			List<WebElement>selday=driver.findElements(calender_day);
			daysel=selday.get(i);
			String day_cont=daysel.getText();
			if(day_cont.equals(day))
				break;
		}
		daysel.click();
	}

}
