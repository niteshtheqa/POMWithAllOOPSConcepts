/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.pages;

import java.net.NetworkInterface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.basepages.BasePage;

/**
 * @author nites
 *
 */
public class LoginPage extends BasePage {

	// Page locators

	private By user = By.xpath("//a[@title='View my customer account']");
	private By email = By.xpath("//label[@for='email']//following-sibling::input[@name='email']");
	private By invalidEmail = By.xpath("//div[@class='form-group form-error']//label[@for='email']");
	private By password = By.xpath("//div[@class='form-group']//input[@id='passwd']");
	private By signInBtn = By.xpath("//p[@class='submit']//button[@id='SubmitLogin']");
	private By homeLink = By.xpath("//a[@title='Home']");
	private By myAccount = By.xpath("//span[text()='My account']");
	private By sigInLnk = By.xpath("//a[@class='login' and @title='Log in to your customer account']");

	/**
	 * @return the sigInLnk
	 */
	public WebElement getSigInLnk() {
		return getElement(sigInLnk);
	}

	/**
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * @return the user
	 */
	public WebElement getUser() {
		return getElement(user);
	}

	/**
	 * @return the email
	 */
	public WebElement getEmail() {
		return getElement(email);
	}

	/**
	 * @return the invalidEmail
	 */
	public WebElement getInvalidEmail() {
		return getElement(invalidEmail);
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}

	/**
	 * @return the signInBtn
	 */
	protected WebElement getSignInBtn() {
		return getElement(signInBtn);
	}

	/**
	 * @return the homeLink
	 */
	public WebElement getHomeLink() {
		return getElement(homeLink);
	}

	/**
	 * @return the myAccount
	 */
	public WebElement getMyAccount() {
		return getElement(myAccount);
	}

	public String getLoginPageTitle() {
		getSigInLnk().click();
		return getPageTitle();
	}

	public HomePage doLogin(String em, String pass) throws InterruptedException {
		getSigInLnk().click();
		Thread.sleep(5000);
		getEmail().sendKeys(em);
		getPassword().sendKeys(pass);
		actions.moveToElement(getSignInBtn()).doubleClick().build().perform();
//		email.clear();
//		email.sendKeys(em);
//		password.clear();
//		password.sendKeys(pass);
//		actions.moveToElement(SignInBtn).doubleClick().build().perform();
//		homeLink.click();
//		return new HomePage();

		return getInstance(HomePage.class);

	}

}
