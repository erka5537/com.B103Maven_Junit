package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {
//        WORKBOOK > SHEET > ROW > CELL > YAZ > KAYDET
//        WORKBOOK(EXCEL DOSYASI) > WORKSHEET/SHEET(SAYFA) > ROW (SATIR) > CELL(VERİ HÜCRESİ)
        String path = "./src/test/java/resources/Capitals.xlsx";

//        DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

//        EXCELL DOSYASINI AC /WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        SAYFAYI AC / Sheet1
        //Sheet sheet1 = workbook.getSheetAt(0); // index 0'dan başlar ilk sayfayı açar
        Sheet sheet1 = workbook.getSheet("Sheet1");

//        ILK SATIR'A GIT / Row
        Row row1 = sheet1.getRow(0); // Ilk satıra gıt

//        ILK SATIR 3.SUTUN'U CREATE ET
        Cell cell3 = row1.createCell(2);

//        NUFUS YAZ
        cell3.setCellValue("NUFUS");

//        2.Satır 3.Sütuna 45000
        sheet1.getRow(1).createCell(2).setCellValue("450000");

//        3.Satır 3.Sütuna 350000
        sheet1.getRow(2).createCell(2).setCellValue("350000");

//        KAYDET: KAYIT ISLEMI FILE OUTPUT STREAM ILE YAPILIR
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
    }
}
