package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_GoogleAramaTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
                    // cookies yok :)
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title Testi PASSED");
        } else {
            System.out.println("FAILED");
        }

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu = driver.findElement(By.className("gLFyf"));
        aramaCubugu.sendKeys("Nutella" + Keys.ENTER);

        //6- Bulunan sonuc sayisini yazdirin
        WebElement nutellaAramaSonuc = driver.findElement(By.id("result-stats"));
        System.out.println("Arama sonucu: " + nutellaAramaSonuc.getText());

        String sonucYazisiStr = nutellaAramaSonuc.getText();
        //Arama sonucu: Yaklaşık 184.000.000 sonuç bulundu (0,28 saniye)
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

                    /*
                    String bir array oluşturup,
                    String'e atama yaptığımız sonucYazisiStr'ı " " boşluklardan ayırıyoruz.
                    184.000.000 sonucunun olduğu 1. index'i alacağız
                     */

        String[] sonucYazisiArr = sonucYazisiStr.split(" ");
        String sonucSayisiStr = sonucYazisiArr[1]; // 184.000.000 değerini, String sonucSayisiStr'a atama yaptık

                    //sonucSayisiStr'ı noktalardan kurtarıyoruz

        sonucSayisiStr = sonucSayisiStr.replaceAll("\\D", "");
                    // Digit olmayan herşeyi "" ->hiçlik yap
                    // 184000000 ---> son durum.
                    // ancak String olan bu değeri, Integer'a dönüştüreceğiz.

        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr);

        if (sonucSayisiInt > 10000000) {
            System.out.println("Nutella Arama Sonucu Test: PASSED");
        } else {
            System.out.println("FAILED");
        }
        //8- Sayfayi kapatin
        ReusableMethods.bekle(3);
        driver.quit();


    }
}
