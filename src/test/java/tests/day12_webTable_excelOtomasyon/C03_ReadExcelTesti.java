package tests.day12_webTable_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.etsi.uri.x01903.v13.impl.SignerRoleTypeImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcelTesti {

    Sheet sayfa1;

    @Test
    public void readExcelTesti() throws IOException {
        String dosyaYolu = "src/test/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        sayfa1= workbook.getSheet("Sayfa1");

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1));  //Başkent (İngilizce)

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucreStr = sayfa1.getRow(0).getCell(1).toString();
        System.out.println("String olarak istenen : " + istenenHucreStr);//String olarak istenen : Başkent (İngilizce)

        // - 2.satir 4.cell’in afganistan’in baskenti "Kabil" oldugunu test edelim
        String expectedHucreBilgisi = "Kabil";
        String actualHucreBillgisi = sayfa1.getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedHucreBilgisi,actualHucreBillgisi);

        // - Satir sayisini bulalim
        int satirSayisi = sayfa1.getLastRowNum();
        System.out.println("Satır sayısı: "+(satirSayisi+1));  // Satır sayısı: 191--(index olarak 190.)

        // -- Samoa'nın başkentinin Apia olduğunu test ediniz
        String expectedBaskent = "Apia";
        String actualBaskent = "";
        for (int i = 0; i < satirSayisi; i++) {
            String ulkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            if (ulkeIsmi.equals("Samoa")) {
                actualBaskent = sayfa1.getRow(i).getCell(1).toString();
            }
        }
        Assert.assertEquals(expectedBaskent,actualBaskent);

        // verdiğimiz ing ülke ismi ve ve dil tercihine göre
        // başkent ismini bize döndüren bir method oluşturun

        //baskentBul("Peru","Türkçe");

        // - Fiziki olarak kullanilan satir sayisini bulun
        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

    }
    /*
    public String baskentBul(String ulkeAdi, String dilTercihi){
        String satirdakiUlkeAdi;
        String basKentIsmi;

        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {
            satirdakiUlkeAdi = sayfa1.getRow(i).getCell(0).toString();


            ///// tekrarda tamamla//////////////////
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//

        }


        return


    }
*/

}
