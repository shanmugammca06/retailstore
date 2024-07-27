package com.xische.retailstore.daos;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.xische.retailstore.Products;
import com.xische.retailstore.Users;
import com.xische.retailstore.dtos.ProductDto;
import com.xische.retailstore.dtos.UserDto;

/**
 * The BillingDaoImpl class implements the BillingDao interface and provides the
 * logic for generating bills based on the selected items and user details.
 * 
 * @author shanmugamr
 */
public class BillingDaoImpl implements BillingDao {

	private final int employeeDiscountPercentage = 30;
	private final int affiliateDiscountPercentage = 10;
	private final int oldCustomerDiscountPercentage = 5;
	private final DecimalFormat f = new DecimalFormat("##.00");
	private final ArrayList<UserDto> users = Users.getInstance().getUserInfo();
	private final ArrayList<ProductDto> products = Products.getInstance().getProductInfo();

	/**
	 * Generates a bill based on the selected items and user ID.
	 * 
	 * @param request a JSONObject containing the selected items.
	 * @param userId  the ID of the user for whom the bill is to be generated.
	 * @return a JSONObject representing the generated bill.
	 */
	@Override
	public JSONObject generateBill(JSONObject request, int userId) {
		JSONObject response = new JSONObject();
		try {
			UserDto userDto = users.stream().filter(user -> user.getId() == userId).findFirst()
					.orElseThrow(() -> new RuntimeException("Invalid User"));

			JSONArray selectedProducts = request.getJSONArray("products");

			double totalGroceryItemsPrice = 0.00;
			double totalNonGroceryItemsPrice = 0.00;
			for (int i = 0; i < selectedProducts.length(); i++) {
				JSONObject productJSON = selectedProducts.getJSONObject(i);

				ProductDto item = products.stream()
						.filter(product -> product.getId() == productJSON.getInt("productId")).findFirst()
						.orElseThrow(() -> new RuntimeException("Invalid product"));
				if (item.getCategory().equalsIgnoreCase("grocery")) {
					totalGroceryItemsPrice += (item.getPrice() * productJSON.getInt("quantity"));
				} else {
					totalNonGroceryItemsPrice += (item.getPrice() * productJSON.getInt("quantity"));
				}
			}

			JSONObject discounts = calculatePercentageDiscount(totalNonGroceryItemsPrice, userDto);
			double employeeDiscount = discounts.optDouble("employeeDiscount", 0.00);
			double affiliateDiscount = discounts.optDouble("affiliateDiscount", 0.00);
			double oldCustomerDiscount = discounts.optDouble("oldCustomerDiscount", 0.00);

			double finalPrice = totalGroceryItemsPrice
					+ (totalNonGroceryItemsPrice - employeeDiscount - affiliateDiscount - oldCustomerDiscount);
			int flatDiscount = (int) ((int) (finalPrice / 100) * 5);
			finalPrice = finalPrice - flatDiscount;

			response.put("grossGroceryPrice", f.format(totalGroceryItemsPrice));
			response.put("grossNonGroceryPrice", f.format(totalNonGroceryItemsPrice));
			response.put("employeeDiscount", f.format(employeeDiscount));
			response.put("affiliateDiscount", f.format(affiliateDiscount));
			response.put("oldCustomerDiscount", f.format(oldCustomerDiscount));
			response.put("flatDiscount", f.format(flatDiscount));
			response.put("netPayable", f.format(finalPrice));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	/**
	 * Calculates the percentage discounts based on the user's type and subscription
	 * date.
	 * 
	 * @param itemPrice the total price of non-grocery items.
	 * @param user      the UserDto object representing the user.
	 * @return a JSONObject containing the calculated discounts.
	 */
	private JSONObject calculatePercentageDiscount(double itemPrice, UserDto user) {
		JSONObject discountJSON = new JSONObject();
		try {
			switch (user.getType().toUpperCase()) {
			case "EMPLOYEE":
				discountJSON.put("employeeDiscount", ((itemPrice / 100) * employeeDiscountPercentage));
				break;
			case "AFFILIATE":
				discountJSON.put("affiliateDiscount", ((itemPrice / 100) * affiliateDiscountPercentage));
				break;
			default:
				break;
			}

			LocalDate currentDate = LocalDate.now();
			LocalDate subcriptionDate = user.getSubscriptionDate().toInstant().atZone(ZoneId.systemDefault())
					.toLocalDate();
			if (Period.between(subcriptionDate, currentDate).getYears() > 2) {
				discountJSON.put("oldCustomerDiscount", ((itemPrice / 100) * oldCustomerDiscountPercentage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return discountJSON;
	}
}
