package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Baseclass;

public class blazedemo extends Baseclass {

	public blazedemo(WebDriver Drive) {

		Drive = this.Drive;

	}

	private By displayed = By.xpath("//select[@class='form-inline']");

	private By cities = By.xpath("//select[@name='fromPort']/child::*");

	private By tocities = By.xpath("//select[@name='toPort']/child::*");

	private By from = By.xpath("//select[@name='fromPort']/child::*");

	private By to = By.xpath("//select[@name='toPort']/child::*");

	private By clk = By.xpath("//input[@class='btn btn-primary']");

	private By dis = By.xpath("// th[text()='Airline']/ancestor::table//tr/td[3]");
    
	
	private By route = By.xpath("//div[@class='container']/h3");
	
	private By price = By.xpath("//th[text()='Airline']/ancestor::table//tr/td[6]");
	
	
	
	public List<WebElement> getPrice() {
		return Drive.findElements(price);
	}

	public void setPrice(By price) {
		this.price = price;
	}

	public WebElement getRoute() {
		return Drive.findElement(route);
	}

	public void setRoute(By route) {
		this.route = route;
	}
	

	public List<WebElement> getDis() {
		return Drive.findElements(dis);
	}

	public void setDis(By dis) {
		this.dis = dis;
	}

	public WebElement getClk() {
		return Drive.findElement(clk);
	}

	public void setClk(By clk) {
		this.clk = clk;
	}

	public List<WebElement> getTo() {
		return Drive.findElements(to);
	}

	public void setTo(By to) {
		this.to = to;
	}

	public List<WebElement> getFrom() {
		return Drive.findElements(from);
	}

	public void setFrom(By from) {
		this.from = from;
	}

	public List<WebElement> getTocities() {
		return Drive.findElements(tocities);
	}

	public void setTocities(By tocities) {
		this.tocities = tocities;
	}

	public List<WebElement> getCities() {
		return Drive.findElements(cities);
	}

	public void setCities(By cities) {
		this.cities = cities;
	}

	public List<WebElement> getDisplayed() {
		return Drive.findElements(displayed);
	}

	public List<WebElement> setDisplayed(By displayed) {
		return Drive.findElements(displayed);
	}

}
