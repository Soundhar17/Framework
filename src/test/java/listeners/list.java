package listeners;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.Baseclass;

public class list extends Baseclass implements ITestListener {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext context) {
		System.out.println("⚙️ Test Suite Starting");

		String reportPath = System.getProperty("user.dir") + "/src/main/resources/ExtentReports/login.html";

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setDocumentTitle("login Report");
		sparkReporter.config().setReportName("Test Execution login Report");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "soundhar");
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("🚀 Starting Test: " + result.getName());
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("✅ Test Passed: " + result.getName());
		test.get().pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("❌ Test Failed: " + result.getName());
		test.get().fail(result.getThrowable());
		try {
			Baseclass.screenshots("failed");
		} catch (AWTException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("⚠️ Test Skipped: " + result.getName());
		test.get().skip(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("✅ All Tests Completed");
		extent.flush();
	}
}

/*
 * public void onTestStart(ITestResult result) {
 * 
 * System.out.println("onTestStart");
 * 
 * }
 * 
 * public void onTestSuccess(ITestResult result) {
 * System.out.println("onTestSuccess");
 * 
 * }
 * 
 * public void onTestFailure(ITestResult result) {
 * System.out.println("onTestFailure"); try { Baseclass.screenshots("failed"); }
 * catch (AWTException | IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * 
 * }
 * 
 * public void onTestSkipped(ITestResult result) {
 * System.out.println("onTestSkipped");
 * 
 * }
 * 
 * public void onStart(ITestContext context) {
 * 
 * System.out.println("onStart"); }
 * 
 * public void onFinish(ITestContext context) { System.out.println("onFinish");
 * 
 * }
 * 
 * }
 */