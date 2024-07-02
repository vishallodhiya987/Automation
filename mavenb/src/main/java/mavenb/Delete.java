package mavenb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Delete {

	WebDriver driver;
	
	@BeforeSuite
	public void setup()
	{
		
				
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
				
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test(priority = 1, description = "Log in to the website")
	public void logIn() throws InterruptedException
	{
		
		//get URL
		driver.get("https://staging.inteserra360.com/#/admin");
		
		Thread.sleep(3000);
		//Enter Username
		driver.findElement(By.id("username")).sendKeys("admin");

		//Enter Password
		driver.findElement(By.id("password")).sendKeys("Int@dmin");
		
		//Press sign in 
		driver.findElement(By.xpath("//button[text()=\"Sign In\"]")).click();
		
		
	}
	
	@Test(priority =2, description = "Price Quote module")
	public void priceQuote() throws InterruptedException
	{
		Thread.sleep(2000);
		//click on Price quote module
		driver.findElement(By.xpath("//a[text()=\"Price Quote \"]")).click();
		
		Thread.sleep(2000);
		//click on price quotes
		driver.findElement(By.xpath("(//div[@class=\"menuTitle\"])[3]")).click();
		
		
	}
	
	@Test(priority = 3, description ="Delete 5 records")
	public void delete() throws InterruptedException
	{
		Thread.sleep(1000);
		for(int i=0; i<5; i++)
		{
		Thread.sleep(1000);
		//click on delete button of the second record
		driver.findElement(By.xpath("(//i[@class=\"fa fa-trash-o\"])[2]")).click();
		
		Thread.sleep(1000);
		//click on 'Yes"
		driver.findElement(By.xpath("(//button[text()=\"Yes\"])[1]")).click();
		
		Thread.sleep(1000);
		}
		
	}
	
	
	
}
