package Tests;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    @Test(priority = 2)
    public void LoginTest()
    {
        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("selen.testici@gmail.com");
        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("123123");
        WebElement loginBtn= driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        loginBtn.click();

    }


    @Test (priority = 3)
    public void DataProviderLogInTest (){






    }
    @Test (priority = 4)
    public void TabMenuTest (){






    }
    @Test (priority = 5)
    public void OrderGiftsTest (){






    }
    @Test (priority = 6)
    public void OrderComputerTest (){






    }
    @Test (priority = 7)
    public void ParametreliSearchTest (){






    }
}
