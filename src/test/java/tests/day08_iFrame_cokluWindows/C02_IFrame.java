package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_IFrame extends TestBase {

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement textElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(textElementi.isEnabled());

        // Text Box’a “Merhaba Dunya!” yazin.

                    /*  Burada text box bir iframe içinde.
                        iframe'in içinde olan elementlere ulaşabilmek için
                        önce iframe'e geçiş yapmalıyız.

                        iframe'e geçiş yapabilmek için
                        - önce iframe'i bir Webelement olrak locate edin
                        - sonra switchTo() ile iframe'e geçin

                        iframe'e geçiş yaparsanız driver orada kalır.
                        Yeniden anasayfa ile ilgili bir işlem yapmak isterseniz
                        driver'ı yeniden anasayfaya geçirmelisiniz.           */

        WebElement iframeElementi = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElementi);

        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dünya!");

        driver.switchTo().defaultContent(); // parentFrame() ' de kullanılabilir.

        // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        WebElement seleniumElementi = driver.findElement(By.xpath("//*[@href='http://elementalselenium.com/']"));

        Assert.assertTrue(seleniumElementi.isDisplayed());
        System.out.println(seleniumElementi.getText());



    }
}
