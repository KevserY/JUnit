package tests.day04_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class C01_MavenIlkTest {
    public static void main(String[] args) throws InterruptedException {

        /*
                Mahşerin 4 atlısından ilki: webdriver ayarları yapmaktı.
                Ama bu adım mecburi değildir.

               Selenium 4.8 ile kendi webdriver'ını oluşturduğundan
                biz dışarıdan webdriver tanımlamasak da
               Selenium kendi driver'ını kullanacaktır.
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  https://www.testotomasyonu.com gidin
        driver.get("https://www.testotomasyonu.com");

        // url nin testotomasyonu içerdiğini test edin
        System.out.println(driver.getCurrentUrl());
        // https://www.testotomasyonu.com/ yazdırdı.

        // sayfayı kapatın
        Thread.sleep(2000);
        driver.quit();


    }
}
