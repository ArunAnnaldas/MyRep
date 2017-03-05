package TestNGAnnotations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.ExcelRead;

public class DataProviderExample {

	@Test(dataProvider = "ExcelValues")
	public void displayData(String UserName, String Password) {

		System.out.println(UserName);
		System.out.println(Password);

	}

	@DataProvider(name = "fetchData")
	public Object[][] test1() {
		return new Object[][] { { "User1", "Pwd1" }, { "User2", "Pwd2" } };
	}

	@DataProvider(name = "ExcelValues")
	public Object[][] test2() {

		Object[][] obj = null;
		ExcelRead read = new ExcelRead("C:\\Users\\aannaldas\\Desktop\\Automation\\Training\\3.TestNG\\DataSheet.xlsx");

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

}
