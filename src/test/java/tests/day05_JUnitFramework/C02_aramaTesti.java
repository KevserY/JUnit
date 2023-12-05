package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_aramaTesti {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- testotomasyonu.com anasayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='search-input']"));

        //3- “phone” ile arama yapalim
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // // 2. yol --> aramaKutusu.submit(); de yapabiliriz.

        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi = driver.findElement(By.className("product-count-text"));
        System.out.println("Arama sonucu: " + sonucSayisi.getText());

        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//div[@class='product-box my-2  py-1'])[1]")).click();

        //6- Urunun stokta var oldugunu test edin
        WebElement urunStokBilgisi = driver.findElement(By.xpath("(//span[@class='heading-xs '])[1]"));
        String expectedUrunStokDurumu = "Availibility: In Stock";
        String actualUrunStokDurumu = urunStokBilgisi.getText();

        if (expectedUrunStokDurumu.equals(actualUrunStokDurumu)) {
            System.out.println("Ürün Stok Testi: PASSED");
        }else{
            System.out.println("Ürün Stok Testi: FAILED");
        }


        System.out.println(urunStokBilgisi.getText());

        Thread.sleep(2000);
        driver.quit();





    }
}
