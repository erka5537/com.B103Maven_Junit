package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class C01_ExcelRead{

    @Test
    public void readExcelTest() throws IOException {
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

//        ILK SATIRDAKI ILK VERIYI AL
        Cell cell1 = row1.getCell(0);//Ilk hucredeki datayı verir

//        O VERIYI YAZDIR
        System.out.println(cell1);

//        1. SATIR 2.SUTUN
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));

//        3.SATIR 1.SUTUN
        System.out.println(workbook.getSheet("Sheet1").getRow(2).getCell(0));

//        Exceldeki toplam satır sayısını bul
        int toplamSatirSayisi = sheet1.getLastRowNum()+1; //son satır numarası index 0 başlıyor sayma sayıları 1 den başlıyor +1 ekle
        System.out.println(toplamSatirSayisi);//11

//        Kullanılan toplam ssatır sayısı
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println(kullanilanToplamSatirSayisi);//1 den başlıyor

        for(int i=0; i<toplamSatirSayisi; i++){
            workbook.getSheet("Sheet1").getRow(i).forEach(System.out::println);
        }

        //        COUNTRY, CAPITALS key ve value lari map a alip print et
//        {{USA, D.C},{FRANCE, PARIS},...}

//        Variable olusturalim. Bu variable exceldeki country,capital verilerini tutacak
        Map<String,String> ulkeBaskentleri = new HashMap<>();


        for (int satirSayisi=1;satirSayisi<kullanilanToplamSatirSayisi;satirSayisi++){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
        }
        System.out.println(ulkeBaskentleri);

//        COUNTRY, CAPITALS key ve valuelari map'a alıp print etmek istiyorum
        Map<Cell,Cell> kv = new HashMap<>();
        for(int i=1; i<toplamSatirSayisi; i++){
            Cell bir = workbook.getSheet("Sheet1").getRow(i).getCell(0);
            Cell iki = workbook.getSheet("Sheet1").getRow(i).getCell(1);
            kv.put(bir,iki);
        }
        IntStream.range(1,toplamSatirSayisi).forEach(t->kv.put(workbook.getSheet("Sheet1").getRow(t).getCell(0),workbook.getSheet("Sheet1").getRow(t).getCell(1)));
        System.out.println(kv);
    }
}

//Excel Okuma
//Excelden veriyi okumak icin hangi sırayla gitmem gerekir
//workbook > sheet > row > cell
//Bir exceldeki top satir sayısı nasıl bulunur?
//getLastROwNumber
//Yada
//getPhysicalNumberOfRows- toplam kullanılan satir sayısı
//Excel Yazdırma
//Microsoft dosyalari ile iletişime gecmek icin apache poi dependency’s kullanılır
//Su anki projende exceli nasil kullandin?
//Test caselerimde çeşitli datalar kullanıyorum. Ornegin kullanıcı adi, kullanıcı şifresi gibi dataları excelde tutuyoruz. Bu datalari test caselerde kullanmak icin excelden çekiyorum ve test caselerimde kullanıyorum.
//Datalari excelde tutmanı faydası, dataların derli toplu bir yerde olması, data güvenliği, data kayıplarına engel olmak.


