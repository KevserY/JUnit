package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C00_ODEV {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // https://www.saucedemo.com adresine gidin
        driver.get("https://www.saucedemo.com");
        // Username : "standard_user"
        WebElement usernameKutusu = driver.findElement(By.id("user-name"));
        usernameKutusu.sendKeys("standard_user");

        // Password : "secret_sauce"
        WebElement passwordKutusu = driver.findElement(By.xpath("//*[@id='password']"));
        passwordKutusu.sendKeys("secret_sauce");

        ReusableMethods.bekle(2);
        // click to Login
        driver.findElement(By.id("login-button")).click();
        ReusableMethods.bekle(2);

        // ilk ürünün ismini kaydedin ve bu ürünün sayfasına gidin.
        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='inventory_item_name '])[1]"));


        // "Add to Cart" butonuna basın
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // alışveriş sepetine tıklayın
        driver.findElement(By.className("shopping_cart_link")).click();

        // seçtiğiniz ürünün başarılı olarak sepete eklendiğini control edin
        WebElement secilenUrun = driver.findElement(By.className("cart_item_label"));

        if ((secilenUrun.isDisplayed())) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        // sayfayı kapatın
        ReusableMethods.bekle(2);
        driver.quit();


    }
}
