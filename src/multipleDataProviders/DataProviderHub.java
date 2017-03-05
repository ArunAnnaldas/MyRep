package multipleDataProviders;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import util.ExcelRead;

public class DataProviderHub {

	@DataProvider(name = "DataRepository")
	public Object[][] CommonData(Method m, ITestContext cont) {

		System.out.println(m.getName());
		System.out.println(cont.getPassedTests());

		if (m.getName().equalsIgnoreCase("testLogin")) {
			Object[][] obj = null;
			ExcelRead read = new ExcelRead(
					"C:\\Users\\aannaldas\\Desktop\\Automation\\Training\\3.TestNG\\DataSheet.xlsx");

			int int_Row = read.fetchRowCount("Cred"); // 3
			int int_Col = read.getColumnCount("Cred"); // 2

			obj = new Object[int_Row - 1][int_Col];

			for (int i = 1; i < int_Row; i++) {
				for (int j = 0; j < int_Col; j++) {
					obj[i - 1][j] = read.getCellValue("Cred", j, i + 1);
				}
			}
			return obj;
		}

		else if (m.getName().equalsIgnoreCase("addProduct")) {
			Object[][] obj = null;
			ExcelRead read = new ExcelRead(
					"C:\\Users\\aannaldas\\Desktop\\Automation\\Training\\3.TestNG\\DataSheet.xlsx");

			int int_Row = read.fetchRowCount("ProductName"); // 3
			int int_Col = read.getColumnCount("ProductName"); // 2

			obj = new Object[int_Row - 1][int_Col];

			for (int i = 1; i < int_Row; i++) {
				for (int j = 0; j < int_Col; j++) {
					obj[i - 1][j] = read.getCellValue("ProductName", j, i + 1);
				}
			}
			return obj;
		}

		else {

			Object[][] obj = null;
			ExcelRead read = new ExcelRead(
					"C:\\Users\\aannaldas\\Desktop\\Automation\\Training\\3.TestNG\\DataSheet.xlsx");

			int int_Row = read.fetchRowCount("Search"); // 3
			int int_Col = read.getColumnCount("Search"); // 2

			obj = new Object[int_Row - 1][int_Col];

			for (int i = 1; i < int_Row; i++) {
				for (int j = 0; j < int_Col; j++) {
					obj[i - 1][j] = read.getCellValue("Search", j, i + 1);
				}
			}
			return obj;
		}

	}
	/*
	 * @DataProvider(name = "AddProduct") public Object[][] addProduct() {
	 * 
	 * Object[][] obj = null; ExcelRead read = new ExcelRead(
	 * "C:\\Users\\aannaldas\\Desktop\\Automation\\Training\\3.TestNG\\DataSheet.xlsx"
	 * );
	 * 
	 * int int_Row = read.fetchRowCount("ProductName"); // 3 int int_Col =
	 * read.getColumnCount("ProductName"); // 2
	 * 
	 * obj = new Object[int_Row - 1][int_Col];
	 * 
	 * for (int i = 1; i < int_Row; i++) { for (int j = 0; j < int_Col; j++) {
	 * obj[i - 1][j] = read.getCellValue("ProductName", j, i + 1); } } return
	 * obj; }
	 * 
	 * @DataProvider(name = "SearchProduct") public Object[][] ProductToSearch()
	 * {
	 * 
	 * Object[][] obj = null; ExcelRead read = new ExcelRead(
	 * "C:\\Users\\aannaldas\\Desktop\\Automation\\Training\\3.TestNG\\DataSheet.xlsx"
	 * );
	 * 
	 * int int_Row = read.fetchRowCount("Search"); // 3 int int_Col =
	 * read.getColumnCount("Search"); // 2
	 * 
	 * obj = new Object[int_Row - 1][int_Col];
	 * 
	 * for (int i = 1; i < int_Row; i++) { for (int j = 0; j < int_Col; j++) {
	 * obj[i - 1][j] = read.getCellValue("Search", j, i + 1); } } return obj; }
	 */
}
