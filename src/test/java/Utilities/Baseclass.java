package Utilities;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import net.bytebuddy.asm.Advice.Return;

public class Baseclass {

	public static WebDriver Drive;

	public static void browser(String browser) {
		switch (browser) {
		case "chrome":

			Drive = new ChromeDriver();
			System.out.println("Launching Chrome Browser");
			// You could initialize WebDriver here if needed
			break;

		case "firefox":
			Drive = new FirefoxDriver();
			System.out.println("Launching Firefox Browser");
			break;

		case "edge":
			Drive = new EdgeDriver();
			System.out.println("Launching Edge Browser");
			break;

		default:
			System.out.println("Invalid browser name");
			break;
		}

		Return Drive;
	}

	public static void geturl(String url) {
		Drive.get(url);

		System.out.println("URL launched successfully");

	}

	public static String credentials(String path, String sheet, int row, int cell) throws IOException {

		// get the Excel path
		File path1 = new File(path);

		// Read the Excel file
		FileInputStream read = new FileInputStream(path1);

		// get the Workbook
		Workbook v = new XSSFWorkbook(read);

		// get the sheet
		Sheet sheet1 = v.getSheet(sheet);

		int physicalNumberOfRows = sheet1.getPhysicalNumberOfRows();

		for (int i = 0; i < physicalNumberOfRows; i++) {

			Row row1 = sheet1.getRow(row);

			int physicalNumberOfCells = row1.getPhysicalNumberOfCells();

			for (int j = 0; j < physicalNumberOfCells; j++) {

				Cell cell1 = row1.getCell(cell);

				DataFormatter format = new DataFormatter();
				String data = format.formatCellValue(cell1);

				v.close();

				return data;

			}

		}
		return sheet;

		// get the row

	}

	public static void click(WebElement element) {

		element.click();

		System.out.println("Click Action successfully completed");

	}

	public static void Dropdown(String text, String value, int index, WebElement element, String type) {
		Select a = new Select(element);

		switch (type.toLowerCase()) {
		case "text":
			a.selectByVisibleText(text);
			System.out.println("Selected by Text successfully");
			break;

		case "value":
			a.selectByValue(value);
			System.out.println("Selected by Value successfully");
			break;

		case "index":
			a.selectByIndex(index);
			System.out.println("Selected by Index successfully");
			break;

		default:
			System.out.println("Invalid selection type. Use 'text', 'value', or 'index'.");
			break;
		}
	}

	public static void title() {

		String title = Drive.getTitle();

		System.out.println("get the Title" + title);

	}

	public static void radio(WebElement element) {
		element.click();

	}

	public static String screenshots(String testName) throws AWTException, IOException {

		String baseDir = System.getProperty("user.dir");
		String timestamp = String.valueOf(System.currentTimeMillis());
		String fullPath = baseDir + "/src/main/resources/Screen/" + testName + "_" + timestamp + ".png";

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage screenshot = robot.createScreenCapture(screenRectangle);

		File outputFile = new File(fullPath);
		ImageIO.write(screenshot, "png", outputFile);

		System.out.println("Screenshot caputed successfully");
		return fullPath;

	}

	public static void close() {

		Drive.close();

	}

	public static void display(WebElement element) {

		if (element.isDisplayed()) {
			System.out.println("Element displayed");

		} else {
			System.out.println("Element not displayed");
		}

	}

	public static void max() {

		Drive.manage().window().maximize();
		System.out.println("Window maximized");
	}

	public static void min() {

		Drive.manage().window().minimize();

		System.out.println("Window minimized");
	}

	public static void mousehover(WebElement element) {
		Actions x = new Actions(Drive);

		x.moveToElement(element).build().perform();

	}

	public static void doubleclick(WebElement element) {
		Actions x = new Actions(Drive);

		x.doubleClick(element).build().perform();

	}

	public static void rightclick(WebElement element) {
		Actions x = new Actions(Drive);

		x.contextClick().build().perform();

	}

	public static void draganddrop(WebElement des, WebElement end) {
		Actions x = new Actions(Drive);

		x.dragAndDrop(des, end).build().perform();
	}

	public static void enabled(WebElement element) {
		if (element.isEnabled()) {

			System.out.println("isEnabled");

		} else {

			System.out.println("not Enabled");

		}

	}

	public static void selected(WebElement element) {
		if (element.isSelected()) {

			System.out.println("isSelected");

		} else {

			System.out.println("not Selected");

		}

	}

	public static void navigateTo(WebDriver driver, String url) {
		driver.navigate().to(url);
		System.out.println("Navigated to: " + url);
	}

	public static void navigateBack(WebDriver driver) {
		driver.navigate().back();
		System.out.println("Navigated back");
	}

	public static void navigateForward(WebDriver driver) {
		driver.navigate().forward();
		System.out.println("Navigated forward");
	}

	public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
		System.out.println("Page refreshed");
	}

	public static void windowhandle(WebDriver driver) {
		String windowHandle = driver.getWindowHandle();
		System.out.println("Single window handled" + windowHandle);
	}

	public static void waitForVisibility(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static void waitForclickable(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	@DataProvider
	public static String[][] data() throws IOException {

		File f = new File("E:\\eclipse new\\TestNg\\src\\main\\resources\\Excelsheet\\Excel 1.0.xlsx");
		FileInputStream v = new FileInputStream(f);

		Workbook s = new XSSFWorkbook(v);

		Sheet sheet = s.getSheet("travel");

		int rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();

		String datas[][] = new String[rows-1][cells];

		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < cells; j++) {

				DataFormatter m = new DataFormatter();

				String datas1 = m.formatCellValue(sheet.getRow(i).getCell(j));

				datas[i-1][j] = datas1;

			}

		}
		return datas;

	}
	@DataProvider
	public static String[][] datas() throws IOException {

		File f = new File("E:\\eclipsenew\\TestNg\\src\\main\\resources\\Excelsheet\\Excel 1.0.xlsx");
		FileInputStream v = new FileInputStream(f);

		Workbook s = new XSSFWorkbook(v);

		Sheet sheet = s.getSheet("invalid");

		int rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();

		String datas[][] = new String[rows-1][cells];

		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < cells; j++) {

				DataFormatter m = new DataFormatter();

				String datas1 = m.formatCellValue(sheet.getRow(i).getCell(j));

				datas[i-1][j] = datas1;

			}

		}
		return datas;

	}
	
	/*public static void extendreport(String reportpath) {
		
		// directory where output is to be printed
		ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);*/

		
		
		
	}
	
	

