package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C05_TestNotasyonu {

    // bir class içinde birden fazla bağımsız çalışabilen test olur mu?
    // JUnit ile çalışırken,
    // class'da birden fazla test olduğunda
    // toplu çalıştırdığımız zaman -!- hangi sırayla çalışacağını bilemeyiz, kontrol edemeyiz -!-


    @Test
    public void testOtomasyonuTest() { // test methodları static olmamalıdır -!!!-

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
    public void wisequarterTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // wisequarter.com aderesine gidin
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
    public void googleTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
