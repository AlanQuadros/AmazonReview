package pucrs;

import java.util.Comparator;

public class Review implements Comparable<Review>{
	
	private double score;
	private long time;
	private String summary;
	private String text;
	private User user;
	private Product products;
	private Helpfulness help;
	
	public Review() {
		super();
	}

	
	
	public Review(double score, long time, String summary, String text) {
		super();
		this.score = score;
		this.time = time;
		this.summary = summary;
		this.text = text;
	}



	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User users) {
		this.user = users;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public Helpfulness getHelp() {
		return help;
	}

	public void setHelp(Helpfulness help) {
		this.help = help;
	}

	@Override
	public int compareTo(Review o) {
		return this.products.getTitle().compareTo(o.getProducts().getTitle());
	}	
}
