//We need to pass the expected and actual excel files as a parameter in compareExcelFiles

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelComparator {

    public static String compareExcelFiles(byte[] file1, byte[] file2) throws IOException {
        StringBuilder result = new StringBuilder();
        try (Workbook workbook1 = new XSSFWorkbook(new ByteArrayInputStream(file1));
             Workbook workbook2 = new XSSFWorkbook(new ByteArrayInputStream(file2))) {

            Sheet sheet1 = workbook1.getSheetAt(0);
            Sheet sheet2 = workbook2.getSheetAt(0);

            Iterator<Row> rowIterator1 = sheet1.iterator();
            Iterator<Row> rowIterator2 = sheet2.iterator();

            int rowIndex = 0;
            while (rowIterator1.hasNext() && rowIterator2.hasNext()) {
                Row row1 = rowIterator1.next();
                Row row2 = rowIterator2.next();

                String row1String = rowToString(row1);
                String row2String = rowToString(row2);

                if (!row1String.equals(row2String)) {
                    result.append("Mismatch found at row ").append(rowIndex).append(": ")
                            .append(row1String).append(" != ").append(row2String).append("\n");
                }
                rowIndex++;
            }

            if (rowIterator1.hasNext() || rowIterator2.hasNext()) {
                result.append("Mismatch found: Different number of rows\n");
            }

            if (result.length() == 0) {
                result.append("Files are identical");
            }
        }
        return result.toString();
    }

    private static String rowToString(Row row) {
        StringBuilder rowString = new StringBuilder();
        for (Cell cell : row) {
            rowString.append(cell.toString()).append("\t");
        }
        return rowString.toString().trim();
    }
}
