package tests.day09__________actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_Odev extends TestBase {
    /*
            Kontrolsuz bir tab/window acildiginda,
            eger yeni acilan tab/window'un title degeri biliniyorsa,
            driver'i acilan sayfaya geciren bir method olusturun

            input : yeniTitle , Test Otomasyonu - Electronics        */

    @Test
    public void test01() {

    // ● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

    // ● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h2"));
        String expectedYazi = "Add/Remove Elements";
        String actualYazi = yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

    // ● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    // ● ‘Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.linkText("Electronics Products")).click();

    // ● Electronics sayfasinin acildigini test edin
        driver =ReusableMethods.titleIleSayfaDegistir(driver, "Test Otomasyonu - Electronics");
        System.out.println(driver.getTitle());

    // ● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@class='product-count-text']"));
        String sonucSayisiStr = sonucYaziElementi.getText().replaceAll("\\D", "");
        int actualSonucSayisi = Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayisi = 16;

        Assert.assertEquals(expectedSonucSayisi,actualSonucSayisi);

    // ● Ilk actiginiz addremove sayfasina donun
        driver.navigate().to("https://testotomasyonu.com/addremove/");

    // ● Url’in addremove icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "addremove" ;

        Assert.assertTrue(actualUrl.contains(expectedUrl));


}
}