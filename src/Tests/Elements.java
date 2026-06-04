package Tests;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Elements {
    public Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(id = "gender-female")
    public WebElement genderFemale;
    @FindBy(id = "FirstName")
    public WebElement firstName;
    @FindBy(id = "LastName")
    public WebElement lastName;
    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;
    @FindBy(id = "register-button")
    public WebElement registerButton;
    @FindBy(className = "result")
    public WebElement registerAssert;
    @FindBy(css = "[type='checkbox']")
    public WebElement dogrulama;
    @FindBy(className = "button-1 register-continue-button")
    public WebElement continueButton;
    @FindBy(className = "ico-logout")
    public WebElement logOut;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement logInBtn;
//    @FindBy(xpath = "//table/tbody/tr[2]/td[3]/a")
//    public WebElement builderOnPc;
//    @FindBy(id = "small-searchterms")
//    public WebElement searchBtn;
//    @FindBy(xpath = "article>div+div>h2>a")
//    public WebElement adobePhotoshop;

    // sevgi
    @FindBy(css = "div[class='header-menu'] a[class='menu__link']")
    public List<WebElement> tabMenu;
    @FindBy(css = "[class='message-error']")
    public WebElement errorMsg;
    @FindBy(linkText = "Gift Cards")
    public WebElement giftCard;
    @FindBy(xpath = "//h2[@class='product-title']/a")
    public List<WebElement> physicalGiftsList;
    @FindBy(css = "[class='button-2 product-box-add-to-cart-button']")
    public List<WebElement> addToCartBtn;
    @FindBy(id = "giftcard_42_RecipientName")
    public WebElement recipientName;
    @FindBy(id = "giftcard_44_SenderName")
    public WebElement senderName;
    @FindBy(id = "giftcard_42_Message")
    public WebElement giftCardmessage;
    @FindBy(id = "add-to-cart-button-44")
    public WebElement addToCartSend;
    @FindBy(linkText = "shopping cart")
    public WebElement shoppingCart;
    @FindBy(linkText = "computers")
    public WebElement computers;
    @FindBy(linkText = "desktops")
    public WebElement desktops;
    @FindBy(css = "[class='menu__item-toggle']")
    public WebElement computersDropdown;
    @FindBy(linkText = "Build your own computer")
    public WebElement buYourOwnComp;
    @FindBy(id = "product_attribute_2")
    public WebElement randomRam;
    @FindBy(css = "input[name='product_attribute_3']")
    public List<WebElement> hddRadioButtons;
    @FindBy(id = "add-to-cart-button-1")
    public WebElement addToCartComputer;
    @FindBy(xpath = "//p[@class='content']")
    public WebElement computerTestDogrulama;



}
