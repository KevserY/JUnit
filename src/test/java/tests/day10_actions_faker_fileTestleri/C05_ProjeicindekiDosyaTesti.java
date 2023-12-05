package tests.day10_actions_faker_fileTestleri;
import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_ProjeicindekiDosyaTesti {

    @Test
    public void fileExistsTesti() {
        //projemiz içerisinde day10 package altında
        // deneme.txt dosyasının olduğunu test edin

    String dosyaYolu = "C:\\Users\\HUAWEI\\IdeaProjects\\com.team127_JUnit\\src\\test\\java\\tests\\day10_actions_faker_fileTestleri\\deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //Herkesde farklı olan kısım ---> user.dir
        //                          C:\\Users\\HUAWEI\\IdeaProjects\\com.team127_JUnit
        // herkeste aynı olan kısım ---> projenin içindeki dosya yolu.
        //                          \\src\\test\\java\\tests\\day10_actions_faker_fileTestleri\\deneme.txt";

        String dinamikDosyaYolu = System.getProperty("user.dir") +
                                "\\src\\test\\java\\tests\\day10_actions_faker_fileTestleri\\deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}