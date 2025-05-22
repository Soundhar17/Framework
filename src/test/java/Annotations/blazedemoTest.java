package Annotations;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.junit.Ignore;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import POM.BookingScreen;
import POM.blazedemo;
import Utilities.Baseclass;

public class blazedemoTest extends Baseclass {

	static ExtentReports extent;

	static blazedemo v = new blazedemo(Drive);

	static BookingScreen c = new BookingScreen(Drive);

	@BeforeTest(alwaysRun = true)

	public static void reports() {
		ExtentSparkReporter spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/src/main/resources/ExtentReports/blazedemo.html");

		// Create and attach the main ExtentReports object
		extent = new ExtentReports();
		extent.attachReporter(spark);

		// Create a test

	}

	@BeforeMethod(alwaysRun = true)
	
	public void setup() {
		blazedemoTest.browser("chrome");
		blazedemoTest.geturl("https://blazedemo.com/");
		// blazedemoTest.max();

	}

	@Test(priority = 1, description = "Verify website homepage accessibility", groups = "tc_01")
	public static void tc_01() throws InterruptedException, AWTException, IOException {

		Assert.assertEquals(Drive.getCurrentUrl(), "https://blazedemo.com/");

		List<WebElement> displayed = v.getDisplayed();

		for (WebElement dis : displayed) {

			String text = dis.getText();
			System.out.println("Expected Items are displayed " + dis.isDisplayed());
			Thread.sleep(5000);
		}

		ExtentTest test = extent.createTest("Verify website homepage accessibility_TC_1")
				.addScreenCaptureFromPath(c.screenshots("TC_01"));
		test.log(Status.PASS, "Verify website homepage accessibility");

	}

	@Test(priority = 2, description = "Verify dropdown values for \"From\" city", groups = "tc_02")
	public static void tc_02() throws AWTException, IOException {

		List<WebElement> cities = v.getCities();

		for (WebElement city : cities) {
			System.out.println(city.getText());

		}

		ExtentTest test = extent.createTest("Verify dropdown values for \"From\" city_TC_2")
				.addScreenCaptureFromPath(v.screenshots("TC_02"));
		test.log(Status.PASS, "Verify dropdown values for \"From\" city");

	}

	@Test(priority = 3, description = "Verify dropdown values for \"To\" city", groups = "tc_03")
	public static void tc_03() throws AWTException, IOException {

		List<WebElement> cities = v.getCities();

		for (WebElement city : cities) {
			System.out.println(city.getText());

		}

		ExtentTest test = extent.createTest("Verify dropdown values for \"To\" city_TC_3")
				.addScreenCaptureFromPath(v.screenshots("TC_03"));
		test.log(Status.PASS, "Verify dropdown values for \"To\" city");

	}

	@Test(priority = 4, description = "Verify flight search functionality", dataProviderClass = Baseclass.class, dataProvider = "datas", groups = "tc_04")
	public static void tc_04(String from, String to) throws InterruptedException, AWTException, IOException {

		List<WebElement> fromList = v.getFrom(); // assuming v.getFrom() returns all 'from' dropdown values or options

		for (WebElement option : fromList) {
			if (option.getText().equalsIgnoreCase(from)) {
				Thread.sleep(5000);
				option.click(); // only click the matching one
				break;
			}
		}

		List<WebElement> tolist = v.getTo();

		for (WebElement option1 : tolist) {
			if (option1.getText().equalsIgnoreCase(to)) {
				Thread.sleep(5000);
				option1.click();
				Thread.sleep(2000);
				v.getClk().click();
				Thread.sleep(2000);

				WebElement route = v.getRoute();

				System.out.println(route.isDisplayed());
				Thread.sleep(2000);
				/*
				 * List<WebElement> dis = v.getDis();
				 * 
				 * for (WebElement d : dis) { Thread.sleep(2000); boolean displayed =
				 * d.isDisplayed(); System.out.println(displayed);
				 * 
				 * }
				 */
				// only click the matching one
				break;

			}
		}

		ExtentTest test = extent.createTest("Verify flight search functionality_TC_4")
				.addScreenCaptureFromPath(v.screenshots("TC_04"));
		test.log(Status.PASS, "Verify flight search functionality");

	}

