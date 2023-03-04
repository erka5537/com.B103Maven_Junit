package practice.erol_hoca.practice04;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P07_Excel extends TestBase {

    @Test
    public void test01() throws IOException {

        //Data isimli excel dosyasına yeni kullanıcı adı ve password ekliyelim
        Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\ERKA55\\Desktop\\data.xlsx"));
        workbook.getSheet("Sayfa1").createRow(3).createCell(0).setCellValue("2. Kullanıcı Bilgileri");
        workbook.getSheet("Sayfa1").createRow(4).createCell(0).setCellValue("email");
        workbook.getSheet("Sayfa1").createRow(5).createCell(0).setCellValue("password");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\ERKA55\\Desktop\\data.xlsx");
        workbook.write(fos);
    }

    @Test
    public void name01() throws IOException {
        //Yeni bir methodda kullanıcı bilgileri başlığını silelim
        String dosyaYolu = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\data.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);
        Cell cell = row.getCell(0);
        row.removeCell(cell);
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
    }

}
