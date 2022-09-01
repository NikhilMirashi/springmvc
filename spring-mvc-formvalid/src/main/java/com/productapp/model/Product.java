package com.productapp.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


public class Product {
	
	@Size(min=5,max=10)
	private String productName;
	@Min(1)
	@Max(25)
	private Integer productId;
	private double productRatings;
	private double productPrice;
	private String productBrand;
	
	public Product() {
		super();
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public double getProductRatings() {
		return productRatings;
	}
	public void setProductRatings(double productRatings) {
		this.productRatings = productRatings;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productId=" + productId + ", productRatings=" + productRatings
				+ ", productPrice=" + productPrice + ", productBrand=" + productBrand + "]";
	}
	
	

}
