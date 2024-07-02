
package mavenb;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class mavenc {
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

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@routerlink='/admin/PricingQuote/pricing-quotes']//div[@class='menuTitle']"))
				.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@class='btn btn-success pull-right']")).click();
	}

	@Test(priority = 2, description = "select Company Step")
	public void selectcompany() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='c-btn']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[normalize-space()='Ace Infoway Pvt. Ltd.']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space()='Next']")).click();

	}

	@Test(priority = 3, description = "Company Profile Step")
	public void companyprofilestep() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='quoteName']")).sendKeys("Automation Test");

		driver.findElement(By.xpath("//input[@formcontrolname='quotePreparedBy']"))
				.sendKeys("Automation Script Vishal");

		// Exhibit name

		driver.findElement(By.xpath("//input[@formcontrolname=\"exhibit\"]")).sendKeys("is the Exhibit name.");

		Thread.sleep(1000);

		// click on the point of contact drop down

		driver.findElement(By.xpath("(//div[@ng-reflect-klass=\"c-btn\"])[3]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"/html/body/app-root/app-admin-layout/body/div/div/section/app-admin-compnay-profile-information/div[1]/div/div/form/div/div[2]/div/div/div/div[9]/div[2]/angular2-multiselect/div/div[2]/div[3]/div[4]/ul/li[3]/label"))
				.click();

		// user name
		// driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("Ramore");
		// // Change

		// First and last names
		// driver.findElement(By.xpath("//input[@formcontrolname=\"firstName\"]")).sendKeys("Drake");
		// driver.findElement(By.xpath("//input[@formcontrolname=\"lastName\"]")).sendKeys("Ramoray");

		// Email
		// driver.findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys("drakeramoray2@mailinator.com");

		// title
		// driver.findElement(By.xpath("//input[@name=\"title\"]")).sendKeys("Mr");

		Thread.sleep(1000);
		// Next button
		driver.findElement(By.id("btnNext")).click();

	}

	@Test(priority = 4, description = "Additional Company Question Step")
	public void additionalcompanyquestionstep() throws InterruptedException {

		Thread.sleep(2000);
		// click on ETC Type
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[12]")).click();

		// select ETC Dropdown
		driver.findElement(By.xpath("(//div[@class=\"c-btn\"])[4]")).click();
		// Select ETC Type
		driver.findElement(By.xpath("(//li[@ng-reflect-klass=\"pure-checkbox\"])[8]")).click();

		// check on Market Entry
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[19]")).click();

		// click on Market Entry Selector
		driver.findElement(By.xpath("//*[@id=\"MarketEntryTypes\"]/angular2-multiselect/div/div[1]/div")).click();

		// select Voip from the list
		driver.findElement(
				By.xpath("//*[@id=\"MarketEntryTypes\"]/angular2-multiselect/div/div[2]/div[3]/div/ul/li[3]/label"))
				.click();

		// Advisory service check
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[20]")).click();

		// Solutions Check
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[21]")).click();

		// Regulatory Check
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[15]")).click();

		Thread.sleep(2000); // Next Button
		driver.findElement(By.id("btnNext")).click();

	}

	@Test(priority = 5, description = "State selection Step")
	public void stateselection() throws InterruptedException {

		Thread.sleep(2000);

		// CLEC Reg. and Active Select

		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]")).click();

		// ETC
		// driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[3]")).click();

		// Other
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[4]")).click();

		// Market Entry
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[5]")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("btnNext")).click();

	}

	@Test(priority = 6, description = " Notes step")
	public void Notesstep() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"divExibitB\"]/table/thead/tr/th[2]/input[2]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@name='notes']"))
				.sendKeys("This note is inserted in the Notes field by Automation.");

		// Rate
		Thread.sleep(1000);
		driver.findElement(By.id("btnNext")).click();

		// Quote
		Thread.sleep(2000);
		driver.findElement(By.id("btnNext")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("btnNext")).click();

		// Add on
		// TRFA Matrix, TRFA 911 Rates, Voip Pro select check box
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[3]")).click();

		// Other Regulatory Requirement (FCC Form 477 - Voice with Broadband, FCC Form
		// 477 - Voice Only, CPNI, CALEA)
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[9]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[10]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[14]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[15]")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("btnNext")).click();

		// Compliance step
		Thread.sleep(2000);

		// Selecting different MISCELLANEOUS FEEs using checkbox

		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[3]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[4]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[5]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[6]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[7]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[8]")).click();

		Thread.sleep(1000);
		// Add notes
		driver.findElement(By.xpath("(//textarea[@cols=\"100\"])[13]"))
				.sendKeys("This note is added by Automation script");

		Thread.sleep(1000);
		driver.findElement(By.id("btnNext")).click();
	}

	@Test(priority = 7, description = "Proposal Step")
	public void proposalstep() throws InterruptedException {

		Thread.sleep(3000);
		// Final Quote Download
		driver.findElement(By.xpath("(//i[@aria-hidden='true'])[1]")).click();

		Thread.sleep(10000);
		// Final Market Entry Quote Download
		driver.findElement(By.xpath("(//i[@aria-hidden=\"true\"])[2]")).click();

		Thread.sleep(10000);
		// FINAL Advisory Services Quote Download
		driver.findElement(By.xpath("(//i[@aria-hidden=\"true\"])[3]")).click();

		Thread.sleep(10000);
		// FINAL Solutions Quote Download
		driver.findElement(By.xpath("(//i[@aria-hidden=\"true\"])[4]")).click();

		// Save button
		Thread.sleep(8000);
		driver.findElement(By.id("btnNext")).click();

	}

	@Test(priority = 8, description = "Front Page after the Quote is saved")
	public void frontpage_end() throws InterruptedException {
		// Thread.sleep(8000);

		// click on Mark as Sent

		driver.findElement(By.xpath("(//span[@title=\"Click to mark as Sent\"])[1]")).click();

		Thread.sleep(2000);
		// Select 'Yes' from the Pop up
		driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[2]")).click();

		Thread.sleep(2000);

		// click on Quote Status Toggle
		driver.findElement(By.xpath("(//a[@title=\"Click to change Quote status\"])[1]")).click();

		Thread.sleep(2000);
		// click on the drop down
		driver.findElement(By.xpath("//div[@class=\"c-btn\"]")).click();

		Thread.sleep(2000);
		// select Approved
		driver.findElement(By.xpath("(//li[@ng-reflect-klass=\"pure-checkbox\"])[2]")).click();

		Thread.sleep(2000);
		// select 'Yes' in the popup
		driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[4]")).click();

		Thread.sleep(2000);
		// click on MSA Status

		driver.findElement(By.xpath("(//a[@title=\"Click to change MSA status\"])[1]")).click();

		Thread.sleep(2000);

		// Select the drop down
		driver.findElement(By.xpath("(//span[@class=\"ng-star-inserted\"])[3]")).click();

		Thread.sleep(2000);

		// select Signed from the drop down
		driver.findElement(By.xpath("(//li[@class=\"pure-checkbox ng-star-inserted\"])[5]")).click();

		Thread.sleep(2000);
		// select 'Yes' from the drop down
		driver.findElement(By.xpath("(//button[@type=\"button\"])[16]")).click();

		Thread.sleep(2000);
		// Display Quote
		driver.findElement(By.xpath("(//span[@title=\"Click to mark as Display\"])[1]")).click();

		Thread.sleep(2000);
		// click 'Yes' in the pop up
		driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[3]")).click();

		Thread.sleep(2000);

		// Export Onboarding
		driver.findElement(By.xpath("(//i[@class=\"fa fa-download\"])[1]")).click();

		// Duplicate the Quote
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class=\"fa fa-clone\"])[1]")).click();

		// Press 'Yes' button
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[6]")).click();

        //click on price quote tab
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=\"Price Quote \"]")).click();

		//click on price quote sub module
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@class=\"onlyHover\"])[3]")).click();

	}

	// @AfterSuite
	// public void tearDown() throws InterruptedException {
	// Thread.sleep(5000);
	// Close the browser after all tests are done
	// driver.quit();
//	}
}
