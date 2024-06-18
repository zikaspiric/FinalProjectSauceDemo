package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverViewPage extends BaseTest {

    public OverViewPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    WebElement finishButton;

    //--------------------------------------------

    public void clickOnOverViewPage(){
        finishButton.click();
    }
}

