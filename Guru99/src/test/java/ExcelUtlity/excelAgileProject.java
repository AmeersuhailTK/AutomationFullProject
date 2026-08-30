package ExcelUtlity;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelAgileProject {

    private static XSSFWorkbook workbook;
    public static Sheet sheet;

    public static void setExcelFile(String path, String sheetName) throws Exception {

        FileInputStream file = new FileInputStream(path);
        workbook = new XSSFWorkbook(file);

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException("Sheet '" + sheetName + "' not found in file: " + path);
        }
    }

    public static String getCellData(int rowNum, int colNum) {

        Row row = sheet.getRow(rowNum);
        if (row == null) return "";

        Cell cell = row.getCell(colNum);
        if (cell == null) return "";

        String value = "";

        switch (cell.getCellType()) {
            case STRING:
                value = cell.getStringCellValue();
                break;

            case NUMERIC:
                value = String.valueOf(cell.getNumericCellValue());
                break;

            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;

            case BLANK:
                value = "";
                break;

            default:
                value = "";
                break;
        }

        return value;
    }

    public static int getRowCount() {
        return sheet.getLastRowNum();
    }
}
