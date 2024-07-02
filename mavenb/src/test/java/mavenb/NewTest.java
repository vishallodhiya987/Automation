package mavenb;

import org.testng.annotations.Test;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import java.io.File;

public class NewTest {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://staginghandbookbuilder2.blr.com/adminpanel/login.aspx");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 1, description = "log in to the website")
	public void login() throws InterruptedException {

		Thread.sleep(2000);
		// enter the username
		driver.findElement(By.id("Content1_txtUserName")).sendKeys("adminace");

		// enter the password
		driver.findElement(By.id("Content1_txtPassword")).sendKeys("adminace");

		// log in click
		driver.findElement(By.id("Content1_btnLogin")).click();

	}

	@Test(priority = 2, description = "PEO User Creation")
	public void usercreation() throws InterruptedException {

		Thread.sleep(3000);

		// click on PEO user
		driver.findElement(By.linkText("PEO User")).click();

		// search test
		Thread.sleep(1000);
		driver.findElement(By.id("Content1_txtCompanyName")).sendKeys("Test");

		// click on search
		driver.findElement(By.id("Content1_btnSearch")).click();

		Thread.sleep(1000);
		// click on Second page number
		driver.findElement(By.linkText("2")).click();

		Thread.sleep(1000);
		// click on to log in to Test user
		driver.findElement(By.xpath("(//a[@target=\"_blank\"])[8]")).click();

		// switch to new tab
		// Store the current window handle
		String originalWindow = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {
			if (!handle.equals(originalWindow)) {
				// Switch to the new window
				driver.switchTo().window(handle);

				// Close the original window
				driver.switchTo().window(originalWindow).close();

				// Switch back to the new window
				driver.switchTo().window(handle);
				break;
			}
		}

		Thread.sleep(4000);
		// click on set up a new handbook
		driver.findElement(By.xpath("//a[@id=\"Content1_hrefSetup\"]")).click();

		Thread.sleep(2000);
		// click on the states "NewYork"
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[28]")).click();

		// click on next
		driver.findElement(By.id("Content1_divSubUserCreateForm_btnCheckout")).click();
	}

	@Test(priority = 3, description = "The form")
	public void theform() throws InterruptedException, IOException {
		Thread.sleep(2000);

		// Enter first name
		driver.findElement(By.id("Content1_divSubUserRegistration_txtFirstName")).sendKeys("Ada1m7848");  //Change First name Manually

		// Enter last name
		driver.findElement(By.id("Content1_divSubUserRegistration_txtLastName")).sendKeys("Smith98741151");  //Change Last name Manually

		// Enter city
		driver.findElement(By.id("Content1_divSubUserRegistration_txtCity")).sendKeys("New York");

		// enter pin code

		driver.findElement(By.id("Content1_divSubUserRegistration_txtZipcode")).sendKeys("841241");

		// Enter username
		driver.findElement(By.id("Content1_divSubUserRegistration_txtUserId")).sendKeys("USerq121212we");     //change user name manually

		// Password
		driver.findElement(By.id("Content1_divSubUserRegistration_txtpassword")).sendKeys("123456");

		// reenter passwoerd
		driver.findElement(By.id("Content1_divSubUserRegistration_txtConfirmPassword")).sendKeys("123456");

		// click on create
		driver.findElement(By.id("Content1_divSubUserRegistration_btnpurchase")).click();

		Thread.sleep(3000);
		// click on log in and create handbook
		driver.findElement(By.linkText("LOGIN & CREATE HANDBOOK")).click();

	}



	

	@Test(priority = 4, description = "Start Handbook")
	public void starthandbook() throws InterruptedException {
		Thread.sleep(4000);

		// Store the current window handle
		String originalWindow = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {
			if (!handle.equals(originalWindow)) {
				// Switch to the new window
				driver.switchTo().window(handle);

				// Close the original window
				driver.switchTo().window(originalWindow).close();

				// Switch back to the new window
				driver.switchTo().window(handle);
				break;
			}
		}
		Thread.sleep(4000);
		driver.findElement(By.id("Content1_btnhandbook")).click();

	}