	@Test(priority = 5, groups = {
			"tc_05" }, description = "Verify flight details display", dataProviderClass = Baseclass.class, dataProvider = "datas", enabled = true)
	public static void tc_05(String from, String to) throws InterruptedException, AWTException, IOException {

		List<WebElement> fromList = v.getFrom(); // assuming v.getFrom() returns all 'from' dropdown values or options

		for (WebElement option : fromList) {
			if (option.getText().equalsIgnoreCase(from)) {
				Thread.sleep(5000);
				option.click(); // only click the matching one
				break;
			}
		}

		List<WebElement> tolist = v.getTo();

		for (WebElement option1 : tolist) {
			if (option1.getText().equalsIgnoreCase(to)) {
				Thread.sleep(5000);
				option1.click();

				v.getClk().click();
				break;
			}
		}
		Thread.sleep(2000);
		List<WebElement> dis = v.getDis();

		for (WebElement d : dis) {
			Thread.sleep(2000);
			boolean displayed = d.isDisplayed();
			System.out.println(displayed);

		}

		List<WebElement> price = v.getPrice();

		for (WebElement pr : price) {
			Thread.sleep(2000);
			System.out.println(pr.isDisplayed());

		}

		ExtentTest test = extent.createTest("Verify flight details display_TC_5")
				.addScreenCaptureFromPath(v.screenshots("TC_05"));
		test.log(Status.PASS, "Verify flight details display");

	}

	@Test(priority = 6, groups = "tc_06", description = "Verify booking process", dataProviderClass = Baseclass.class, dataProvider = "datas")
	public static void tc_06(String from, String to) throws InterruptedException, AWTException, IOException {

		// Select departure location
		for (WebElement option : v.getFrom()) {
			if (option.getText().equalsIgnoreCase(from)) {
				option.click();
				break;
			}
		}

		// Select destination location
		for (WebElement option : v.getTo()) {
			if (option.getText().equalsIgnoreCase(to)) {
				option.click();
				v.getClk().click(); // click the Find Flights or Search button
				break;
			}
		}

		// Booking steps
		c.getFlight().click();
		Thread.sleep(2000);
		c.getName().sendKeys("Soundhar");
		c.getAddr().sendKeys("234 Tamilnadu");
		c.getCity().sendKeys("Madurai");
		c.getState().sendKeys("Tamilnadu");
		c.getZip().sendKeys("886893");

		// Select card type
		for (WebElement option : c.getCard()) {
			if (option.getText().equalsIgnoreCase("Visa")) {
				option.click();
				break;
			}
		}

		c.getCnumber().sendKeys("3445 6777 4554");
		c.getCmonth().sendKeys("12");
		c.getCyear().sendKeys("2024");
		c.getNacard().sendKeys("Platinum");
		c.getClick().click(); // fix the missing click

		// Confirm booking success
		for (WebElement book : c.getBookid()) {
			System.out.println("Booking ID visible: " + book.isDisplayed());
			Thread.sleep(2000);
		}
		ExtentTest test = extent.createTest("Verify booking process_TC_6")
				.addScreenCaptureFromPath(v.screenshots("TC_06"));
		test.log(Status.PASS, "Verify booking process");

	}

	@Test(priority = 7, groups = "tc_07", description = "Verify \"Back\" button functionality", dataProviderClass = Baseclass.class, dataProvider = "datas")
	public static void tc_07(String from, String to) throws AWTException, IOException {

		// Select departure location
		for (WebElement option : v.getFrom()) {
			if (option.getText().equalsIgnoreCase(from)) {
				option.click();
				break;
			}
		}

		// Select destination location
		for (WebElement option : v.getTo()) {
			if (option.getText().equalsIgnoreCase(to)) {
				option.click();
				v.getClk().click(); // click the Find Flights or Search button
				break;
			}

		}
		c.navigateBack(Drive);

		String currentUrl = Drive.getCurrentUrl();

		Assert.assertEquals(currentUrl, "https://blazedemo.com/");

		ExtentTest test = extent.createTest("Verify \"Back\" button functionality_TC_7")
				.addScreenCaptureFromPath(v.screenshots("TC_07"));
		test.log(Status.PASS, "Verify button process");

	}

	@AfterMethod(alwaysRun = true)
	public void clo() throws InterruptedException {
		Thread.sleep(2000);
		Drive.close();

	}

	@AfterTest(alwaysRun = true)
	public static void tear() {
		extent.flush();
	}

}
