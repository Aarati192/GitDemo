package MavenProject.MavenJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SeleniumTest {
	
	ExtentReports extent;
	@BeforeTest
	public void ExtentReports()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Aarati Sabnis");
	}
	
	@Test
	public void Demo()
	{
		ExtentTest test = extent.createTest("Initial Demo");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ADMIN\\Documents\\FirefoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
	    driver.get("https://www.google.com/"); 
	    System.out.println(driver.getTitle());
	    driver.close();
	   // test.fail("Result do not match");
		extent.flush();
	}
	

	

}
