package tests;

import java.lang.reflect.Method;

import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import rest.Methods2;

public class ExtentReportClass {



	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public String testName;

	@BeforeSuite
	public void setExtent() {

		htmlReporter = new ExtentHtmlReporter(Methods2.createFolderPath());
		htmlReporter.config().setDocumentTitle("myReport" + Methods2.getDate());
		htmlReporter.config().setReportName("myReport" + Methods2.getDate());
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester Name", "zika");

	}

	@AfterTest
	public void endReport() {

		extent.flush();
	}

	@BeforeMethod
	public void handleTestMethodName(Method method) {

		testName = method.getName();

	}

	@BeforeMethod
	public void setTest() {

		test = extent.createTest(testName);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed " + result.getName());
			test.log(Status.FAIL, "***" + result.getThrowable());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Passed " + result.getName());
		}
	}

}
