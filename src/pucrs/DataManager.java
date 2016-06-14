package pucrs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DataManager {

	HashMap<Product, ArrayList<Review>> productReview = new HashMap<>();
	HashMap<User, ArrayList<Review>> userReview = new HashMap<>();
	ArrayList<Review> allReview = new ArrayList<>();

	public void leitura() {
		Path path2 = Paths.get("Arts.txt");
		try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.forName("utf8")))) {
			sc.useDelimiter("[\n]"); // separadores: nova linha
			String productId, title, price;// atributos de Product
			String summary, text, time, score; // atributos de Review
			String userId, profileName;// atibutos de User
			String positive, total;// atributos de Helpfulness
			String next;
			while (sc.hasNext()) {

				// faz a leitura já pegando apenas a informação importante
				next = sc.next();
				productId = next.substring(next.indexOf(":") + 2);
				next = sc.next();
				title = next.substring(next.indexOf(":") + 2);
				next = sc.next();
				price = next.substring(next.indexOf(":") + 2);
				next = sc.next();
				userId = next.substring(next.indexOf(":") + 2);
				next = sc.next();
				profileName = next.substring(next.indexOf(":") + 2);
				next = sc.next();
				String helpString = next.substring(next.indexOf(":") + 2);
				String[] helpArray = helpString.split("/");
				positive = helpArray[0];
				total = helpArray[1];
				next = sc.next();
				score = next.substring(next.indexOf(":") + 2);
				next = sc.next();
				time = next.substring(next.indexOf(":") + 2);
				next = sc.next();
				summary = next.substring(next.indexOf(":") + 2);
				next = sc.next();
				text = next.substring(next.indexOf(":") + 2);
				sc.next();

				Double doublePrice;
				if (price.matches("[0-9]*"))
					doublePrice = Double.parseDouble(price);
				else
					doublePrice = null;// o importante é funcionar

				// insere os atributos
				Helpfulness help = new Helpfulness(Integer.parseInt(positive), Integer.parseInt(total));
				Review review = new Review(Double.parseDouble(score), Long.parseLong(time), summary, text);
				User user = new User(userId, profileName);
				Product product = new Product(productId, title, doublePrice);
				review.setHelp(help);
				review.setUser(user);
				allReview.add(review);
				
				if (!productReview.containsKey(product)) {
					ArrayList<Review> reviews = new ArrayList<>();
					productReview.put(product, reviews);
				} else {
					ArrayList<Review> reviews = productReview.get(product);
					reviews.add(review);
					productReview.replace(product, reviews);
				}

				if (!userReview.containsKey(user)) {
					ArrayList<Review> reviews = new ArrayList<>();
					reviews.add(review);
					userReview.put(user, reviews);
				} else {
					ArrayList<Review> reviews = userReview.get(user);
					reviews.add(review);
				}
			}
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
	}

	public Product searchProductById(String search) {
		for (Product p : productReview.keySet()) {
			if (p.getProductId().equalsIgnoreCase(search))
				return p;
		}

		return null;
	}
        
        public Product searchProductByName(String search) {
            for (Product p : productReview.keySet()) {
                if (p.getTitle().toUpperCase().contains(search.toUpperCase()))
                    return p;
            }

            return null;
	}

	public User searchUserById(String search) {
            for (User u : userReview.keySet()) {
                if (u.getUserId().equalsIgnoreCase(search))
                    return u;
            }
            return null;
	}
        
        public User searchUserByName(String search) {
            for (User u : userReview.keySet()) {
                if (u.getProfileName().toUpperCase().contains(search.toUpperCase()))
                    return u;
            }
            return null;
	}

	public ArrayList<Review> searchReviewByString(String partOfString) {
		ArrayList<Review> result = new ArrayList<>();

		for (Review r : allReview) {
			if (r.getText().toUpperCase().contains(partOfString.toUpperCase())) {
				result.add(r);
			}
		}
		
		Collections.sort(result);
		
		return result;
	}
	
	public ArrayList<Product> getBestReviewed(){
		HashMap<Product, Double> productBestReview = new HashMap<>();
		
		for(Product p : productReview.keySet()){
			ArrayList<Review> allReviews = productReview.get(p);
			if(allReviews.size() >= 10){
				double averageReview = averageReview(allReviews);
				productBestReview.put(p, averageReview);
			}
		}
		
		productBestReview = productBestReview.entrySet().stream()
				.sorted(Map.Entry.<Product,Double> comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		ArrayList<Product> averageReviews = new ArrayList<>(productBestReview.keySet());
		
		while(averageReviews.size() > 20){
			averageReviews.remove(averageReviews.size()-1);
		}
		
		return averageReviews;
	}
	
	public ArrayList<User> getUsefulUsers(){
		HashMap<User, Double> usefulUser = new HashMap<>(); 
		
		for (User user : userReview.keySet()) {
			ArrayList<Review> userReviews = userReview.get(user);
			double positive = 0;
			double total = 0;
			for (Review review : userReviews) {
				positive += review.getHelp().getPositive();
				total += review.getHelp().getTotal();
			}
			if (total > 0) {
				Double useful = positive/total;  
				usefulUser.put(user, useful);
			}
		}
		usefulUser = usefulUser.entrySet().stream()
				.sorted(Map.Entry.<User,Double> comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		ArrayList<User> usefulList = new ArrayList<>(usefulUser.keySet());
		
		while(usefulList.size() > 20){
			usefulList.remove(usefulList.size()-1);
		}
		
		return usefulList;
	}
	
	public void assessmentsPerMonth(){
		
		for (User user : userReview.keySet()) {
			ArrayList<Review> userReviews = userReview.get(user);
			
		}
	}
	
 	private Double averageReview(ArrayList<Review> reviews){
		double result = 0;
		
		for(Review r : reviews){
			result += r.getScore();
		}
		
		return result/reviews.size();
	}
	
}
