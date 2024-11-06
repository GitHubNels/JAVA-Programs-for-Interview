//This validateColumns method will have inputs (workbook index, List of expected columns, row index)

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExcelValidator {

    public static boolean validateColumns(Workbook workbook, List<Object> expectedColumns, int row) throws IOException {
        try (workbook) {
            Sheet sheetAt = workbook.getSheetAt(0);
            //For debug
//            System.out.println("Sheet value: " + sheetAt.getLastRowNum());
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(row);
            String headerRowString = rowToString(headerRow);
 //           System.out.println("Header Row: " + headerRowString);
            for (int i = 0; i < expectedColumns.size(); i++) {
                System.out.println("Fetch from excel: " + (i + 1) + ": " + expectedColumns.get(i));
                Cell cell = headerRow.getCell(i);
                String cellValue = getCellValueAsString(cell);
                String expectedValue = String.valueOf(expectedColumns.get(i));
                if (!expectedValue.equals(cellValue)) {
                    System.out.println("Mismatch at column " + (i + 1) + ": expected [" + expectedValue + "], but found [" + cellValue + "]");
                    return false;
                }
            }
        }
        return true;
    }

    public static Workbook getWorkbook(byte[] fileContent) throws IOException {
        return new XSSFWorkbook(new ByteArrayInputStream(fileContent));
    }

    private static String rowToString(Row row) {
        StringBuilder rowString = new StringBuilder();
        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            rowString.append(getCellValueAsString(cell)).append("\t");
        }
        return rowString.toString().trim();
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "Cell is null not fetching the excel value";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    return dateFormat.format(date);
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}
