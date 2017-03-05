package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static String filename = "";
	private XSSFSheet workSheet = null;
	private XSSFRow sheetRow = null;
	public String path;
	public FileInputStream fileInput = null;
	public FileOutputStream fileOutput = null;
	private XSSFWorkbook workbook = null;
	private XSSFCell cell = null;

	public ExcelRead(String path) {

		this.path = path;
		try {
			fileInput = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileInput);
			workSheet = workbook.getSheetAt(0);
			fileInput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// return number of rows
	public int fetchRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			workSheet = workbook.getSheetAt(index);
			int number = workSheet.getLastRowNum() + 1;
			return number;
		}
	}

	// returns true is cell is updated
	public boolean setCellValue(String sheetName, String colName, int rowNum, String data) {
		try {
			fileInput = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileInput);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			workSheet = workbook.getSheetAt(index);

			sheetRow = workSheet.getRow(0);
			for (int i = 0; i < sheetRow.getLastCellNum(); i++) {
				// System.out.println(sheetRow.getCell(i).getStringCellValue().trim());
				if (sheetRow.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			workSheet.autoSizeColumn(colNum);
			sheetRow = workSheet.getRow(rowNum - 1);
			if (sheetRow == null)
				sheetRow = workSheet.createRow(rowNum - 1);

			cell = sheetRow.getCell(colNum);
			if (cell == null)
				cell = sheetRow.createCell(colNum);

			// cell style
			// CellStyle cs = workbook.createCellStyle();
			// cs.setWrapText(true);
			// cell.setCellStyle(cs);
			cell.setCellValue(data);

			fileOutput = new FileOutputStream(path);

			workbook.write(fileOutput);

			fileOutput.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// check whether work sheet exists or not
	public boolean isSheetPresent(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	// returns the cell value
	public String getCellValue(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			workSheet = workbook.getSheetAt(index);
			sheetRow = workSheet.getRow(0);
			for (int i = 0; i < sheetRow.getLastCellNum(); i++) {
				if (sheetRow.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			workSheet = workbook.getSheetAt(index);
			sheetRow = workSheet.getRow(rowNum - 1);
			if (sheetRow == null)
				return "";
			cell = sheetRow.getCell(col_Num);

			if (cell == null)
				return "";
			// System.out.println(cell.getCellType());
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

					// System.out.println(cellText);

				}

				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	// returns the cell value
	public String getCellValue(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			workSheet = workbook.getSheetAt(index);
			sheetRow = workSheet.getRow(rowNum - 1);
			if (sheetRow == null)
				return "";
			cell = sheetRow.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

					// System.out.println(cellText);

				}

				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}

	// return number of columns
	public int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetPresent(sheetName))
			return -1;

		workSheet = workbook.getSheet(sheetName);
		sheetRow = workSheet.getRow(0);

		if (sheetRow == null)
			return -1;

		return sheetRow.getLastCellNum();

	}

	public int getCellRowNum(String sheetName, String colName, String cellValue) {

		for (int i = 2; i <= fetchRowCount(sheetName); i++) {
			if (getCellValue(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;

	}

}
