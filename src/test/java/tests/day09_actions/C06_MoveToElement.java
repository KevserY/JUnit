package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_MoveToElement extends TestBase {

    @Test
    public void moveToElementTesti() {
        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement kidsWearElementi = driver.findElement(By.xpath("(//li[@class='has-sub'])[7]"));
        Actions actions = new Actions(driver);

        actions.moveToElement(kidsWearElementi).perform();

        ReusableMethods.bekle(3);

        //3- “Boys” linkine basin
        WebElement boysLinki = driver.findElement(By.xpath("//a[@href='https://www.testotomasyonu.com/category/10/products']"));
        boysLinki.click();


        //4- Acilan sayfadaki ilk urunu tiklayin
        ReusableMethods.bekle(3);
        driver.findElement(By.xpath("(//div[@class='product-box mb-2 pb-1'])[1]"));

        //4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        WebElement isimElementi = driver.findElement(By.linkText("Boys Shirt White Color"));

        String expectedIsim = "Boys Shirt White Color" ;
        String actualIsim = isimElementi.getText();

        Assert.assertEquals(expectedIsim,actualIsim);

        ReusableMethods.bekle(3);




    }


}
