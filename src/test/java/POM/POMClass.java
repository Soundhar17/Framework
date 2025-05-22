package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Baseclass;

public class POMClass extends Baseclass {

	//public static WebDriver Drive;

	public POMClass(WebDriver Drive) {

		this.Drive = Drive;

	}

	private By username = By.xpath("//input[@name='username']");
	private By password = By.xpath("//input[@name='password']");
	private By submit = By.xpath("//button[@class='btn']");
	private By logout = By.xpath("//a[text()='Log out']");

	public WebElement getUsername() {
		return Drive.findElement(username);
	}

	public void setUsername(By username) {
		this.username = username;
	}

	public WebElement getPassword() {
		return Drive.findElement(password);
	}

	public void setPassword(By password) {
		this.password = password;
	}

	public WebElement getSubmit() {
		return Drive.findElement(submit);
	}

	public void setSubmit(By submit) {
		this.submit = submit;
	}

	public WebElement getLogout() {
		return Drive.findElement(logout);
	}

	public void setLogout(By logout) {
		this.logout = logout;
	}

}
