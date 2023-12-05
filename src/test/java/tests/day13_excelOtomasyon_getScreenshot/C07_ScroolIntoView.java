package tests.day13_excelOtomasyon_getScreenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_ScroolIntoView extends TestBase {
    @Test
    public void newProductTesti() {

        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // New Product bolumu gorununceye kadar asagi inin
        WebElement newProductElementi = driver.findElement(By.xpath("//*[text()=' New Product ']"));

        // ilk urunu tiklayin

        // ve fiyatinin $50.00 oldugunu test edin


    }

}
