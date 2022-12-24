package guru.qa;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
}
