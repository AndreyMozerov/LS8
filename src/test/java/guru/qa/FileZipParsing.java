package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FileZipParsing {

    ClassLoader cl = FileZipParsing.class.getClassLoader();

    @Test
    void readZipTest() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("L8HW.ZIP");
                ZipInputStream zip = new ZipInputStream(resource);
        ) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                if (entry.getName().contains(".pdf")) {
                    PDF pdf = new PDF(zip);
                    assertThat(pdf.text).contains("Metus");
                } else if (entry.getName().contains(".xlsx")) {
                    XLS xls = new XLS(zip);
                    assertThat(xls.excel.getSheetAt(0).getRow(12).getCell(0).getStringCellValue()).isEqualTo("Время");
                    assertThat(xls.excel.getSheetAt(0).getRow(26).getCell(0).getStringCellValue()).isEqualTo("Время");
                } else {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zip));
                    List<String[]> csv = csvReader.readAll();
                    assertThat(csv.get(0)[1]).contains("lesson");
                    assertThat(csv.get(2)[0]).contains("Petrov");
                }
            }
        }
    }
}

