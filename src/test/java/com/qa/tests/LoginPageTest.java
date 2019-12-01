/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

/**
 * @author nites
 *
 */
public class LoginPageTest extends BaseTest {

	@Test(priority = 1,enabled = true)
	public void verifyLoginPageTitleTest() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		String expectedTitle = "Login - My Store";
		Assert.assertEquals(title, expectedTitle);
	}

	@Test(priority = 2)
	public void verifyDoLoginTest() throws InterruptedException {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin("bulldog@gmail.com","bulldog");
	Thread.sleep(10000);
	}
}
