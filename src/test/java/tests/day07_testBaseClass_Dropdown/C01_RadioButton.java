package tests.day07_testBaseClass_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class C01_RadioButton {
    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

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
    public void radioButtonKutuTesti() {
        // a. Verilen web sayfasına gidin.https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini locate edin
        //    - "radio buttonu" ile size uygun olani secin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // c. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        kadinRadioButton.click();
        Assert.assertTrue(kadinRadioButton.isSelected());
        Assert.assertFalse(erkekRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());

        ReusableMethods.bekle(2);
    }
    @Test
    public void radioButtonYaziTesti() {
        // a. Verilen web sayfasına gidin.https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Cinsiyet Radio button elementlerini locate edin
        //    - "yazıyı" click ederek size uygun olani secin

        WebElement kadinRadioButtonElementi = driver.findElement(By.xpath("//*[@for='inlineRadio1']"));
        // seçimi yazıyla yapabilirim.
        // ama assertionlar için radio buttonlara ihtiyaç var
        // yazıya bakarak seçili olduğunu kontrol edemen

        kadinRadioButtonElementi.click();
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // c. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(kadinRadioButton.isSelected());
        Assert.assertFalse(erkekRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());

        ReusableMethods.bekle(2);
    }
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //wait.until(ExpectedConditions.elementToBeClickable(By.id("inlineRadio2"))).click();

}

