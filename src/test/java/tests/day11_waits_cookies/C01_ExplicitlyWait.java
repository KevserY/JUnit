package tests.day11_waits_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWait {
    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()


    //  Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin
    @Test
    public void implicitlyWaitTesti() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));

        Assert.assertTrue(itsBackElementi.isDisplayed());

        driver.quit();
    }

    @Test
    public void expilicitlyWaitTesti() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        /*
        Eğer kullanmak istediğimiz element locate edilebilir durumda ise
        önce locate edip,
        sonra istenen condition için bekleyebiliriz.
        AMA bu soruda olduğu gibi
        locate ve bekleme kısır döngü oluşturuyorsa locate ve bekleme işlemi birlikte yapılabilir.

                    // 1. ADIM: bir wait obj oluşturmalısınız
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
                    // 2. ADIM: bekleyeceğimiz webelementi locate edin
        WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
                    // 3. ADIM: wait objesini kullanarak istediğiniz web Element üzerinde işlem yapın
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
         */

                // 1. ADIM: bir wait obj oluşturmalısınız
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

                // 2. ADIM: bekleme için oluşturduğumuz bu wait objesini kullanarak
                //          beklenecek WebElement'in locate'ini ve beklemeyi birlikte yaparız.

        WebElement itsGoneYaziElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[text()=\"It's back!\"]"))));

        driver.quit();
    }

}
