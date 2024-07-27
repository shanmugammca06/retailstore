package com.xische.retailstore;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.xische.retailstore.daos.BillingDao;
import com.xische.retailstore.daos.BillingDaoImpl;

/**
 * This class contains unit tests for the RetailStore application. The tests
 * verify the correct functionality of the billing system.
 * 
 * @author shanmugamr
 */
@SpringBootTest
class RetailStoreApplicationTests {

	/**
	 * Test to ensure the application context loads successfully.
	 */
	@Test
	void contextLoads() {
		System.out.println("application running successfully");
	}

	/**
	 * Test for billing an employee user.
	 */
	@Test
	void userAsEmployee() {
		try {
			JSONObject cart = new JSONObject();
			JSONArray products = new JSONArray();
			JSONObject product = new JSONObject();
			product.put("productId", 123);
			product.put("quantity", 2);
			products.put(product);
			product = new JSONObject();
			product.put("productId", 124);
			product.put("quantity", 12);
			products.put(product);
			cart.put("products", products);
			BillingDao billingDao = new BillingDaoImpl();
			JSONObject response = billingDao.generateBill(cart, 4);

			assert (response.getDouble("affiliateDiscount") == 0);
			assert (response.getDouble("employeeDiscount") == 317.94);
			assert (response.getDouble("oldCustomerDiscount") == 0);
			assert (response.getDouble("flatDiscount") == 35);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test for billing an affiliate user.
	 */
	@Test
	void userAsAffiliate() {
		try {
			JSONObject cart = new JSONObject();
			JSONArray products = new JSONArray();
			JSONObject product = new JSONObject();
			product.put("productId", 123);
			product.put("quantity", 2);
			products.put(product);
			product = new JSONObject();
			product.put("productId", 124);
			product.put("quantity", 12);
			products.put(product);
			cart.put("products", products);
			BillingDao billingDao = new BillingDaoImpl();
			JSONObject response = billingDao.generateBill(cart, 3);

			assert (response.getDouble("affiliateDiscount") == 105.98);
			assert (response.getDouble("employeeDiscount") == 0);
			assert (response.getDouble("oldCustomerDiscount") == 0);
			assert (response.getDouble("flatDiscount") == 45);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test for billing a customer who has been subscribed for more than 2 years.
	 */
	@Test
	void customerSubscribed2YearsBefore() {
		try {
			JSONObject cart = new JSONObject();
			JSONArray products = new JSONArray();
			JSONObject product = new JSONObject();
			product.put("productId", 123);
			product.put("quantity", 2);
			products.put(product);
			product = new JSONObject();
			product.put("productId", 124);
			product.put("quantity", 12);
			products.put(product);
			cart.put("products", products);
			BillingDao billingDao = new BillingDaoImpl();
			JSONObject response = billingDao.generateBill(cart, 22);

			assert (response.getDouble("affiliateDiscount") == 0);
			assert (response.getDouble("employeeDiscount") == 0);
			assert (response.getDouble("oldCustomerDiscount") == 52.99);
			assert (response.getDouble("flatDiscount") == 50);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test for billing a general user.
	 */
	@Test
	void generalUser() {
		try {
			JSONObject cart = new JSONObject();
			JSONArray products = new JSONArray();
			JSONObject product = new JSONObject();
			product.put("productId", 123);
			product.put("quantity", 2);
			products.put(product);
			product = new JSONObject();
			product.put("productId", 124);
			product.put("quantity", 12);
			products.put(product);
			cart.put("products", products);
			BillingDao billingDao = new BillingDaoImpl();
			JSONObject response = billingDao.generateBill(cart, 22);

			assert (response.getDouble("affiliateDiscount") == 0);
			assert (response.getDouble("employeeDiscount") == 0);
			assert (response.getDouble("oldCustomerDiscount") == 52.99);
			assert (response.getDouble("flatDiscount") == 50);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
