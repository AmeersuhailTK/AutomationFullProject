package ExcelUtlity;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class pageExcelutils {


        private static Sheet sheet;
        private static Workbook workbook;

        public static void setExcelFile(String path, String sheetName) throws Exception {
            FileInputStream file = new FileInputStream("C:\\Users\\Smart Axis\\eclipse-workspace\\Guru99\\src\\test\\resources\\Ligin.xlsx");
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
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
            return sheet.getPhysicalNumberOfRows();
        }

        public static int getColCount() {
            return sheet.getRow(0).getPhysicalNumberOfCells();
        }

        public static Object[][] getSheetData() {
            int rows = getRowCount();
            int cols = getColCount();

            Object[][] data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = getCellData(i, j);
                }
            }
            return data;
        }
    }