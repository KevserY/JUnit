package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

    /*
            Bize verilen görevde birden fazla assertion varsa,
            tümünü tek test method'unda yapmak
            bize iş yükü açısından daha pratik gelebilir.
            AMAAAAAAA....
            bir test methodunda birden fazla assertion olduğunda
     */

    // farkli test method’lari olusturarak asagidaki testleri yapin
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // https://www.bestbuy.com/ Adresine gidin
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void urlTesti() {
    /*
                Testlerin yapılma sırası bu görevde önemli olmadığı için
                test01, test02.. gibi isimlendirmek yerine,
                test içeriğine göre isimlendirmek daha uygun olacaktır.

                JUnit'de sıralama nasıl olacak bilmediğimiz için
                adrese gitme görevini @BeforeClass'da yaptık.

                Testin başında bir kez adrese gitmek yeterli olacaktır.
    */
        // 1- Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
        String excpectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(excpectedUrl,actualUrl);
    }

    @Test
    public void titleTesti() {
        // 2- TitleTest => Sayfa başlığının “Rest” içerMEdiğini! (contains) test edin
        String unExpectedTitle = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(unExpectedTitle));
    }

    @Test
    public void logoTesti() {
        // 3- logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("//*[@class='logo']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void dilTesti() {
        // 4- FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement dilFr = driver.findElement(By.xpath("//button[@*='fr']"));
        Assert.assertTrue(dilFr.isDisplayed());
    }
/*
            Bize verilen görevde birden fazla Assertion varsa,
            tümünü tek bir test methodu içinde yapmak
            bize iş yükü açısından daha pratik gelebilir

            AMAAAA...
            bir test methodu içinde birden fazla assertion olduğunda,
            - her bir assertion ayrı ayrı raporlanmamış olur,
            - bir assertion failed olduğunda kod çalışması durur
              ve kalan assertionların test sonucunu bilemeyiz.
              Önce hata veren assertion'ı düzeltip sonra tekrar çalıştırmamız gerekir.
 */




















}