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

public class C02_ExplicitlyWait {

    @Test
    public void explicitlyWaitTesti() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi = driver.findElement(By.xpath("//input[@type='text']"));

        Assert.assertFalse(textboxElementi.isEnabled());

        //5. Enable butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        //ve textbox etkin oluncaya kadar bekleyin
                    // wait obj oluştur.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
                    // 1.ADIM: mümkünse kullanılacak WebElementi locate et.
                    // 2.ADIM: biz textbox in kullanılabilir olmasını bekleyeceğiz. textbox locate edildi
                    // 3.ADIM: wait objesi üzerei

        wait.until(ExpectedConditions.elementToBeClickable(textboxElementi));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledElementi = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assert.assertTrue(itsEnabledElementi.isEnabled());

        driver.quit();

    }
}
