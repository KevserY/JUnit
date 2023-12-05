package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_KontrolluCokluWindowileCalisma extends TestBase {

    @Test
    public void kontrolluWindowTesti() {
        // Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        String anasayfaWHD = driver.getWindowHandle();

        // url'in testotomasyonu icerdigini test edin
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // yeni bir tab olarak elctronics linkini acin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        String electronicsWHD = driver.getWindowHandle();

        // acilan sayfanin electronics sayfasi oldugunu test edin

        String expectedTitle = "Electronics";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // yeni bir window'da acilacak sekilde menfashion linkini tiklayin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Men Fashion'])[3]")).click();
        String menFashionWHD = driver.getWindowHandle();

        // menfashion sayfasinin acildigini test edin
        expectedTitle = "Men Fashion";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // ilk actigimiz sayfaya donun
                /*
                       EĞER bir testte açılan window'lar, farklı tab veya window'da açılıyorsa
                       ve testimizde bu sayfalar arasında geçiş isteniyorsa,
                       geçtiğimiz her sayfanın WindowHandleDeğerini kaydetmeliyiz.
                 */

        driver.switchTo().window(anasayfaWHD);

        // test otomasyon anasayfada oldugumuzu test edin
        expectedUrl = "https://www.testotomasyonu.com/";
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

        //tekrar electronics açık olan tab'a geçin
        driver.switchTo().window(electronicsWHD);  //String electronicsWHD = driver.getWindowHandle();

        //electronics bölümünde olduğunuzu test edin
        expectedTitle = "Electronics";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));


        // tekrar men fashion açık olan tab'a geçin
        driver.switchTo().window(menFashionWHD);

        // men fashion bölümünde olduğunuzu test edin
        expectedTitle = "Men Fashion";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        ReusableMethods.bekle(5);

    }
}
