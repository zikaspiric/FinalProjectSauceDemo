package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;//ovde pisem ime objekta
    public WebDriverWait wait;
    public LogInPage logInPage;
    public SidebarPage sidebarPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public YourInformationPage yourInformationPage;
    public OverViewPage overViewPage;
    public CompletePage completePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();//ovo je osnovno setovanje browser-a
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));//ovde inicijalizujem objekat za wait
        driver = new ChromeDriver();
        logInPage = new LogInPage();
        sidebarPage = new SidebarPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        yourInformationPage = new YourInformationPage();
        overViewPage = new OverViewPage();
        completePage = new CompletePage();

    }

    public void logIn() {//metoda za logovanje

// iz koje klase dolazi. WebElement (Klasa.Konstanca);
        logInPage.enterUsername(Strings.VALID_USERNAME);
        logInPage.enterPassword(Strings.VALID_PASSWORD);
        logInPage.clickLoginButton();

    }

    public void logOut() {
        sidebarPage.clickBurgerMenu();
        wait.until(ExpectedConditions.visibilityOf(sidebarPage.logoutButton));
        sidebarPage.clickResetAppState();
        sidebarPage.clickLogoutButton();

    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);


    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
