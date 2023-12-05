package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeClass;

public class C04_DropDownMenu extends TestBase_BeforeClass {

    @Test
    public void dropdownTesti() {
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        // 3. Login kutusuna “username” yazin
        WebElement loginKutusu = driver.findElement(By.id("user_login"));
        loginKutusu.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        WebElement passwordKutusu = driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");

        // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        driver.navigate().back();

        //6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        //8. “Currency” dropdown menusunden Eurozone’u secin

    /*    dropdown menüler <select> tag'ıya oluşturulurlar. alt menüleri de <option> tag'ıyla oluşturulur.

           Dropdown menüleri 3 şekilde seçeri.
           1- index ile--- selectByIndex();
           2- görünür isimle--- selectByVisibleText();
           3- value atribute değeriyle--- selectByValue();                      */

        WebElement currencyDdm = driver.findElement(By.id("pc_currency"));
        Select selectCurrency = new Select(currencyDdm);
        selectCurrency.selectByValue("EUR");

        //9. “amount” kutusuna bir sayi girin
        WebElement amountKutusu = driver.findElement(By.id("pc_amount"));
        amountKutusu.sendKeys("200");

        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        //10. seçilen currency'nin “US Dollars” olmadığını test edin
        WebElement dolarRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(dolarRadioButton.isSelected());

        ReusableMethods.bekle(3);

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement sonucYazisi = driver.findElement(By.id("alert_content"));
        String expectedSonucYazisi = "Foreign currency cash was successfully purchased.";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertEquals(expectedSonucYazisi, actualSonucYazisi);

    }
}
