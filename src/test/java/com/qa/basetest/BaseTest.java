/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.basepages.BasePage;
import com.qa.basepages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author nites
 *
 */
public class BaseTest {

	public WebDriver driver;
	public Page page;

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(@Optional("chrome")String browser) throws InterruptedException {

		if (browser.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.get("http://automationpractice.com/index.php");
		//driver.manage().window().maximize();
		page = new BasePage(this.driver);
	

	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
