/**
 * 
 */
package com.xische.retailstore;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.xische.retailstore.dtos.ProductDto;

/**
 * The Products class is a singleton component that manages a collection of
 * ProductDto objects. It reads product data from a file and initializes the
 * products list.
 * 
 * This class ensures that only one instance of the Products class exists and
 * provides a global point of access to it.
 * 
 * @author shanmugamr
 */
@Component
public class Products {

	private static Products instance;
	private ArrayList<ProductDto> productInfo = new ArrayList<>();

	/**
	 * Private constructor for the singleton pattern. Reads product data from a file
	 * and initializes the products list.
	 * 
	 * The file is expected to be located at "classpath:templates/productdetails.db"
	 * and should contain user data in a tab-separated format.
	 */
	private Products() {
		try {
			File file = ResourceUtils.getFile("classpath:templates/productdetails.db");
			List<String> lines = FileUtils.readLines(file, Charset.defaultCharset());

			for (String line : lines) {
				if (line.startsWith("#")) {
					continue;
				}
				ProductDto product = new ProductDto();
				String[] lineSplit = line.split("\t");
				product.setId(Integer.parseInt(lineSplit[0]));
				product.setProductName(lineSplit[1]);
				product.setPrice(Double.parseDouble(lineSplit[2]));
				product.setCategory(lineSplit[3]);
				this.productInfo.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the singleton instance of the Products class.
	 * 
	 * @return the singleton instance of the Products class.
	 */
	public static synchronized Products getInstance() {
		if (instance == null) {
			instance = new Products();
		}
		return instance;
	}

	/**
	 * Returns the list of ProductDto objects.
	 * 
	 * @return an ArrayList of ProductDto objects.
	 */
	public ArrayList<ProductDto> getProductInfo() {
		return productInfo;
	}
}
