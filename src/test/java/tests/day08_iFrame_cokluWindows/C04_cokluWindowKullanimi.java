package tests.day08_iFrame_cokluWindows;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;
public class C04_cokluWindowKullanimi extends TestBase {
    @Test
    public void test01() {
        //biz driver'la yaptıgımız tüm işlemlerde aynı window'da çalıştık.
        // driver bu sebeple yaptığımız her işlemi aynı window içinde araştırır
        // isterseniz siz yeni bir tab veya window oluşturabilirsiniz

        driver.get("https://www.testotomasyonu.com");
        System.out.println(driver.getWindowHandle());
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle());
        driver.navigate().back();
        System.out.println(driver.getWindowHandle());
        // yeniden testotomasyonu sayfasındayız.

        // Electronics linkine tıklayalım
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        System.out.println(driver.getWindowHandle());




    }
}