package tests.day13_excelOtomasyon_getScreenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ExceliMapeAktarma extends TestBase {
    @Test
    public void readExcel() throws IOException {

        String dosyaYolu = "src/test/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // Ülkeler excel'indeki Türkçe ülke isimleri ve
        // Türkçe başkent isimlerini bir Map olarak kaydedin
        // Ülke isimleri key, başkent isimleri value olsun

        Map<String, String> ulkelerMap = new TreeMap<>();

        String satirdakiUlkeIsmi;
        String satirdakiBaskentIsmi;
        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatirIndex ; i++) {
            satirdakiUlkeIsmi = workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString();
            satirdakiBaskentIsmi = workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(satirdakiUlkeIsmi,satirdakiBaskentIsmi);
        }

        // Rusya'nin baskentinin Moskova oldugunu test edelim
        String expectedBaskentIsmi = "Moskova";
        String actualBaskentIsmi = ulkelerMap.get("Rusya");
        Assert.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);

        // Listede baskenti San Marino olan bir ulke oldugunu test edelim
        Assert.assertTrue(ulkelerMap.containsValue("San Marino"));

        // Listede Filipinler'in oldugunu test edelim
        Assert.assertTrue(ulkelerMap.containsKey("Filipinler"));
    }
}
