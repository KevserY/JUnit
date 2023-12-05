package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C06_KontroSuzCokluWindowKullanimi extends TestBase {

    @Test
    public void test01() {

    //● https://testotomasyonu.com/addremove/ adresine gidin.
    driver.get("https://testotomasyonu.com/addremove/");

    //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.xpath("//h2"));
        String expectedText = "Add/Remove Elements";
        String actualText = yaziElementi.getText();
        Assert.assertEquals(expectedText,actualText);

    //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedText,actualText);

    //● ‘Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.linkText("Electronics Products")).click();
        /*
                Driver, bir Web Elemente click yaptığında aynı sayfada açılacağını varsayar.

                Eğer tıklanan element yeni bir tab veya windor açıyorsa.
                bu durumda driver'ı yeni açılan tab/window'a bizim göndermemiz gerekir.

                Driver'ı, başka bir tab/window'a yollamak için 2 yolumuz var:
                1- ya kontrollü yeni bir tab/window açarız,
                2- ya da kontrolsüz açılan tab/window'un Window Handle Değerini kullanırız.

                Burada Java'dan yararlanarak mini bir bulmaca çözmeliyiz.

         */
        String ilkSayfaWHD = driver.getWindowHandle();
        Set<String> wHDSeti = driver.getWindowHandles();// açık olan window'ların hepsinin Handle Değerlerini bir Set<> olarak getirir.

        String ikinciSayfaWHD = "";
        for (String each : wHDSeti
             ) {
            if (!each.equals(ilkSayfaWHD)) {
                ikinciSayfaWHD = each;
            }
        }

        driver.switchTo().window(ikinciSayfaWHD);
    //● Electronics sayfasinin acildigini test edin
        expectedTitle = "Electronics";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    //● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));
        String sonucSayisiStr = sonucYaziElementi.getText().replaceAll("\\D","");

        int actualSonucSayisi = Integer.parseInt(sonucSayisiStr);
        int expectedUrunSayisi = 16;

        Assert.assertEquals(expectedUrunSayisi,actualSonucSayisi);


    //● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilkSayfaWHD);

    //● Url’in addremove icerdigini test edin

        String expectedUrl = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        ReusableMethods.bekle(5);

}
}
