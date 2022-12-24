package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
        try (InputStream resourseAsStream = cl.getResourceAsStream("Citilink2022.xlsx")) {
            XLS content = new XLS(resourseAsStream);

        }
    }
    @Test
    void csvParseTest() throws Exception {
        try (
                InputStream resourse = cl.getResourceAsStream("qaguru.csv");
                CSVReader reader = new CSVReader(new InputStreamReader(resourse))
        ){
            List<String[]>content=reader.readAll();
            assertThat(content.get(0)[1]).contains("Lesson");
            }
    }
    void zipParseTest() throws Exception {
        try (
                InputStream resourse = cl.getResourceAsStream("SVGA.zip");
                ZipInputStream zip = new ZipInputStream(resourse)
        ){
            ZipEntry entry;
            while((entry=zip.getNextEntry())!=null){
            assertThat(entry.getName()).isEqualTo("Приложение 1  Технические требования к СВСЗ АС РФ doc (c комментариями).docx");
            }
        }
    }



}

