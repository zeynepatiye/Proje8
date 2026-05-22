package Tests;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Testler extends BaseDriver{
    @Test(priority = 1)
    public void RegisterTesti(){
        Elements elements=new Elements();
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");

        elements.genderFemale.click();
        elements.firstName.sendKeys("selen");
        elements.lastName.sendKeys("testici");
        elements.email.sendKeys("selen.testici"+dt.format(format)+ "@gmail.com");
        elements.password.sendKeys("123123");
        elements.confirmPassword.sendKeys("123123");
        elements.registerButton.click();
        bekle.until(ExpectedConditions.elementToBeClickable(elements.dogrulama));
        elements.dogrulama.click();
        bekle.until(ExpectedConditions.visibilityOf(elements.registerAssert));
        Assert.assertEquals(elements.registerAssert.getText(), "Your registration completed", "Hatalı register uygulaması.");




    }
}
