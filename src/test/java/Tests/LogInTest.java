package Tests;

import Base.BaseTest;
import Base.Strings;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void TC_001LoginWithValidCredentials(){
    logInPage.enterUsername(Strings.VALID_USERNAME);
    logInPage.enterPassword(Strings.VALID_PASSWORD);
    logInPage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),Strings.INVENTORY_PAGE_URL);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
