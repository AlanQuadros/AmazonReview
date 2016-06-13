package pucrs;

import java.util.ArrayList;

public class Product implements Comparable<Product> {

	public final double UNKOWN_PRICE = -1;
	public final double UNDEFINED_PRICE = -2;
	private String productId;
	private String title;
	private Double price;// Cuidado, price pode ser null
	private ArrayList<Review> reviews = new ArrayList<>();

	public Product() {
		super();
	}

	public Product(String productId, String title, Double price) {
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

	public void addReview(Review review) {
		reviews.add(review);
	}

	public ArrayList<Review> getAllReviews() {
		return reviews;
	}

	public int getAllReviewsSize() {
		return reviews.size();
	}

	public Double getAverageReview() {
		double all = 0;
		for(Review r : reviews){
			all+= r.getScore();
		}
		return all/reviews.size();
	}

	@Override
	public int compareTo(Product o) {
		return this.getAverageReview().compareTo(o.getAverageReview());
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Product){
			Product p = (Product) o;
			return this.productId.equalsIgnoreCase(p.productId);
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int hashcode = 0;
		hashcode += this.productId.hashCode();
		return hashcode;
	}
}
