package pucrs;

import java.util.ArrayList;

public class Product {

	public final double UNKOWN_PRICE = -1;
	public final double UNDEFINED_PRICE = -2;
	private String productId;
	private String title;
	private Double price;//Cuidado, price pode ser null
	private ArrayList<Review> reviews;
	
	public Product() {
		super();
	}
	
	

	public Product(String productId, String title, double price) {
		super();
		this.productId = productId;
		this.title = title;
		this.price = price;
	}



	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Review getReview(int index) {
		return reviews.get(index);
	}

	public void setReview(Review review) {
		reviews.add(review);
	}
	
	
	
}
