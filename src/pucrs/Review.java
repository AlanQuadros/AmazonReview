package pucrs;

public class Review {
	
	private double score;
	private long time;
	private String summary;
	private String text;
	private User users;
	private Product products;
	private Helpfulness help;
	
	public Review() {
		super();
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

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
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
	
	
	
}
