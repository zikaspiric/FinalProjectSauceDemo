package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage extends BaseTest {

    public CompletePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "back-to-products")
    public WebElement backHome;

    //---------------------------------------------------

    public void clickOnBackHomeButton(){
        backHome.click();
    }
}
