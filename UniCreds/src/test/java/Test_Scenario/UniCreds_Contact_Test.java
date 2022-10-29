
              ////////////// MOHAMMAD UMER BAIG  ////////////////
             //////////////      29-10-2021     //////////////////
              

package Test_Scenario;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Objects.UniCreds_Contact_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UniCreds_Contact_Test {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	WebDriver driver;
	
	@BeforeTest
	public void  beforetest() {
		
		htmlReporter = new ExtentSparkReporter("ExtentReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine: ", "Lenovo");
		reports.setSystemInfo("OS: ", "Windows 11");
		reports.setSystemInfo("Test Executer Name : ", "Mohammad Umer Baig");

		//configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report of UniCreds Contact Page");
		htmlReporter.config().setReportName("UniCreds Test Report");		
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEE, MMM dd, yyyy,  hh:mm a '('zzz')'");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		driver.get("https://unicreds.com/contact-us");
		test = reports.createTest("Launch Browser and Open URL");
		Assert.assertTrue(true);
	}
	
	@Test
	public void Name() {
		UniCreds_Contact_Page page = new UniCreds_Contact_Page(driver);
		page.setTextInName("Mohammad Umer Baig");
		test = reports.createTest("Enter the Name");
		Assert.assertTrue(true);
	}
	
	@Test
	public void Email() {
		UniCreds_Contact_Page page = new UniCreds_Contact_Page(driver);
		page.setTextInEmail("abrarbaig032000@gmail.com");
		test = reports.createTest("Enter the Mail I'D");
		Assert.assertTrue(true);
	}
	
	@Test
	public void Phone() {
		UniCreds_Contact_Page page = new UniCreds_Contact_Page(driver);
		page.setTextInPhone("8291429415");
		test = reports.createTest("Enter your Mobile Number");
		Assert.assertTrue(true);
	}
	
	@Test
	public void Message() {
		UniCreds_Contact_Page page = new UniCreds_Contact_Page(driver);
		page.setTextInMessage("Hey, Hope you are Good.");
		test = reports.createTest("Enter the Message");
		Assert.assertTrue(true);
	}
	
	@Test
	public void Submit() {
		UniCreds_Contact_Page page = new UniCreds_Contact_Page(driver);
		page.clickOnSubmit();
		test = reports.createTest("Click On Submit");
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void getTestResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Failed", ExtentColor.RED));
		    test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Passed", ExtentColor.GREEN));
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Skipped", ExtentColor.BLACK));
		}
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
		reports.flush();
	}

}
