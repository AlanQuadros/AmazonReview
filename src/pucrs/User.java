package pucrs;

import java.util.ArrayList;

public class User {

	private String userId;
	private String profileName;
	private ArrayList<Review> reviews = new ArrayList<>();
	
	public User() {
		super();
	}
	
	public User(String userId, String profileName) {
		super();
		this.userId = userId;
		this.profileName = profileName;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Review getReview(int index) {
		return reviews.get(index);
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public ArrayList<Review> returnAllReviews(){
		return reviews;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof User){
			User u = (User) o;
			return this.userId.equalsIgnoreCase(u.userId);
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int hashcode = 0;
		hashcode += this.userId.hashCode();
		return hashcode;
	}
}