	@Test(priority = 5, description = "Quoestionaire")
	public void Quostionaire() throws InterruptedException {
		Thread.sleep(2000);

		// click on the drop down 'Font'
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_0")).click();

		Thread.sleep(1000);
		// Select Arial
		driver.findElement(By.xpath("//option[@value=\"Arial\"]")).click();

		// click outside
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_0")).click();

		// Second Drop down
		Thread.sleep(2000);
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_1")).click();

		Thread.sleep(2000);
		// Standard from the drop down
		driver.findElement(By.xpath("//option[@value=\"Standard\"]")).click();

		// click outside
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_1")).click();

		// Third drop down
		Thread.sleep(2000);
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_2")).click();

		// Justify from the dropdown
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value=\"Justify\"]")).click();

		// Save Button click
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title=\"Save\"]")).click();

		// Selection title Set up

		// font
		Thread.sleep(2000);
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_0")).click();

		driver.findElement(By.xpath("//Option[@value=\"Verdana\"]")).click();

		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_0")).click();

		// select second drop down

		Thread.sleep(2000);
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_1")).click();

		driver.findElement(By.xpath("//option[@value=\"Standard\"]")).click();

		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_1")).click();

		// Select the letters/case
		Thread.sleep(2000);
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_4")).click();

		driver.findElement(By.xpath("//option[@value=\"Default - As in the system\"]")).click();

		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_4")).click();

		// Save Button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title=\"Save\"]")).click();

		// Policy Title - Setup

		Thread.sleep(2000);
		//
		// First Drop down
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_0")).click();

		driver.findElement(By.xpath("//option[@value=\"Tahoma\"]")).click();

		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_0")).click();

		// second drop down
		Thread.sleep(2000);
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_1")).click();

		driver.findElement(By.xpath("//option[@value=\"Larger\"]")).click();

		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_1")).click();

		// Third Drop down

		Thread.sleep(2000);
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_4")).click();

		driver.findElement(By.xpath("//option[@value=\"Default - As in the system\"]")).click();

		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_1")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title=\"Save\"]")).click();

		// enter Company name

		Thread.sleep(2000);
		driver.findElement(By.id("Content1_MainRepeater_txtCustom_0")).sendKeys("TEst one 123"); // Change

		// Save button
		driver.findElement(By.xpath("//img[@title=\"Save\"]")).click();

		// Title Page

		// check
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type=\"radio\"])[2]")).click();

		// check
		driver.findElement(By.xpath("(//input[@type=\"radio\"])[3]")).click();

		// drop down
		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_3")).click();

		driver.findElement(By.xpath("//option[@value=\"MM/DD/YYYY\"]")).click();

		driver.findElement(By.id("Content1_MainRepeater_ddlcustom_3")).click();

		// Save
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@title=\"Save\"]")).click();

		Thread.sleep(1000);
		// NoCustomize header
		driver.findElement(By.id("Content1_MainRepeater_rdbList_0_1_0")).click();

		// Save
		driver.findElement(By.xpath("//img[@title=\"Save\"]")).click();

		// Customize footer
		// No
		driver.findElement(By.id("Content1_MainRepeater_rdbList_0_1_0")).click();

		// Save
		driver.findElement(By.xpath("//img[@title=\"Save\"]")).click();

		// Watermark

		// No
		driver.findElement(By.id("Content1_MainRepeater_rdbList_0_1_0")).click();

		// Save
		driver.findElement(By.xpath("//img[@title=\"Save\"]")).click();

		// Handbook or

		driver.findElement(By.id("Content1_MainRepeater_rdbListRadio_0_0_0")).click();

		// Save
		driver.findElement(By.xpath("//img[@title=\"Save\"]")).click();

		// Number if Employee
		driver.findElement(By.id("Content1_MainRepeater_txtTotalNoofEmployee_0")).sendKeys("1");
	}

}
