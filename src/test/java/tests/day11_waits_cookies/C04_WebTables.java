package tests.day11_waits_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void webTableTesti() {

        /*      Klasik HTML kodları kullanılarak oluşturulan web tablolarında
                istediğimiz cell(hücre) deki data'ya ulaşabilmek için
                sadece tag'ları kullanarak tablo/body/satır/data sıralaması kullanırız.

                1- Eğer 1 of 1 bilgisine ulaşabiliyorsak tüm yolu yazmamıza gerek yok
                2- Eğer sadece child HTML tag'lara bakmak isteniyorsa /
                   child HTML tag'larla birlikte grandChild tag'lara da bakmak istersek
                   // kullanırız.
         */

        // https://testotomasyonu.com/webtables adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        // Web table tüm body'sini yazdırın
        WebElement bodyElementi = driver.findElement(By.xpath("//table/tbody"));
        System.out.println(bodyElementi.getText());

        // Web tablosunda "Comfortable Gaming Chair" bulunduğunu test edin
        String expectedIcerik = "Comfortable Gaming Chair";
        String actualBody = bodyElementi.getText();
        Assert.assertTrue(actualBody.contains(expectedIcerik));

        // Web table'daki satır sayısının 5 olduğunu test edin
        List<WebElement> satirElementleriListesi = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriListesi.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        // Tüm satırları yazdırın
        System.out.println("======Tüm Satırlar: =======");
        List <String> satirListesiStr = ReusableMethods.stringListeDonustur(satirElementleriListesi);
        System.out.println(satirListesiStr);

        System.out.println("======================================");

                   // veya satır WebElementlerini bir for loop ile yazdırıp, başına açıklama ekleyebiliriz.
        for (int i = 0; i < satirElementleriListesi.size(); i++) {
            System.out.println(i+1 + ". satır : " + satirElementleriListesi.get(i).getText());
        }

        // Web table'daki sütun sayısının 4 olduğunu test edin
        /*
                Web table'da sütun yapısı yoktur.
                Satırlar ve o satırlardaki datalar vardır.

                Sutun sayısını elde etmek için
                herhangi bir satırdaki data sayısına bakabiliriz.
         */
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//thead/tr/th"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = baslikElementleriList.size();

        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        // 3. sütunu yazdırın---xpath ile bulduğumuz data'ları, bir WebElementleri Listesi oluşturup, buraya atama yapıyoruz.
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println("====== 3. Sütun Elementleri : =======");
        // for loop ile yazdıralım

        for (int i = 0; i < ucuncuSutunElementleriList.size(); i++) {
            System.out.println(i+1 + ". satırdaki 3. sütun: " + ucuncuSutunElementleriList.get(i).getText());
        }

        // tablodaki başlıkları yazdırın
        //      List olarak yazdıralım
        List<WebElement> tabloBaslikElementleriList = driver.findElements(By.xpath("//thead/tr/th"));

        //      List'i String'e dönüştürmelisin

        List<String> tabloBaslikElementleriStr = ReusableMethods.stringListeDonustur(tabloBaslikElementleriList);

        System.out.println("Başlıklar : " + tabloBaslikElementleriStr);

        // satır ve sütun sayısını parametre olarak alıp,
        // hücredeki bilgiyi döndüren bir method oluşturun.

        System.out.println(getCellData(1, 3));

        //   4. satırdaki category değerinin "Furniture" olduğunu test edin

        String expectedCategory = "Furniture";
        String actualCategory = getCellData(4,2);
        Assert.assertEquals(expectedCategory,actualCategory);


    }
    public String getCellData(int satirNo, int sutunNo){
        //tbody/tr[4]/td[3]
        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenCellDataElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenCellDataElementi.getText();
    }


}
