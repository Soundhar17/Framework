package Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class annoation {
	
    @BeforeSuite
	public static void beforesuite() {

		System.out.println("BeforeSuite");

	}
    @BeforeTest
	public static void beforetest() {

		System.out.println("beforetest");

	}
    @BeforeClass
	public static void beforeclass() {

		System.out.println("beforeclass");

	}
    @BeforeMethod
	public static void beforemethod() {

		System.out.println("beforemethod");

	}
    @Test(groups = {"smoke","regression"})
	public static void test01() {

		System.out.println("test01");

	}
    @Test(groups = {"sanity","smoke"})
	public static void test02() {

		System.out.println("test02");

	}
    
    @AfterMethod
    public static void Aftermethod() {

		System.out.println("Aftermethod");

	}
    @AfterClass
    public static void Afterclass() {

		System.out.println("Afterclass");

	}
    @AfterTest
    public static void Aftertest() {

		System.out.println("Aftertest");

	}
    @AfterSuite
    public static void Aftersuite() {

		System.out.println("Aftersuite");

	}
    
    

}
