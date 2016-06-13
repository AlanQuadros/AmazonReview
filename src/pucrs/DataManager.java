package pucrs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

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
					userReview.put(user, reviews);
				} else {
					ArrayList<Review> reviews = userReview.get(user);
					reviews.add(review);
					userReview.put(user, reviews);
				}
			}
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
	}

	public Product searchProductByIdName(String search) {
		for (Product p : productReview.keySet()) {
			if (p.getProductId().equalsIgnoreCase(search))
				return p;
			else if (p.getTitle().toUpperCase().contains(search.toUpperCase()))
				return p;
		}

		return null;
	}

	public User searchUserByIdName(String search) {
		for (User u : userReview.keySet()) {
			if (u.getUserId().equalsIgnoreCase(search))
				return u;
			else if (u.getProfileName().toUpperCase().contains(search.toUpperCase()))
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
		HashMap<Integer, Product> idProduct = new HashMap<>();
		HashMap<Double, Integer> idReview = new HashMap<>();
		ArrayList<Product> result = new ArrayList<>();

		
		for(Product p : productReview.keySet()){
			ArrayList<Review> allReviews = productReview.get(p);
			if(allReviews.size() >= 10){
				int id = new Random().nextInt();
				double averageReview = averageReview(allReviews);
				productBestReview.put(p, averageReview);
				idProduct.put(id, p);
				idReview.put(averageReview, id);
			}
		}
		
		List<Double> averageReviews = new ArrayList<>(productBestReview.values());
		
		Collections.sort(averageReviews);
		
		while(averageReviews.size() > 20){
			averageReviews.remove(averageReviews.size()-1);
		}
		
		for(Double b : averageReviews){
			result.add(idProduct.get(idReview.get(b)));
		}
		
		return result;
	}
	
	public ArrayList<User> getUsefulUsers(){
		HashMap<User, Integer> usefulUser = new HashMap<>(); 
		HashMap<Integer, User> idUser = new HashMap<>();
		HashMap<Integer, Integer> idUseful = new HashMap<>();
		ArrayList<User> result = new ArrayList<>();
		
		for (User user : userReview.keySet()) {
			int id = new Random().nextInt();
			ArrayList<Review> userReviews = userReview.get(user);
			int positive = 0;
			int total = 0;
			for (Review review : userReviews) {
				positive = review.getHelp().getPositive();
				total = review.getHelp().getTotal();
			}
			Integer useful = positive/total;  
			usefulUser.put(user, useful);
			idUser.put(id, user);
			idUseful.put(useful, id);
		}
		
		List<Integer> usefulList = new ArrayList<>(usefulUser.values());
		Collections.sort(usefulList);
		
		while(usefulList.size() > 20){
			usefulList.remove(usefulList.size()-1);
		}
		
		for (Integer i : usefulList) {
			result.add(idUser.get(idUseful.get(i)));
		}
		
		return result;
	}
	
	private Double averageReview(ArrayList<Review> reviews){
		double result = 0;
		
		for(Review r : reviews){
			result += r.getScore();
		}
		
		return result/reviews.size();
	}
	
}
