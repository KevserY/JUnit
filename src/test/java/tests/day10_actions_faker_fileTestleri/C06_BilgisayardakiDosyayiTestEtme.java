package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_BilgisayardakiDosyayiTestEtme {

    @Test
    public void test01() {
        //Downloads 'da logo.png olduğunu test edin.

        String dosyayolu = "C:\\Users\\HUAWEI\\Downloads\\spectrum-logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
        // farklı olan==> user.home
        //                C:\Users\HUAWEI
        //aynı olan ==> user.dir
        //              \Downloads\spectrum-logo.png

        String dinamikDosyaYolu = System.getProperty("user.home") +
                                    "\\Downloads\\spectrum-logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
        
    }
}
