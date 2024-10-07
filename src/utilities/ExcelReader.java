package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static Map<String, String> readDataFromExcel(String filePath, String sheetName) throws IOException {
		
		Map<String, String> dataMap = new HashMap<>();

		try (FileInputStream fis = new FileInputStream(filePath); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// Find the row containing column headers
			Row headerRow = sheet.getRow(0);

			// Iterate through rows starting from the second row (data starts from the
			// second row)
			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				Row currentRow = sheet.getRow(i);
				if (currentRow != null) {
					for (int j = 0; j < headerRow.getLastCellNum(); j++) {
						Cell headerCell = headerRow.getCell(j);
						Cell currentCell = currentRow.getCell(j);

						if (headerCell != null && currentCell != null && headerCell.getCellType() == CellType.STRING) {
							String columnName = headerCell.getStringCellValue();
							String cellValue = currentCell.getStringCellValue();
							dataMap.put(columnName, cellValue);
						}
					}
				}
			}
		}

		return dataMap;
	}

}
