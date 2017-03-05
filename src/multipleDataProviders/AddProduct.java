package multipleDataProviders;

import org.testng.ITestContext;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice
public class AddProduct {

	@Test(dataProvider = "DataRepository", dataProviderClass = DataProviderHub.class)
	public void addProduct(String Product, ITestContext context) {

		System.out.println("Product " + Product + " is added successfully." + " with thread id : "
				+ Thread.currentThread().getId());

		// code to add the product. After adding the product, unique id gets
		// generated. We want to save it.

		context.setAttribute("AddProduct1ID", 45678);

	}
}
