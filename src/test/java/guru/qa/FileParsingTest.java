package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;


public class FileParsingTest {
    ClassLoader cl = FileParsingTest.class.getClassLoader();
    @Test
            void pdfParseTest() throws Exception {
    open("https://junit.org/junit5/docs/current/user-guide/");
    File downloadedPdf = $("a[href='junit-user-guide-5.9.1.pdf']").download();
    PDF content = new PDF(downloadedPdf);
    assertThat(content.author).contains("Sam Brannen");
    }

    @Test
    void xlsParseTest() throws Exception {
        try (InputStream resourseAsStream = cl.getResourceAsStream("Citilink2022.xls")){
        XLS content = new XLS(resourseAsStream);
            System.out.println();
        }
    }
}
