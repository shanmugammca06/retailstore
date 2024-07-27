/**
 * 
 */
package com.xische.retailstore.dtos;

/**
 * The ProductDto class represents a Data Transfer Object (DTO) for products. It
 * encapsulates the data related to a product, including its ID, name, category,
 * and price.
 * 
 * This class is used to transfer product data between different layers of the
 * application.
 * 
 * @author shanmugamr
 * @see java.io.Serializable
 */
public class ProductDto {

	private int id;
	private String productName;
	private String category;
	private double price;

	/**
	 * Gets the ID of the product.
	 * 
	 * @return the product ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of the product.
	 * 
	 * @param id the product ID to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name of the product.
	 * 
	 * @return the product name.
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the name of the product.
	 * 
	 * @param productName the product name to set.
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the category of the product.
	 * 
	 * @return the product category.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category of the product.
	 * 
	 * @param category the product category to set.
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the price of the product.
	 * 
	 * @return the product price.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the product.
	 * 
	 * @param price the product price to set.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}