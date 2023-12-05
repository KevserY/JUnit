package tests.day12_webTable_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcelOtomasyonu {

    @Test
    public void excelOtomasyonTesti() throws IOException {

        String dosyaYolu = "src/test/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        /*
                bilgisayarımızdaki fiziki bir dosyayı
                kodlarımıza eklememiz mümkün değil

                Apache poi, verdiğimiz dosya yolundaki
                fiziki excel dosyasında bulunan tüm dataları,
                fileInputStream objesi sayesinde okuyup
                o bilgileri kullanabileceğimiz
                EXCEL dosyasının KOPYA sını oluşturur.

                Biz de bu kopya excel üzerinde istediğimiz işlemleri yapabiliriz.

                Önemli Not:
                Bu Test methodu içinde yaptığımız tüm işlemler
                Excel üzerinde değil,
                39. satırın çaılıştığı anda excel' de varolan bilgiler üzerindedir.

                satır ve sütun bilgileri index ile çalışır, 0 dan başlar.

         */
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        Row ucuncuSatir = sayfa1.getRow(3); // index= 3, fiziki olarak 4. satıra gider
        Cell ikinciData = ucuncuSatir.getCell(2); // index= 2, fiziki olarak 3. dataya gider

        System.out.println(ikinciData); // Cezayir

        // 12. satırda bulunan ülkenin Türkçe isminin "Azerbaycan" olduğunu test edin.

        String actualistenenUlkeAdi = sayfa1.getRow(11).getCell(2).toString();
        String expectedUlkeAdi = "Azerbaycan";

        Assert.assertEquals(expectedUlkeAdi,actualistenenUlkeAdi);

    }
}
