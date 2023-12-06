package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C07_KeyboardActions extends TestBase {

    @Test
    public void test01() {
        // https://www.testotomasyonu.com sayfasına gidelim
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        // Arama Kutusuna actions method'larını kullanarak "DELL Core I3" yazdırın
        // ve ENTER'a basarak arama yaptırın.
        WebElement aramaKutusu = driver.findElement(By.xpath("(//*[@id='global-search'])[1]"));
        Actions actions =new Actions(driver);

        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("i")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .perform();
        ReusableMethods.bekle(5);

        actions.sendKeys(Keys.ENTER).perform();

        // Bulunan ürün isminde "DELL Core I3" bulunduğunu test edin
        WebElement urunIsmi = driver.findElement(By.xpath("//div[@class='product-box my-2  py-1']"));

        Assert.assertTrue(urunIsmi.isDisplayed());



    }




}
