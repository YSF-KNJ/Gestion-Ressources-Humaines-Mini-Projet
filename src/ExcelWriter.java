import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ExcelWriter {
    public static void main(String[] args) {
        try {
            Workbook workbook = new HSSFWorkbook();
            
            Sheet sheet = workbook.createSheet("Sheet1");
            
            Row row = sheet.createRow(0);
            
            Cell cell = row.createCell(0);
            cell.setCellValue("Hello");
            
            FileOutputStream fileOut = new FileOutputStream("output.xls");
            workbook.write(fileOut);
            fileOut.close();
            
            workbook.close();
            
            System.out.println("done");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
