package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_JsAlerts extends TestBase {

    //3 test method’u olusturup asagidaki gorevi tamamlayin

    @Test
    public void jsBasicAlert() {    //1. Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 1.alert’e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();

        // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi, actualAlertYazisi);

        // - OK tusuna basip alert’i kapatin
        ReusableMethods.bekle(3);
        driver.switchTo().alert().accept();
    }

    @Test
    public void jsConfirmAlert() {    //2.Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        // - 2.alert’e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();

        // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        driver.switchTo().alert().dismiss();

        String expectedSonucYazisi = "You clicked: Cancel";
        WebElement actualSonucYazisi = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertEquals(expectedSonucYazisi, actualSonucYazisi.getText());
    }

    @Test
    public void jsPrompTesti() {  //3.Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // - 3.alert’e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        // - Cikan prompt ekranina “Abdullah” yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");

        // - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();

        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim

        WebElement resultYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));

        String expectedYazi = "Abdullah";
        String actualYazi = resultYaziElementi.getText();
        Assert.assertTrue(actualYazi.contains(expectedYazi));
    }

}
