package tests.day13_excelOtomasyon_getScreenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_AranaTestiWebelementScreenshot extends TestBase {
    @Test
    public void urunDogrulamaTesti() {
        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // shoes icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("shoes" + Keys.ENTER);

        // arama sonuclarindan ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();

        // acilan urun sayfasinda, urun isminde case sensitive olmadan "shoe" gectigini test edin
        WebElement urunIsimelementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String expectedIsimIcerik = "shoes";
        String actualIsimKucukHarf = urunIsimelementi.getText().toLowerCase();
        Assert.assertTrue(actualIsimKucukHarf.contains(expectedIsimIcerik));

        // urun isim elementinin fotografini cekip kaydedin

        // reusable methods da var olan bir method kullanıldı.








    }
}
