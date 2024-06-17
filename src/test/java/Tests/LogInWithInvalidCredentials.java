package Tests;

import Base.BaseTest;
import Base.Strings;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInWithInvalidCredentials extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void TC_002LogInWithInvalidUsernameCredentials() {

        logInPage.enterUsername(Strings.INVALID_USERNAME);
        logInPage.enterPassword(Strings.VALID_PASSWORD);
        logInPage.clickLoginButton();
        Assert.assertTrue(logInPage.errorMessageText.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), Strings.LOGIN_PAGE_URL);

    }

    @Test
    public void TC_003LogInWithInvalidPasswordCredentials() {

        logInPage.enterUsername(Strings.VALID_USERNAME);
        logInPage.enterPassword(Strings.INVALID_PASSWORD);
        logInPage.clickLoginButton();
        Assert.assertTrue(logInPage.errorMessageText.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), Strings.LOGIN_PAGE_URL);

    }

    @Test
    public void TC_004LogInWithInvalidUsernameAndPasswordCredentials() {

        logInPage.enterUsername(Strings.INVALID_USERNAME);
        logInPage.enterPassword(Strings.INVALID_PASSWORD);
        logInPage.clickLoginButton();
        Assert.assertTrue(logInPage.errorMessageText.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), Strings.LOGIN_PAGE_URL);
    }

    @Test
    public void TC_005LogInWithoutInputCredentials() {

        logInPage.enterUsername(Strings.EMPTY_CREDS_USERNAME);
        logInPage.enterPassword(Strings.EMPTY_CREDS_PASSWORD);
        logInPage.clickLoginButton();
        Assert.assertTrue(logInPage.errorMessageText.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), Strings.LOGIN_PAGE_URL);
        Assert.assertEquals(logInPage.getTextFromErrorMessage(),Strings.LOGIN_ERROR_MESSAGE_EMPTY_FIELDS);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
