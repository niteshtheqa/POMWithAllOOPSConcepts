/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.basepages.BasePage;

/**
 * @author nites
 *
 */
public class HomePage extends BasePage {

	private By user = By.xpath("//a[@title='View my customer account']");

	/**
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	

}
