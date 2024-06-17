package Tests;

import Base.BaseTest;
import Base.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        logIn();
    }

    @Test
    public void TC_009AddTwoItemsAndVerifyCartIcon(){
        inventoryPage.clickOnBacpack();
        inventoryPage.clickOnOnesie();
        Assert.assertEquals(sidebarPage.getNumberFromShoppingCartIcon(),"2");


    }
    @Test
    public void TC_010RemoveBackpackItemVerifyCartIcon(){
        inventoryPage.clickOnBacpack();
        inventoryPage.clickOnOnesie();
        inventoryPage.clickRemoveBackpackItem();
        Assert.assertEquals(sidebarPage.getNumberFromShoppingCartIcon(),"1");
    }

    @AfterMethod
    public void resetAndLogout(){
        logOut();
    }


    @AfterClass
    public void tearDown(){
       driver.quit();
    }
}
