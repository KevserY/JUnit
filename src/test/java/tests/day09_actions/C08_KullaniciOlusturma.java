package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C08_KullaniciOlusturma extends TestBase {

    @Test
    public void kullaniciOlusturmaTesti() {
    //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

    //2- Account linkine tiklayin
    driver.findElement(By.xpath("(//span[text()='Account'])[1]")).click();

    //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up ']")).click();

    //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstName = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.click(firstName)
                        .sendKeys("Kevser")
                            .sendKeys(Keys.TAB)
                                .sendKeys("Yazıcı")
                                     .sendKeys(Keys.TAB)
                                          .sendKeys("yzc@gmail.com")
                                               .sendKeys(Keys.TAB)
                                                    .sendKeys("12345")
                                                        .sendKeys(Keys.TAB)
                                                                .sendKeys("12345")
                                                                        .perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        driver.findElement(By.id("btn-submit-form")).click();

        ReusableMethods.bekle(3);
    //5- Kaydin olusturuldugunu test edin

            /*   Kayıt oluşturulunca bizi SignIn sayfasına yönlendiriyor.
                 Kaydın oluşturulduğunu test etmek için
                 girdiğimiz bilgilerle login olabildiğimizi test edelim.   */

        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        WebElement signInButonu = driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys("yzc@gmail.com");
        passwordKutusu.sendKeys("12345");
        signInButonu.click();

        // logout kutusunun görünür olmasıyla kayıt oluşturduğumuzu test edeceğiz.
        WebElement logoutLinki = driver.findElement(By.xpath("//span[text()='Logout']"));
        Assert.assertTrue(logoutLinki.isDisplayed());

        ReusableMethods.bekle(3);





    }
}

