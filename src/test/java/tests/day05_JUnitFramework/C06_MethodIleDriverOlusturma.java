package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C06_MethodIleDriverOlusturma {

    WebDriver driver;

    public void driverOlustur() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void wisequarterTest() {
        driverOlustur();
        driver.get("https://www.wisequarter.com");
        // title'ın "Wise" içerdiğini test edin
        String exceptedTitleIcerik = "Wise";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(exceptedTitleIcerik)) {
            System.out.println("Wise Quarter Testi PASSED");
        } else System.out.println("Wise Quarter Testi FAILED");
        ReusableMethods.bekle(1);
        driver.quit();
    }

    @Test
    public void testOtomasyonuTest() {
        driverOlustur();
        // testotomasyonu.com aderesine gidin
        driver.get("https://www.testotomasyonu.com");
        // title'ın "Test Otomasyon" içerdiğini test edin
        String exceptedTitleIcerik = "Test Otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(exceptedTitleIcerik)) {
            System.out.println("Test Otomasyon Testi PASSED");
        } else System.out.println("Test Otomasyon Testi FAILED");
        ReusableMethods.bekle(1);
        driver.quit();
    }

    @Test
    public void googleTest() {
        driverOlustur();
        // google.com aderesine gidin
        driver.get("https://www.google.com");
        // URL'in "google" içerdiğini test edin
        String exceptedUrlIcerik = "google";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(exceptedUrlIcerik)) {
            System.out.println("Google Testi PASSED");
        } else System.out.println("Google Testi FAILED");
        ReusableMethods.bekle(1);
        driver.quit();
    }
}


