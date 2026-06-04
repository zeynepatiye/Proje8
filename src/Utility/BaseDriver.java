package Utility;

import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait bekle;

    @BeforeClass
    public void Setup() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);              // şifre yöneticisi kapalı
        prefs.put("profile.password_manager_enabled", false);        // kayıt popup kapalı
        prefs.put("profile.password_manager_leak_detection", false); // "şifren sızdı değiştir" uyarısı kapalı

        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 30 sn mühlet: sayfayı yükleme mühleti
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 sn mühlet: elementi bulma mühleti
        bekle = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @AfterClass
    public void BekleKapat() {
        MyFunc.bekle(3);
        driver.quit();
    }

}
