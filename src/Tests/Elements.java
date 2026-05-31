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
    @FindBy(css= "[type='checkbox']")
    public WebElement dogrulama;
    @FindBy(className = "button-1 register-continue-button")
    public WebElement continueButton;
    @FindBy(className = "ico-logout")
    public WebElement logOut    ;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement logInBtn;
    @FindBy (className = "menu")
    public List<WebElement> Tabmenu;
//    @FindBy(xpath = "//*[contains(text(), 'Computers' )]")
//    public WebElement compLst;
//    @FindBy (xpath = "//*[contains(text(), 'Computers' )]")
//    public List<WebElement> compLst1;
    @FindBy (linkText = "Gift Cards")
    public WebElement giftCard;
    @FindBy(id = "giftcard_42_RecipientName")
    public WebElement recieptName;
    @FindBy(id = "giftcard_42_RecipientEmail")
    public WebElement recieptEmail;

    @FindBy(id = "giftcard_42_Message")
    public WebElement message;
    @FindBy(id = "add-to-cart-button-42")
    public WebElement addToCart;
    @FindBy(linkText = "shopping cart")
    public WebElement shoppingCart;
    @FindBy(linkText= "Desktops")
    public WebElement desktops;
    @FindBy(linkText= "Build your own computer")
    public WebElement buYourOwnComp;
    @FindBy(id= "product_attribute_2")
    public WebElement ram;
    @FindBy(id= "product_attribute_3_6")
    public WebElement hdd320;
    @FindBy(id= "product_attribute_3_7")
    public WebElement hdd400;
    @FindBy(id = "add-to-cart-button-1")
    public WebElement addToCart1;
    @FindBy(xpath = "//table/tbody/tr[2]/td[3]/a")
    public WebElement builderOnPc;
    @FindBy(id = "small-searchterms")
    public WebElement searchBtn;
    @FindBy(xpath = "article>div+div>h2>a")
    public WebElement adobePhotoshop;




  }
