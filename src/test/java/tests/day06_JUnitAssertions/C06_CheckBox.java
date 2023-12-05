package tests.day06_JUnitAssertions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;
import utilities.TestBase_BeforeClass;

public class C06_CheckBox extends TestBase {
    @Test
    public void formTesti() {

        // a. Verilen web sayfasına gidin. https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement carpintiBox = driver.findElement(By.xpath("//input[@id='gridCheck4']"));
        carpintiBox.click();//radio button tıklanarak seçildi

        carpintiBox.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.bekle(3);

        WebElement sirtAgrisiBox = driver.findElement(By.xpath("//input[@id='gridCheck5']"));
        sirtAgrisiBox.click(); //"Sırt Ağrısı" RADIO BUTTON tıklanarak seçildi.

        // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        // burada radio button tıklanarak seçili olanlar üzerinden testimizi yapıyoruz.
        Assert.assertTrue(sirtAgrisiBox.isSelected());
        Assert.assertTrue(carpintiBox.isSelected());

        // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
        WebElement sekerRadioButton = driver.findElement(By.xpath("//input[@id='hastalikCheck2']"));
        WebElement epilepsiRadioButton = driver.findElement(By.xpath("//input[@id='hastalikCheck7']"));

        Assert.assertFalse(sekerRadioButton.isSelected());
        Assert.assertFalse(epilepsiRadioButton.isSelected());
    }
}
