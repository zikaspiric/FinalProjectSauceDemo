package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BaseTest {
    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backpackItem;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement onesieItem;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeFromCartBackPackButton;



    //-----------------------------------------------

    public void clickOnBacpack(){
        backpackItem.click();
    }
    public void clickOnOnesie(){
        onesieItem.click();
    }
    public void clickRemoveBackpackItem(){
        removeFromCartBackPackButton.click();
    }



}



