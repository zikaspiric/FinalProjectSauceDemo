package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public LogInPage logInPage;
    public SidebarPage sidebarPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver = new ChromeDriver();
        logInPage = new LogInPage();
        sidebarPage = new SidebarPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();

    }
    public void logIn(){

        logInPage.enterUsername(Strings.VALID_USERNAME);
        logInPage.enterPassword(Strings.VALID_PASSWORD);
        logInPage.clickLoginButton();

    }
    public void logOut(){
        sidebarPage.clickBurgerMenu();
        wait.until(ExpectedConditions.visibilityOf(sidebarPage.logoutButton));
        sidebarPage.clickResetAppState();
        sidebarPage.clickLogoutButton();

    }


}
