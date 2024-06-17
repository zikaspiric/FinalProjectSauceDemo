package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;
    @FindBy(className = "shopping_cart_link")
    public WebElement cartIcon;
    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppState;

    public WebElement getCartIcon() {
        return cartIcon;
    }
    //---------------------------------

    public void clickBurgerMenu(){
        burgerMenu.click();
    }
    public void clickLogoutButton(){
        logoutButton.click();
    }
    public void clickCartIcon(){
        cartIcon.click();
    }
    public void clickResetAppState(){
        resetAppState.click();
    }
    public String getNumberFromShoppingCartIcon(){
        return cartIcon.getText();
    }
}
