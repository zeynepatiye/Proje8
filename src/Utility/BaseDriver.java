package Utility;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait bekle;

    @BeforeClass
    public void Setup() {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("allow-insecure-localhost");
        options.addArguments("acceptInsecureCerts");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);


//        ChromeOptions options = new ChromeOptions();
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("credentials_enable_service", false);              // şifre yöneticisi kapalı
//        prefs.put("profile.password_manager_enabled", false);        // kayıt popup kapalı
//        prefs.put("profile.password_manager_leak_detection", false); // "şifren sızdı değiştir" uyarısı kapalı
//
//        options.setExperimentalOption("prefs", prefs);
//        driver = new EdgeDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 30 sn mühlet: sayfayı yükleme mühleti
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 sn mühlet: elementi bulma mühleti
        bekle = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }


    // hafızada kalmış, Selenium açtığı boştaki tarayıcıları temizler
    public static void KalanOncekileriKapat() {
        try {  // aga komuta bak.. cmd den taskkill yapıyu Runtime.getRuntime().exec("taskkill /f /im Kalanononcekileri");
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {
        }
    }

    public static void Consent(){
        // Consent buttonu bulurken list<> web elements olarak buluyoruz.. Çünkü tek elemanı bulamayabilir. Bulamazsa hata bverir..
        List<WebElement> ConsentButton=driver.findElements(By.xpath("//*[text()='Consent']"));
        if (ConsentButton.size()>0)     // Consent ekranda gözüktüyse
            ConsentButton.get(0).click();

    }
    public static void BekleKapat()
    {
        MyFunc.bekle(3);
        driver.quit();
    }
}
