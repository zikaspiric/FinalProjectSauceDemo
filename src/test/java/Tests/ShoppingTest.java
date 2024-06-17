package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void buyingTwoItems(){
        logIn();
        inventoryPage.clickOnBacpack();
        inventoryPage.clickOnOnesie();
        sidebarPage.clickCartIcon();
        cartPage.clickOnCheckOutButton();



    }

}
