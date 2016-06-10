package pucrs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DataManager {

	ArrayList<Product> products = new ArrayList<>();
	ArrayList<Review> reviews = new ArrayList<>();
	ArrayList<User> users = new ArrayList<>();

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
				review.setHelp(help);
				User user = new User(userId, profileName);
				Product product = new Product(productId, title, doublePrice);

				boolean isNewProduct = true;

				for (Product p : products) {
					if (p.getProductId().equalsIgnoreCase(product.getProductId())) {
						product = p;
						isNewProduct = false;
						break;
					}
				}

				if (isNewProduct) {
					products.add(product);
				}

				boolean isNewUser = true;

				for (User u : users) {
					if (u.getUserId().equalsIgnoreCase(user.getUserId())) {
						user = u;
						isNewUser = false;
						break;
					}
				}

				if (isNewUser) {
					users.add(user);
				}

				reviews.add(review);
				product.addReview(review);
				user.addReview(review);
			}
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
	}

	public Product searchInfoProductById(int id) {
		Product result = new Product();
		for (Product p : products) {
			if (p.getProductId() == Integer.toString(id)) {
				result = p;
			}
		}

		return result;
	}

	public User searchInfoUserByIdName(int id) {
		User result = new User();
		for (User u : users) {
			if (u.getUserId() == Integer.toString(id)) {
				result = u;
			}
		}

		return result;
	}

	public User searchInfoUserByIdName(String name) {
		User result = new User();
		for (User u : users) {
			if (u.getProfileName().toUpperCase().contains(name.toUpperCase())) {
				result = u;
			}
		}

		return result;
	}

	public ArrayList<Review> searchReviewByString(String partOfString) {
		ArrayList<Review> result = new ArrayList<>();

		for (Review r : reviews) {
			if (r.getText().toUpperCase().contains(partOfString.toUpperCase())) {
				result.add(r);
			}
		}
		Collections.sort(result);
		return result;
	}

	public ArrayList<Product> getBestReviewed() {
		ArrayList<Product> result = new ArrayList<>();
		
		for (Product p : products) {
			if (p.getAllReviewsSize() >= 10) {
				result.add(p);
			}
		}

		Collections.sort(result);
		
		while(result.size() > 20){
			result.remove(result.size()-1);
		}
		
		return result;
	}

}
