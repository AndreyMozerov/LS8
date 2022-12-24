package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SelenideFilesTest {
    @Test
    void SelenideDownloadTest  () throws Exception {
        open("href=/junit-team/junit5/blob/main/README.md");
        File downloadedFile=$("#raw-url").download();
        try (InputStream is = new FileInputStream(downloadedFile)){
        byte[] bytes = is.readAllBytes();
        String textContent = new String(bytes, StandardCharsets.UTF_8);
        assertThat (textContent).contains("This");}
    }
    @Test
    void SelenideUploadTest(){
     open("https://fineuploader.com/demos.html");
     $("input[type='file']").uploadFromClasspath("Glowes.jpg");
     $(".qq-file-info").shouldHave(Condition.text("Glowes.jpg"));
    }

}
