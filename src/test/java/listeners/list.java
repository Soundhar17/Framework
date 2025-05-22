package listeners;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import Utilities.Baseclass;

public class list extends Baseclass implements ITestListener {

	public void onTestStart(ITestResult result) {

		System.out.println("onTestStart");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		try {
			Baseclass.screenshots("failed");
		} catch (AWTException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");

	}

	public void onStart(ITestContext context) {

		System.out.println("onStart");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");

	}

}
