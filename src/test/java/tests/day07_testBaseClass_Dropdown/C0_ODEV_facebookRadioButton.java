package tests.day07_testBaseClass_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C0_ODEV_facebookRadioButton {
    //gerekli yapıyı oluşturun ve aşağıdaki testi yapın.

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void facebookTesti() {
        // verilen web sayfasına gidin // https://facebook.com
        driver.get("https://facebook.com");

        // cookies'i kabul edin

        // Creat an account button'a basın
        ReusableMethods.bekle(3);

        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // Radio Button Elementlerini locate edin ve size uygun olanı secin
        WebElement kadinRadioButton = driver.findElement(By.xpath("(//input[@class='_8esa'])[1]"));
        kadinRadioButton.click();

        // sectiğiniz radio button'un seçili, ötekilerin saçili olmadığını test edin.
        WebElement erkekRadioButton = driver.findElement(By.xpath("(//input[@class='_8esa'])[2]"));
        WebElement ozelRadioButton = driver.findElement(By.xpath("(//input[@class='_8esa'])[3]"));

        Assert.assertTrue(kadinRadioButton.isSelected());
        Assert.assertFalse(erkekRadioButton.isSelected());
        Assert.assertFalse(ozelRadioButton.isSelected());
    }




}
