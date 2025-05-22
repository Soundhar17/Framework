package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Baseclass;

public class BookingScreen extends Baseclass {

	public BookingScreen(WebDriver Drive) {

		Drive = this.Drive;

	}

	private By flight = By.xpath("//input[@class='btn btn-small'][1]");

	public WebElement getFlight() {
		return Drive.findElement(flight);
	}

	public void setFlight(By flight) {
		this.flight = flight;
	}

	private By name = By.xpath("//input[@placeholder='First Last']");
	private By Addr = By.xpath("//input[@id='address']");
	private By city = By.xpath("//input[@id='city']");
	private By state = By.xpath("//input[@id='state']");
	private By zip = By.xpath("//input[@id='zipCode']");
	private By card = By.xpath("//select[@class='form-inline']/option");
	private By cnumber = By.xpath("//input[@id='creditCardNumber']");
	private By cmonth = By.xpath("//input[@id='creditCardMonth']");
	private By cyear = By.xpath("//input[@id='creditCardYear']");
	private By nacard = By.xpath("//input[@id='nameOnCard']");
	private By click = By.xpath("//input[@class='btn btn-primary']");

	private By bookid = By.xpath("// table[@class='table']//td[2]");

	public List<WebElement> getBookid() {
		return Drive.findElements(bookid);
	}

	public void setBookid(By bookid) {
		this.bookid = bookid;
	}

	public WebElement getName() {
		return Drive.findElement(name);
	}

	public void setName(By name) {
		this.name = name;
	}

	public WebElement getAddr() {
		return Drive.findElement(Addr);
	}

	public void setAddr(By addr) {
		Addr = addr;
	}

	public WebElement getCity() {
		return Drive.findElement(city);
	}

	public void setCity(By city) {
		this.city = city;
	}

	public WebElement getState() {
		return Drive.findElement(state);
	}

	public void setState(By state) {
		this.state = state;
	}

	public WebElement getZip() {
		return Drive.findElement(zip);
	}

	public void setZip(By zip) {
		this.zip = zip;
	}

	public List<WebElement> getCard() {
		return Drive.findElements(card);
	}

	public void setCard(By card) {
		this.card = card;
	}

	public WebElement getCnumber() {
		return Drive.findElement(cnumber);
	}

	public void setCnumber(By cnumber) {
		this.cnumber = cnumber;
	}

	public WebElement getCmonth() {
		return Drive.findElement(cmonth);
	}

	public void setCmonth(By cmonth) {
		this.cmonth = cmonth;
	}

	public WebElement getCyear() {
		return Drive.findElement(cyear);
	}

	public void setCyear(By cyear) {
		this.cyear = cyear;
	}

	public WebElement getNacard() {
		return Drive.findElement(nacard);
	}

	public void setNacard(By nacard) {
		this.nacard = nacard;
	}

	public WebElement getClick() {
		return Drive.findElement(click);
	}

	public void setClick(By click) {
		this.click = click;
	}

}
