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
        driver.manage().window().maximize();//ovde setujemo da se windows maximizira
        driver.get("https://www.saucedemo.com/");//ovde na koji sajt da nas odvede
        logIn();//ovo je logIn metoda napravljena da olaksa pisanje testa
    }
    @Test
    public void TC_011checkoutWithoutLastNameCred() {//posto smo ulogovani idemo na sl korake
        inventoryPage.clickOnBacpack();//iz ovog "Page" pozivamo koji Webelement da klikne
        inventoryPage.clickOnOnesie();
        sidebarPage.clickCartIcon();
        cartPage.clickOnCheckOutButton();
        yourInformationPage.inputFirstName(Strings.FIRST_NAME);//ovde upisujemo neke inpute
        yourInformationPage.inputZipCode(Strings.ZIP_CODE);
        yourInformationPage.clickContinueButton();
    //ovde asertujemo tj uporedjujemo da li text ovog elementa je jednak nasem nekom textu
        Assert.assertEquals(yourInformationPage.getTextFromErrorMessage(),Strings.ERROR_LASTNAME_CHECKOUT_MESSAGE);
        Assert.assertEquals(driver.getCurrentUrl(), Strings.CHECKOUT_PAGE_URL);
        //ovde assertujemo da li je trenutni URL jednak zapisu mog URLa
    }
    @Test
    public void TC_012checkoutWithoutFirstName(){
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
    public void TC_013checkoutWithoutZipCode(){
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
    public void resetAppAndLogout() {//ovde imam metodu u kojoj prvo resetujem app i onda radim logOut
        logOut();//ova metoda je u BaseTestu i posto je extendovana u ovoj klasi ne moram da je lociram sa nekom klasom.
    }
}
