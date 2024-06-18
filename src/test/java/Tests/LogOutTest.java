package Tests;

import Base.BaseTest;
import Base.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void TC_006logOutTest() throws InterruptedException {
        logIn();
        sidebarPage.clickBurgerMenu();
        wait.until(ExpectedConditions.visibilityOf(sidebarPage.logoutButton));
        sidebarPage.clickLogoutButton();

        Assert.assertEquals(driver.getCurrentUrl(),Strings.LOGIN_PAGE_URL);
        Assert.assertTrue(logInPage.getLoginButton().isDisplayed());
    }
}
