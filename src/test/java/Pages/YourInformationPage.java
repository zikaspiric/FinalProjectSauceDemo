package Pages;

import Base.BaseTest;
import Base.Strings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage extends BaseTest {

    public YourInformationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    public WebElement firstNameField;
    @FindBy(id = "last-name")
    public WebElement lastNameField;
    @FindBy(id = "postal-code")
   public WebElement zipCodeInput;
    @FindBy(id = "continue")
   public WebElement continueButton;
    @FindBy(xpath = "//h3[@data-test = 'error']")
   public WebElement errorMessageCheckout;


    //-------------------------------------------
    public void inputFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void inputZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String getTextFromErrorMessage() {
        return errorMessageCheckout.getText();
    }
}
