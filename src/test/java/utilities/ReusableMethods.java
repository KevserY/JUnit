package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> stringListeDonustur(List<WebElement> elementlerListesi) {
        List<String> stringlerListesi = new ArrayList<>();
        for (WebElement each : elementlerListesi
        ) {
            stringlerListesi.add(each.getText());
        }
        return stringlerListesi;
    }



    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public static WebDriver titleIleSayfaDegistir(WebDriver driver, String hedefSayfaTitle) {
        Set<String> tumWhdSeti = driver.getWindowHandles();
        for (String each : tumWhdSeti
        ) {
            String eachTitle = driver.switchTo().window(each).getTitle();
            if (eachTitle.equals(hedefSayfaTitle)) {
                return driver;
            }
        }
        return driver;
    }


    public static void tumSayfaTakeScreenshot(WebDriver driver) {
        // tum sayfanin fotografini cekip kaydedin

        // 1. ADIM: tss objesi oluşturalım
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.ADIM: fotoğrafı kaydedeceğimiz dosya yolu ile bir File oluşturalım.
        // her yeni kaydedilen resmin, öncekinin üzerine kaydedilmemesi için
        // kaydedilecek dosya yolunu dinamik yapabiliriz.
        // dinamik yapmak için dosya yoluna tarih etiketi ekleyelim.

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/tumSayfaScreenshot" +
                                    localDateTime.format(istenenFormat) +
                                    ".jpg";

        File tumSayfaScreenshot = new File(dinamikDosyaYolu);

        // 3.ADIM: tss objesini kullanarak foto çekip , geçici bir dosyaya kaydedelim.
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4:ADIM: geçiçi dosyayı asıl dosyaya kopyalıyalım
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.bekle(5);

    }

    public static void tumSayfaTakeScreenshot(String testAdi,WebDriver driver) {
        // tum sayfanin fotografini cekip kaydedin

        // 1. ADIM: tss objesi oluşturalım
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.ADIM: fotoğrafı kaydedeceğimiz dosya yolu ile bir File oluşturalım.
        // her yeni kaydedilen resmin, öncekinin üzerine kaydedilmemesi için
        // kaydedilecek dosya yolunu dinamik yapabiliriz.
        // dinamik yapmak için dosya yoluna tarih etiketi ekleyelim.

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/tumSayfaScreenshot" +
                localDateTime.format(istenenFormat) +
                ".jpg";

        File tumSayfaScreenshot = new File(dinamikDosyaYolu);

        // 3.ADIM: tss objesini kullanarak foto çekip , geçici bir dosyaya kaydedelim.
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4:ADIM: geçiçi dosyayı asıl dosyaya kopyalıyalım
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.bekle(5);

    }

}
