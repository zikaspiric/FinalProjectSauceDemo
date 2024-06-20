package Tests;

import Base.BaseTest;
import Base.Strings;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void TC_007buyingTwoItems(){
        logIn();
        inventoryPage.clickOnBacpack();
        inventoryPage.clickOnOnesie();
        sidebarPage.clickCartIcon();
        cartPage.clickOnCheckOutButton();
        yourInformationPage.inputFirstName(Strings.FIRST_NAME);
        yourInformationPage.inputLastName(Strings.LAST_NAME);
        yourInformationPage.inputZipCode(Strings.ZIP_CODE);
        yourInformationPage.clickContinueButton();
        overViewPage.clickOnFinishButton();
        completePage.clickOnBackHomeButton();

        Assert.assertEquals(driver.getCurrentUrl(),Strings.INVENTORY_PAGE_URL);
        Assert.assertTrue(inventoryPage.backpackItem.isDisplayed());

    }
    @AfterMethod
    public void resetAppAndLogout(){
        logOut();
    }
}
