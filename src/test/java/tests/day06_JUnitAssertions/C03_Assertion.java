package tests.day06_JUnitAssertions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;

public class C03_Assertion {

    @Test
    public void test01() {
        // emeklilik yaşı 65 olsun
        // 70 yaşındaki bir kişinin emekli olabildiğini test edin

        int yas = 70;
        Assert.assertTrue(yas > 65); // test PASSED


        int sayi1 = 20;
        int sayi2 = 30;

        //Assert.assertTrue(sayi1>sayi2); //FAILED

        /*
        parametre değeri ile Assertion birbiriyle örtüşdüğünde "test Passed olur"
        test methodu içinde assert  false olduğunda geri kalan kodlar çalışmaz
         */

        //System.out.println("Assertion failed olursa bu satır çalışmaz"); // true, çalışmadı!
        // 20. satırda exception fırlattı. java çalışmayı durdurdu. sonraki satırlar çalışmaz

        Assert.assertFalse(sayi1>sayi2); // PASSED
        System.out.println("Assertion passed olursa bu satır ve geri kalan kodlar normal çalışır, çalışmaya devam eder.");

        //iddia ve parametre birbirini doğrulamalı.



        //Url'in testotomasyonu içerdiğini test edin

        String actualUrl = "https://www.testotomasyonu.com" ;

        Assert.assertTrue(actualUrl.contains("testotomasyonu")); //PASSED
        // url'nin wisequarter içermediğini test edin
        // (mantığımızı test PASSED olacak şekilde kuruyoruz)
        Assert.assertFalse(actualUrl.contains("wisequarter")); // PASSED

        // URL'in "https://www.testotomasyonu.com" olduğunu test edin
        Assert.assertEquals("https://www.testotomasyonu.com",actualUrl);
        //Expected :https://www.testotomasyonu.com/
        //Actual   :https://www.testotomasyonu.com

        //Assert.assertNotEquals();



    }


}
