package tests.day10_actions_faker_fileTestleri;

import org.junit.Test;
import utilities.TestBase;

public class C04_dosyaYolunuDinamikYapma{

    @Test
    public void test01() {

     /*
        java dosya yolunu dinamik hale getirebilmemiz için
        bize iki temel konuma ulşamak için hazır method sunmuş

        1- çalıştığımız projenin dosya yoluna ulaşmak isterseniz
        system.getProperty("user.dir")

        2- bilgisayarın ana dosya yoluna ulaşmak isteseniz

        Eğer bir takım halinde çalışıyorsak, projemizdeki bir dosya
        veya downloads'a indirdiğimiz bir dosyanın varlığını test etmek istiyorsak
        dosya yolunu bu iki kodu kullanarak dinamik hale getirmeliyiz.

         */
        System.out.println(System.getProperty("user.dir"));
        //C:\Users\HUAWEI\IdeaProjects\com.team127_JUnit

        System.out.println(System.getProperty("user.home"));
        //C:\Users\HUAWEI


    }

}
