package Tests;

import Base.BaseTest;
import Base.Strings;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChackOutTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        logIn();
    }

    @Test
    public void checkoutWithoutLastNameCred() {
        inventoryPage.clickOnBacpack();
        inventoryPage.clickOnOnesie();
        sidebarPage.clickCartIcon();
        cartPage.clickOnCheckOutButton();
        yourInformationPage.inputFirstName(Strings.FIRST_NAME);
        yourInformationPage.inputZipCode(Strings.ZIP_CODE);
        yourInformationPage.clickContinueButton();


        Assert.assertEquals(yourInformationPage.getTextFromErrorMessage(),Strings.ERROR_LASTNAME_CHECKOUT_MESSAGE);
        Assert.assertEquals(driver.getCurrentUrl(), Strings.CHECKOUT_PAGE_URL);
    }
    @Test
    public void checkoutWithoutFirstName(){
        inventoryPage.clickOnBacpack();
        inventoryPage.clickOnOnesie();
        sidebarPage.clickCartIcon();
        cartPage.clickOnCheckOutButton();
        yourInformationPage.inputLastName(Strings.LAST_NAME);
        yourInformationPage.inputZipCode(Strings.ZIP_CODE);
        yourInformationPage.clickContinueButton();

        Assert.assertEquals(yourInformationPage.getTextFromErrorMessage(), Strings.ERROR_FIRSTNAME_CHECKOUT_MESSAGE);
        Assert.assertEquals(driver.getCurrentUrl(), Strings.CHECKOUT_PAGE_URL);

    }
    @Test
    public void checkoutWithoutZipCode(){
        inventoryPage.clickOnBacpack();
        inventoryPage.clickOnOnesie();
        sidebarPage.clickCartIcon();
        cartPage.clickOnCheckOutButton();
        yourInformationPage.inputFirstName(Strings.FIRST_NAME);
        yourInformationPage.inputLastName(Strings.LAST_NAME);
        yourInformationPage.clickContinueButton();

        Assert.assertEquals(yourInformationPage.getTextFromErrorMessage(), Strings.ERROR_ZIPPOSTALCODE_CHECOUT_MESSAGE);
        Assert.assertEquals(driver.getCurrentUrl(), Strings.CHECKOUT_PAGE_URL);
    }



    @AfterMethod
    public void resetAppAndLogout() {
        logOut();

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
