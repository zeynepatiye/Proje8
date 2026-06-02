package Tests;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Testler extends BaseDriver{
  //  Elements elements=new Elements();
//    @Test(priority = 1)
//    public void RegisterTesti(){
//        Elements elements=new Elements();
//        LocalDateTime dt = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
////
//        elements.genderFemale.click();
//        elements.firstName.sendKeys("selen");
//        elements.lastName.sendKeys("testici");
//        elements.email.sendKeys("selen.testici"+dt.format(format)+ "@gmail.com");
//        elements.password.sendKeys("123123");
//        elements.confirmPassword.sendKeys("123123");
//        elements.registerButton.click();
//        bekle.until(ExpectedConditions.elementToBeClickable(elements.dogrulama));
//        elements.dogrulama.click();
//        bekle.until(ExpectedConditions.visibilityOf(elements.registerAssert));
//        Assert.assertEquals(elements.registerAssert.getText(), "Your registration completed", "Hatalı register uygulaması.");
//



//    }
    @Test(priority = 2)
    public void LoginTest()
    {
        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("sevgidereli@gmail.com");
        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("123456");
        WebElement loginBtn= driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        loginBtn.click();
        BekleKapat();

    }


    @Test(dataProvider = "datalarim" , priority = 3)//priority ??
    public void DataProviderTest(){
     Elements elements=new Elements();
        elements.logInBtn.click();
        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("sevgidereli@gmail.com");
        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("123456");
    }

//    public void DataProviderLogInTest(String email, String password)
//    {
//
//        System.out.println(email+" - "+password+" ");
//        BekleKapat();
//    }

//     Login butonuna tıklayınız
// Geçerli ve geçersiz Email ve password’u Data Provider metodundan aliniz
// LOG IN butonunna tıklayınız
// başarılı bir şekilde login olup olmadığınızı doğrulayınız.


    @Test(dataProvider = "datalarim")
    public void DataProviderLoginTest(String emailAdresi, String sifre, boolean isSuccess) {

        MyFunc.bekle(10);

        WebElement email = driver.findElement(By.id("Email"));
        email.clear();
        email.sendKeys(emailAdresi);

        WebElement password = driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys(sifre);

        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginBtn.click();

        if (isSuccess) {
            WebElement logoutBtn = driver.findElement(By.className("ico-logout"));
            Assert.assertTrue(logoutBtn.isDisplayed(), "Giriş başarılı!");
        } else {
            WebElement errorMsg = driver.findElement(By.cssSelector(".message-error"));
            Assert.assertTrue(errorMsg.getText().contains("Login was unsuccessful"), "Giriş başarısız!");
        }
    }

    @DataProvider
    public Object[][] datalarim() {

        Object[][] loginVerileri = {
                {"sevgidereli@gmail.com", "123456", true},        // Geçerli veri
                {"gecersiz_email@gmail.com", "yanlis123", false}  // Geçersiz veri
        };

        return loginVerileri;
    }
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




        BekleKapat();

    }

}
