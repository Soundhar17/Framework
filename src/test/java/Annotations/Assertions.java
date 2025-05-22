package Annotations;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import dev.failsafe.internal.util.Assert;

public class Assertions {

	WebDriver Driver;
	

	@BeforeClass
	public void driver() throws InterruptedException {

		Driver = new ChromeDriver();

		

		Driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 1)
	public void title() {

		String title = Driver.getTitle();

		assertEquals(title, "OrangeHRM");
		System.out.println("matched");
	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));

		// Wait for username field and enter value
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")))
				.sendKeys("Admin");

		// Wait for password field and enter value
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")))
				.sendKeys("admin123");

		// Wait for login button and click
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

		// Wait for dashboard to load and verify URL
		wait.until(ExpectedConditions.urlContains("/dashboard"));

		String currentUrl = Driver.getCurrentUrl();
		assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

		System.out.println("Login completed and URL verified");
	}
    @Test(priority = 3)
	public void logout() {
    	WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-userdropdown-tab']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']"))).click();
        
        String text = Driver.findElement(By.xpath("//h5[text()='Login']")).getText();
        
        assertEquals(text, "Login");
        System.out.println("logged out successfully");
	}

	@AfterClass
	public void after() {
		Driver.close();

	}

}
