package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesExistsTesti extends TestBase {

    @Test
    public void dosyaIndirmeTesti() {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();

        ReusableMethods.bekle(5);

        //"C:\Users\HUAWEI\Downloads\logo.png"----indirilenler dosyasındaki konumu

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        //--indirilenlerde dosyanın konumunu kopyalıyoruz.

        String dosyaYolu = "C:\\Users\\HUAWEI\\Downloads\\logo.png";

        System.out.println(Files.exists(Paths.get(dosyaYolu))); //----ture.

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }


}
