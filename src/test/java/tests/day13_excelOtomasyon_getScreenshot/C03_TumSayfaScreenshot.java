package tests.day13_excelOtomasyon_getScreenshot;

import com.sun.source.tree.AssertTree;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TumSayfaScreenshot extends TestBase {

    @Test
    public void aramaTesti() throws IOException {
        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Arama sonucunda urun bulunamadigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String expectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();
        Assert.assertEquals(expectedAramaSonucu,actualAramaSonucu);

        ReusableMethods.bekle(1);

        // tum sayfanin fotografini cekip kaydedin
        // 1. ADIM: tss objesi oluşturalım
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.ADIM: fotoğrafı kaydedeceğimiz dosya yolu ile bir File oluşturalım.
        File tumSayfaScreenshot = new File("target/screenshots/tumSayfaScreenshot.jpg");

        // 3.ADIM: tss objesini kullanarak foto çekip , geçici bir dosyaya kaydedelim.
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4:ADIM: geçiçi dosyayı asıl dosyaya kopyalıyalım
        FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);


        ReusableMethods.bekle(5);


    }
}
