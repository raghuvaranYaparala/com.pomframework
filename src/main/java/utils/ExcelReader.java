package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;


public class ExcelReader 
{

    public static List<Object[]> getTestData(String path, String sheetName) throws IOException {
        List<Object[]> data = new ArrayList<>();

        FileInputStream file = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);

        Iterator<Row> rows = sheet.iterator();
        rows.next(); // Skip header

        while (rows.hasNext()) {
            Row row = rows.next();

            String name = row.getCell(0).getStringCellValue();
            String email = row.getCell(1).getStringCellValue();
            String status = row.getCell(2).getStringCellValue();

            if (status.equalsIgnoreCase("Y")) {
                data.add(new Object[]{name, email});
            }
        }

        workbook.close();
        return data;
    }

    
    @DataProvider(name = "userData")
    public static Iterator<Object[]> provideUserData() throws IOException {
        return getTestData("C:\\Raghu\\Complete training of manual and automation testing\\Training\\TestNG\\Testdata.xlsx", "Sheet2").iterator();
    }

 
}
