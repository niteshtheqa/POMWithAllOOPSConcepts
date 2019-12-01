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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author nites
 *
 */
public abstract class Page {

	WebDriver driver;
	WebDriverWait wait;
	public Actions actions;

	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 10);
		this.actions = new Actions(this.driver);
		
	}

	public abstract String getPageTitle();

	public abstract WebElement getElement(By locator);

	public abstract void waitForElementPresence(By locator);

	public abstract void waitForPageTitle(String title);

	public abstract String getPageHeader(By locator);

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
