package Tests;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testler extends BaseDriver {
    Elements elements = new Elements();

    @Test(priority = 1)
    public void RegisterTest() {
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");

        elements.genderFemale.click();
        elements.firstName.sendKeys("test");
        elements.lastName.sendKeys("kullanicisi");
        elements.email.sendKeys("testkullanicisi" + dt.format(format) + "@gmail.com");
        elements.password.sendKeys("123456");
        elements.confirmPassword.sendKeys("123456");
        elements.registerButton.click();
        bekle.until(ExpectedConditions.elementToBeClickable(elements.dogrulama));
        elements.dogrulama.click();
        bekle.until(ExpectedConditions.visibilityOf(elements.registerAssert));
        Assert.assertEquals(elements.registerAssert.getText(), "Your registration completed", "Hatalı register uygulaması.");
        BekleKapat();


    }

    @Test(dependsOnMethods = {"RegisterTest"})
    public void LoginTest() {
        MyFunc.bekle(10); // bot için kullanıldı
        elements.email.sendKeys("testkullanicisi@gmail.com");
        elements.password.sendKeys("123456");
        elements.logInBtn.click();
        BekleKapat();

    }


    @Test(dataProvider = "datalarim", dependsOnMethods = {"LoginTest"})
    public void DataProviderLoginTest(String emailAdresi, String sifre, boolean esittir) {
        MyFunc.bekle(10); // bot için kullanıldı
        elements.email.clear();
        elements.email.sendKeys(emailAdresi);
        elements.password.clear();
        elements.password.sendKeys(sifre);
        elements.logInBtn.click();

        if (esittir) {
            Assert.assertTrue(elements.logOut.isDisplayed(), "Giriş başarılı!");
        } else {
            Assert.assertTrue(elements.errorMsg.getText().contains("Login was unsuccessful"), "Giriş başarısız!");
        }
        BekleKapat();
    }

    @DataProvider
    public Object[][] datalarim() {

        Object[][] loginVerileri = {
                {"testkullanicisi@gmail.com", "123456", true},        // Geçerli veri
                {"gecersiz_email@gmail.com", "yanlis123", false}  // Geçersiz veri
        };

        return loginVerileri;
    }


    @Test(dependsOnMethods = {"DataProviderLoginTest"})
    public void TabMenuTest() {
        MyFunc.bekle(15); // bot için yapıldı
        List<String> olusanTabMenu = new ArrayList<>();
        for (WebElement element : elements.tabMenu) {
            olusanTabMenu.add(element.getText().trim());
        }
        List<String> beklenenTabMenu = Arrays.asList(
                "Computers",
                "Electronics",
                "Apparel",
                "Digital downloads",
                "Books",
                "Jewelry",
                "Gift Cards"
        );
        Assert.assertEquals(olusanTabMenu, beklenenTabMenu, "Tab menüdeki oluşan ürün isimleri beklendiği gibi değil.");
        BekleKapat();
    }

    @Test(dependsOnMethods = {"TabMenuTest"})
    public void OrderGiftsTest() {
        Elements elements = new Elements();
        elements.giftCard.click();
        int rndSayi = MyFunc.randomSayiUret(elements.physicalGiftsList.size() - 1);//0,1,2,3
        String secilenUrunAdi = elements.physicalGiftsList.get(rndSayi).getText(); // ürün adı alındı
        elements.addToCartBtn.get(rndSayi).click();//Seçilen ürünün add to cart butonuna tıklattım
        elements.recipientName.sendKeys("Test1");
        elements.senderName.sendKeys("Test2");
        elements.giftCardmessage.sendKeys("testtesttesttesttest");
        bekle.until(ExpectedConditions.elementToBeClickable(elements.addToCartSend)).click();
        elements.shoppingCart.click();
        boolean bulundu = false;
        for (WebElement urun : elements.physicalGiftsList)
            if (urun.getText().equals(secilenUrunAdi)) {
                bulundu = true;
                break;
            }

        if (!bulundu)
            Assert.fail("Add To Cart'a eklenen ürün listede bulunamadı.");
        BekleKapat();
    }


    @Test(dependsOnMethods = {"OrderGiftsTest"})
    public void OrderComputerTest() {
        Actions actions = new Actions(driver);
        actions.moveToElement(elements.computers).perform();
        Select cmpDropdown=new Select(elements.computersDropdown);
        cmpDropdown.selectByVisibleText("desktops");
        elements.desktops.click();
        elements.buYourOwnComp.click();
        Select ramSelect = new Select(elements.randomRam);
        List<WebElement> ramOptions = ramSelect.getOptions();
        int randomRamIndex = MyFunc.randomSayiUret(ramOptions.size() - 1) + 1;
        ramSelect.selectByIndex(randomRamIndex);
        List<WebElement> hddOptions = elements.hddRadioButtons;
        int randomHddIndex = MyFunc.randomSayiUret(hddOptions.size());
        hddOptions.get(randomHddIndex).click();
        elements.addToCartComputer.click();
        Assert.assertTrue(elements.computerTestDogrulama.isDisplayed(), "Ürün sepete eklenemedi.");
        BekleKapat();
    }

    @Test(dependsOnMethods = {"OrderComputerTest"})
    public void ParametreliSearchTest() {

        BekleKapat();

    }
}


