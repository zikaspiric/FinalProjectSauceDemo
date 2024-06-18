package Pages;

import Base.BaseTest;
import Base.Strings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BaseTest {

    public LogInPage() {
        PageFactory.initElements(driver, this);
    }

    //webelementi

    @FindBy(id = "user-name")
    public WebElement userNameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test = 'error']")
    public WebElement errorMessageText;

    public WebElement getLoginButton() {
        return loginButton;
    }
    //--------------------------------------------------------

    public void enterUsername(String userName) {
        userNameField.clear();
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String pass) {
        passwordField.clear();
        passwordField.sendKeys(pass);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public String getTextFromErrorMessage() {
        return errorMessageText.getText();
    }
}
