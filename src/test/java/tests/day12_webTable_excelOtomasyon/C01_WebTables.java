package tests.day12_webTable_excelOtomasyon;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01() {

        // 1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//div[@role='hdata']"));
        // bu liste web elementlerden oluştuğu için hemen yazdıramayız.
        List<String> baslikYazilariList = ReusableMethods.stringListeDonustur(baslikElementleriList);
        System.out.println("Başlıklar : "+baslikYazilariList);// Başlıklar : [Product, Name, Category, Price, Actions]

        //  3. 3.sutunun basligini yazdirin
        System.out.println("3. sütun başlığı : " + baslikYazilariList.get(2));//3. sütun başlığı : Price

        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tabloDataElementleri = driver.findElements(By.xpath("//*[@role='tdata']"));
        List<String> tabloDataYazilarList = ReusableMethods.stringListeDonustur(tabloDataElementleri);
        System.out.println("Tabloda bulunan tüm datalar: "+tabloDataYazilarList);


        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki data sayısı: "+ tabloDataElementleri.size()); // 20

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("Tablodaki ürün satırları sayısı: " +satirElementleriList.size());  //5

        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi: " + baslikElementleriList.size());  // 4

        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));
        List<String> ucuncuSutunYaziList = ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList);

        System.out.println("Tablodaki 3.Sütun : " + ucuncuSutunYaziList);
        //Tablodaki 3.kolon : [$399.00, $399.00, $399.00, $40.00, $15.00]

        //  9. Tabloda " Category" si Furniture olan urunun "fiyatini" yazdirin

        // bir loop ile her bir satırı tektek inceleyelim.
        // kategori değeri (yani 2. data) furniture olan satırdaki
        // fiyat değerini (yani 3. data) yazdıralım

        //List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='trow']"));

        //10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin


        ReusableMethods.bekle(2);


    }


    public String istenenHucredekiDatayiYazdir(int satirNo, int sutunNo) {

        //((//*[@role=‘trow’])[3]/*[@role=‘tdata’])[3]

        String dinamikXpath = "((//*[@role=‘trow’])[" + satirNo + "]/*[@role=‘tdata’])[" + sutunNo + "]";

        return driver.findElement(By.xpath(dinamikXpath)).getText();

    }
}
