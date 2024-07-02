package mavenb;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PriceQuoteSub {
	WebDriver driver; // Declare WebDriver instance

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setup() throws InterruptedException {

		// Initializing ChromeDriver
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://staging.inteserra360.com/#/admin/login");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 1, description = "login with valid credentials scenarios")
	public void loginWithRightCredentials() throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys("admin");

		driver.findElement(By.id("password")).sendKeys("Int@dmin");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);
		// driver.findElement(By.xpath("//a[text()='Price Quote ']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Price Quote']")).click();

		// Click on Base rate module
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//div[@class=\"menuTitle\"])[2]")).click();

		// Click on Add button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class=\"btn btn-success pull-right\"]")).click();

		// add base rate name
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@ng-reflect-name=\"baseRate\"]")).sendKeys("Automation Test Base Rate");

		// drop down for Rate type

		driver.findElement(By.xpath("//div[@ng-reflect-klass=\"c-btn\"]")).click();
		Thread.sleep(1000);

		//select Automation test base rate
		Thread.sleep(1000);
        driver.findElement(By.xpath("//label[text()='Automation Test Base Rate']")).click();

        //monthly rate
        driver.findElement(By.xpath("//input[@formcontrolname=\"monthlyRate\"]")).sendKeys("10");
        
        //Annual rate
        driver.findElement(By.xpath("//input[@formcontrolname=\"annualRate\"]")).sendKeys("50");
        
        //Sort order
        driver.findElement(By.xpath("//input[@formcontrolname=\"sortOrder\"]")).sendKeys("0");

		// click on Save button
		Thread.sleep(1000);
		driver.findElement(By.id("btnSave")).click();

	}
	
	@Test(priority = 2, description = "Edit Base rate")
	public void EditBaseRate() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class=\"fa fa-edit\"])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@ng-reflect-name=\"baseRate\"]")).clear();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@ng-reflect-name=\"baseRate\"]")).sendKeys("Automation Test Base Rate (Updated)");
		
		// Update drop down for Rate type

				driver.findElement(By.xpath("//div[@ng-reflect-klass=\"c-btn\"]")).click();
				Thread.sleep(1000);

				//change base rate
				Thread.sleep(1000);
		        driver.findElement(By.xpath("//label[text()='Base Rate']")).click();

		        //Update monthly rate
		        driver.findElement(By.xpath("//input[@formcontrolname=\"monthlyRate\"]")).clear();
		        driver.findElement(By.xpath("//input[@formcontrolname=\"monthlyRate\"]")).sendKeys("15");
		        
		        //Update Annual rate
		        driver.findElement(By.xpath("//input[@formcontrolname=\"annualRate\"]")).clear();
		        driver.findElement(By.xpath("//input[@formcontrolname=\"annualRate\"]")).sendKeys("100");
		        
		        //Sort order
		        driver.findElement(By.xpath("//input[@formcontrolname=\"sortOrder\"]")).clear();
		        driver.findElement(By.xpath("//input[@formcontrolname=\"sortOrder\"]")).sendKeys("0");

				// click on Save button
				Thread.sleep(1000);
				driver.findElement(By.id("btnSave")).click();

	}
	
	
}