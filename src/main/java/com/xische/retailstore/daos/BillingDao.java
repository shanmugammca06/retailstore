package com.xische.retailstore.daos;

import org.json.JSONObject;

/**
 * The BillingDao interface defines the contract for generating bills.
 * Implementations of this interface are responsible for creating a bill based
 * on the selected items and user ID.
 * 
 * 
 * @author shanmugamr
 */
public interface BillingDao {

	/**
	 * Generates a bill based on the selected items and user ID.
	 * 
	 * @param selectedItems a JSONObject containing the items selected by the user.
	 * @param userId        the ID of the user for whom the bill is to be generated.
	 * @return a JSONObject representing the generated bill.
	 */
	public JSONObject generateBill(JSONObject selectedItems, int userId);
}
