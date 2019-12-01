/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.basepages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author nites
 *
 */
public class BasePage extends Page {
	public Properties prop;
	public static String PATH = Paths.get("./src/main/java/com/qa/automation/configuration/configuration.properties")
			.toAbsolutePath().normalize().toString();

	/**
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		super(driver);
		try {

			prop = new Properties();
			FileInputStream fileInputStream = new FileInputStream(PATH);
			prop.load(fileInputStream);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mypage.Page#getPageTitle()
	 */
	@Override
	public String getPageTitle() {
		return driver.getTitle();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mypage.Page#getElement(org.openqa.selenium.By)
	 */
	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			return driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Error occured while locating" + locator);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void waitForElementPresence(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Errir occured while waiting for " + locator.toString());
			e.printStackTrace();
		}
	}

	/*
	 * @see mypage.Page#waitForPageTitle()
	 */
	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Error occured while waiting for " + title);
		}
	}

	/*
	 * 
	 * @see mypage.Page#getPageHeader(org.openqa.selenium.By)
	 */
	@Override
	public String getPageHeader(By locator) {

		return getElement(locator).getText();
	}

}
