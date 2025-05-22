package Annotations;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import POM.POMClass;
import Utilities.Baseclass;

public class dataprovider extends Baseclass {
	static ExtentReports extent;

	String path1 = "E:/eclipse new/TestNg/src/test/resources/Screen" + System.currentTimeMillis() + ".png";
	// static String path2 = "E:\\eclipse
	// new\\TestNg\\src\\main\\resources\\Excelsheet\\Excel 1.0.xlsx";

	static POMClass s = new POMClass(Drive);

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void launchbrowser(String browsers) throws InterruptedException {
		dataprovider.browser(browsers); // Pass browser like "chrome", "firefox", etc.
		dataprovider.geturl("https://practicetestautomation.com/practice-test-login/");
	}

	/*
	 * @DataProvider public Object[][] dat() {
	 * 
	 * Object[][] arr = { { "student", "Password123" }, { "student", "Passwod12" },
	 * { "sdent", "Password123" }, { "", "ssword123" }, { "sss", "" }, { "", "" } };
	 * 
	 * return arr;
	 * 
	 * }
	 */

	@Test(priority = 1, dataProviderClass = Baseclass.class, dataProvider = "data", groups = { "smoke" })
	public static void data(String user, String pass) throws InterruptedException, AWTException, IOException {

		POMClass.waitForVisibility(Drive, s.getUsername(), 10);
		s.getUsername().sendKeys(user);

		POMClass.waitForVisibility(Drive, s.getPassword(), 10);
		s.getPassword().sendKeys(pass);

		POMClass.waitForclickable(Drive, s.getSubmit(), 10);

		s.getSubmit().click();

		// s.screenshots("valid");

		Thread.sleep(2000);

		WebElement logout = s.getLogout();
		Assert.assertEquals(logout.isDisplayed(), true);
		logout.click();

		// Create ExtentSparkReporter
		ExtentSparkReporter spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/src/main/resources/ExtentReports/login.html");

		// Create and attach the main ExtentReports object
		extent = new ExtentReports();
		extent.attachReporter(spark);

		// Create a test
		ExtentTest test = extent.createTest("loginpage");
		test.log(Status.PASS, "Login page success");

		// Finally flush to write the report to disk
		extent.flush();

		// Optional: Check if login was successful before clicking logout
		// if (condition to check login success) {
		// s.getLogout().click();
		// }
	}

	@Test(priority = 2, dataProviderClass = Baseclass.class, dataProvider = "datas", groups = "sanity")

	public static void data1(String user, String pass) throws InterruptedException, AWTException, IOException {

		POMClass.waitForVisibility(Drive, s.getUsername(), 10);
		s.getUsername().sendKeys(user);

		POMClass.waitForVisibility(Drive, s.getPassword(), 10);
		s.getPassword().sendKeys(pass);

		POMClass.waitForclickable(Drive, s.getSubmit(), 10);

		s.getSubmit().click();

		// Assert.assertEquals(Drive.getCurrentUrl(),
		// "https://practicetestautomation.com/practice-test-login/");

//https://practicetestautomation.com/logged-in-successfully/
		/*
		 * Thread.sleep(2000); Assert.assertEquals(logout.isDisplayed(), false);
		 * logout.click();
		 */

		// s.screenshots("invalid");

		// Assert.assertEquals(Drive.getCurrentUrl(),
		// "https://practicetestautomation.com/practice-test-login/");

		// Create ExtentSparkReporter
		String reportPath = System.getProperty("user.dir") + "/src/main/resources/ExtentReports/login_.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

		// Create and attach the main ExtentReports object
		extent = new ExtentReports();
		extent.attachReporter(spark);

		if (Drive.getCurrentUrl().equals("https://practicetestautomation.com/practice-test-login/")) {
			System.out.println("Testcases are passed");
			ExtentTest test1 = extent.createTest("loginpagepass");
			test1.log(Status.PASS, "Login page success");

		} else {
			System.out.println("Testcases are Failed");
			ExtentTest test = extent.createTest("loginpagefailed");
			test.log(Status.FAIL, "Login page failed");
		}

		// Create a test

		// Finally flush to write the report to disk
		extent.flush();

	}

	@AfterMethod(alwaysRun = true)
	public void closebrowser() throws InterruptedException {

		Drive.close();
		// from Baseclass
	}

}