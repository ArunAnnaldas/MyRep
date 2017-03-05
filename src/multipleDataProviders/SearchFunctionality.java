package multipleDataProviders;

import org.testng.ITestContext;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice
public class SearchFunctionality {

	@Test(dataProvider = "DataRepository", dataProviderClass = DataProviderHub.class)
	public void searchProduct(String ProductName, ITestContext cont) {
		System.out.println("Search is successful for Product Name : " + ProductName + " with thread id : "
				+ Thread.currentThread().getId());

		System.out.println(cont.getAttribute("AddProduct1ID"));
	}
}
