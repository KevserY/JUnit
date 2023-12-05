package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_BeforeAfterNotasyonlari {
    // 3 farklı test methodu oluşturarak aşağıdaki testleri yapın:
    // 1- testotomasyonu.com gidin
    // 2- phone, shoes, dress için arama yapın (her ürün için ayrı method oluşturulacak)
    // 3- arama sonucunda ürün bulunabildiğini test edin
    // 4- sayfayı kapatın.


    // driver için gerekli ayarlamaları yapıyoruz.
    WebDriver driver;//driver oluşturmayı class seviyesinde yapıyoruz.

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup(); // WebDriver-Bonigarcia'dan ChromeDriver setup'ları yapıyoruz.
        driver = new ChromeDriver();//class'da oluşturduğumuz driver objesine atamayı method içinde yapıyoruz.
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown() {

        driver.quit();
    }

    @Test
    public void phoneTesti() {
        // 1- testotomasyonu.com gidin
        driver.get("https://www.testotomasyonu.com");
        // 2- phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // 3- arama sonucunda ürün bulunabildiğini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String aramaSonucElementiSTR = aramaSonucElementi.getText().replaceAll("\\D", ""); //rakam olmayan tüm karakterler gitti."4" kaldı.
        int aramaSonucElementiINT = Integer.parseInt(aramaSonucElementiSTR);

        if (aramaSonucElementiINT > 0) {
            System.out.println("phone testi PASSED");
        } else {
            System.out.println("phone testi FAILED");
            throw new AssertionFailedError();
        }


    }

    @Test
    public void shoesTesti() {
        // 1- testotomasyonu.com gidin
        driver.get("https://www.testotomasyonu.com");
        // 2- shoes için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("shoes" + Keys.ENTER);
        // 3- arama sonucunda ürün bulunabildiğini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String aramaSonucElementiSTR = aramaSonucElementi.getText().replaceAll("\\D", "");
        int aramaSonucElementiINT = Integer.parseInt(aramaSonucElementiSTR);

        if (aramaSonucElementiINT > 0) {
            System.out.println("shoes testi PASSED");
        } else {
            System.out.println("shoes testi FAILED");
            throw new AssertionFailedError();
        }


    }

    @Test
    public void dressTesti() {
        // 1- testotomasyonu.com gidin
        driver.get("https://www.testotomasyonu.com");
        // 2- dress için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress" + Keys.ENTER);
        // 3- arama sonucunda ürün bulunabildiğini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String aramaSonucElementiSTR = aramaSonucElementi.getText().replaceAll("\\D", "");
        int aramaSonucElementiINT = Integer.parseInt(aramaSonucElementiSTR);

        if (aramaSonucElementiINT > 0) {
            System.out.println("dress testi PASSED");
        } else {
            System.out.println("dress testi FAILED");
            throw new AssertionFailedError();
        }

    }
}
