package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C07_BeforeAfterNotasyonları {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void wisequarterTest() {

        driver.get("https://www.wisequarter.com");
        // title'ın "Wise" içerdiğini test edin
        String exceptedTitleIcerik = "Wise";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(exceptedTitleIcerik)) {
            System.out.println("Wise Quarter Testi PASSED");
        } else System.out.println("Wise Quarter Testi FAILED");
        ReusableMethods.bekle(1);

    }

    @Test
    public void testOtomasyonuTest() {
        /*
            JUnit bir test method'u hiçbir sorunla karşılaşmadan biterse
            o test methodunu PASSED olarak algılar

            JUnit'e göre bir testin FAILED olabilmesi için
            kodların bir sorunla karşılaşması ve
            kodların methodun sonuna kadar çalışmaması gerekir.

            Örenek olması için biz bu method'da
            throw new AssertionFailedError(); // doğrulama FAILED
            diyerek, test failed olduğunda kodun çalışmayı durdurmasını sağladık.

            JUnit
            bu testi FAILED olarak etiketledik.


         */
        // testotomasyonu.com aderesine gidin
        driver.get("https://www.testotomasyonu.com");

        // title'ın "Test Otomasyon" içerdiğini test edin
        String exceptedTitleIcerik = "google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(exceptedTitleIcerik)) {
            System.out.println("Test Otomasyon Testi PASSED");
        } else {
            System.out.println("Test Otomasyon Testi FAILED");
            throw new AssertionFailedError(); // doğrulama FAILED
        }
        ReusableMethods.bekle(1);

    }

    @Test @Ignore // geçici bir süre için bu testin çalışmasını istemediğimiz zamanlarda ""@Ignore"" ekleriz.--yoksay-- (test ignored)
    public void googleTest() {

        // google.com aderesine gidin
        driver.get("https://www.google.com");
        // URL'in "google" içerdiğini test edin
        String exceptedUrlIcerik = "google";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(exceptedUrlIcerik)) {
            System.out.println("Google Testi PASSED");
        } else System.out.println("Google Testi FAILED");
        ReusableMethods.bekle(1);

    }


}
