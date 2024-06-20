package Tests;

import Base.BaseTest;
import Base.Strings;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SocialLinkTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void TC_008twiterLinkTest(){
        logIn();
    inventoryPage.clickTwiterButton();
        // ova metoda dohvata sve tabove ili prozore na drajveru
        ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());

        // ovime se prebacujemo na drugi tab
        driver.switchTo().window(tabs.get(1));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(),Strings.TWITER_URL);
           // ovo ubija aktivni prozor ili tab
         driver.close();
           // ova vraca na stari tab
        driver.switchTo().window(tabs.get(0));
        actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(driver.getCurrentUrl(), Strings.INVENTORY_PAGE_URL);
    }

    @Test
    public void TC_009facebookLinkTest(){
    logIn();
    inventoryPage.clickFacebookButton();
        // ova metoda dohvata sve tabove ili prozore na drajveru
        ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());

        // ovime se prebacujemo na drugi tab
        driver.switchTo().window(tabs.get(1));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(),Strings.FACEBOOK_URL);
        // ovo ubija aktivni prozor ili tab
        driver.close();
        // ova vraca na stari tab
        driver.switchTo().window(tabs.get(0));
        actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(driver.getCurrentUrl(), Strings.INVENTORY_PAGE_URL);
    }
    @Test
    public void TC_010linkedInTest(){
        logIn();
        inventoryPage.clickLinkedIndButton();

        // ova metoda dohvata sve tabove ili prozore na drajveru
        ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());

        // ovime se prebacujemo na drugi tab
        driver.switchTo().window(tabs.get(1));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(),Strings.LINKEDIN_URL);
        // ovo ubija aktivni prozor ili tab
        driver.close();
        // ova vraca na stari tab
        driver.switchTo().window(tabs.get(0));
        actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(driver.getCurrentUrl(), Strings.INVENTORY_PAGE_URL);
    }
    @AfterMethod
    public void resetAppAndLogout(){
        logOut();
    }
}
