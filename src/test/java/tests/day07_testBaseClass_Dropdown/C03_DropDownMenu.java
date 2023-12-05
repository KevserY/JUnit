package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_DropDownMenu extends TestBase {

    @Test
    public void dropdownTest() {
        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        // 1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
                // - 1. adım : kullanacağımız ddm locate edelim
        WebElement gunDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
                // - 2. adım : bir select objesi oluşturalım
                // - parametre olarak locate ettiğimiz dropdownmenü'yü yazalım

        Select selectGun = new Select(gunDdm);
                // - 3. adım : oluşturduğumuz select objesi ile istenen işlemleri yapın.

        // 1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        selectGun.selectByIndex(5);

        // 2. Dogum tarihi ay seçeneğinden visibleText kullanarak Nisan’i secin
        WebElement ayDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDdm);
        selectAy.selectByVisibleText("Nisan");

        // 3. Dogum tarihi yil seçeneğinden ""visible text"" kullanarak 1990’i secin
        WebElement yilDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectyil = new Select(yilDdm);
        selectyil.selectByVisibleText("1990");

        // 4. seçilen değerleri konsola yazdırın
                /*          Dropdown Menü'de seçim yaptıktan sonra
                            yapılan seçimi yazdırmak isterseniz                 */

        System.out.println("Seçilen Tarih: " + selectGun.getFirstSelectedOption().getText()+
                                             " "+ selectAy.getFirstSelectedOption().getText()+
                                             " "+ selectyil.getFirstSelectedOption().getText());//Seçilen Tarih: 5 Nisan 1990
        // select...'lar obje olduğu için direk sout'da referansını yazdırır.
        // obje oluşturmaktaki amaç, objeyi kullanarak ona birşeyler yaptırmaktır, ona bir değer atamak değil

        // 5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayOptionsElementleriList = selectAy.getOptions();
        System.out.println(ReusableMethods.stringListeDonustur(ayOptionsElementleriList));
        //[Ay, Ocak, Şubat, Mart, Nisan, Mayıs, Haziran, Temmuz, Ağustos, Eylül, Ekim, Kasım, Aralık]

        // 6. Ay Dropdown menusunun boyutunun 30 olduğunu test edin

        Assert.assertEquals(30,ayOptionsElementleriList.size());




    }
}