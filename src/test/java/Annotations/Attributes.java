package Annotations;

import org.testng.annotations.Test;

public class Attributes {

	@Test(priority = 1, description = "login successfully",invocationCount = 2,enabled = false)
	public void login() {

		// System.out.println("login successfully");

	}

	@Test(priority = 2, description = "home successfully",timeOut = 2000)
	public void Home() {

		// System.out.println("home successfully");

	}

	@Test(priority = 3, description = "search successfully",invocationCount = 3,invocationTimeOut = 2000)
	public void search() {

		//System.out.println(search successfully);

	}

	@Test(priority = 4, description = "confirm successfully",dependsOnMethods = "search",alwaysRun = true)
	public void confirm() {

		// System.out.println("confirm successfully");

	}

	@Test(priority = 5, description = "logout successfully")
	public void logout() {

		// System.out.println("logout successfully");

	}

}
