package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClass_AfterClass {
    //    3 farklı test methodu oluşturarak aşağıda verilen görevi tamamlayın:

    // 1- testotomasyonu.com sayfasına gidip
    //    url'in test otomasyonu içerdiğini test edin

    // 2- phone için arama yaptırın
    //    arama sonucunda ürün bulunabildiğini test edin.

    // 3- ilk ürüne tıklayın
    //    ürün açıklamasında case sensitive olmadan phone geçtiğini test edin

            /*
            Bu görevlerin sağlıklı olarak yapılabilmesi için:
            1- test methodlarının doğru sırada çalışması gerekir.
            2- driver objesi tüm methodlardan önce oluşturulmalı
              - ve tüm methodlar çalıştıktan sonra kapatılmalıdır.

            Bunu sağlayabilmek için @BeforeClass ve @AfterClass notasyonları kullanırız
            ANCAK dikkat etmemiz gereken konu
            bu notasyonları kullanan methodlar ***static*** OLMAK ZORUNDADIR !!!
            */


    static WebDriver driver;

    @BeforeClass // classın başında 1 kez çalışır. herbir testten önce ayrı ayrı çalışmaz.
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public  void test01() {
        // testotomasyonu.com sayfasına gidip
        driver.get("https://www.testotomasyonu.com");

        // url'in test otomasyonu içerdiğini test edin
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("URL testi PASSED");
        } else {
            System.out.println("URL testi FAILED");
            throw new AssertionFailedError();
        }

    }

    @Test
    public void test02() {
        // phone için arama yaptırın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // arama sonucunda ürün bulunabildiğini test edin.
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String aramaSonucElementiSTR = aramaSonucElementi.getText().replaceAll("\\D", "");
        int aramaSonucElementiINT = Integer.parseInt(aramaSonucElementiSTR);

        if (aramaSonucElementiINT > 0) {
            System.out.println("phone testi PASSED");
        } else {
            System.out.println("phone testi FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void test03() {
        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();
        // ürün açıklamasında case sensitive olmadan "phone" geçtiğini test edin
        WebElement urunAciklamasi = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));

        String expectedUrunAciklama = "phone";
        String actualUrunAciklamasi = urunAciklamasi.getText().toLowerCase();

        if (actualUrunAciklamasi.contains(expectedUrunAciklama)) {
            System.out.println("ürün açıklaması testi PASSED");
        } else {
            System.out.println("ürün açıklaması testi FAILED");
            throw new AssertionFailedError();
        }
    }



}
