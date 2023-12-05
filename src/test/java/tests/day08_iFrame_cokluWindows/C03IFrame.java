package tests.day08_iFrame_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03IFrame extends TestBase {

    @Test
    public void test01() {
        //1)http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2)Cookies kabul edin
        // cookies de iframe içinde olduğu için önce iframe'e geçin
                // cookies çıkmadı

        //3) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iFrameList = driver.findElements(By.tagName("iframe"));

        System.out.println("Sayfadaki iframe sayısı : " + iFrameList.size());
                    //Sayfadaki iframe sayısı : 8

        //4) ilk iframe’deki (Youtube) play butonuna tıklayınız.
        WebElement playIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(playIframe);
        driver.findElement(By.xpath("//button[@title='Oynat']")).click();

        ReusableMethods.bekle(5);

        //5) ilk iframe’den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

    }
}
