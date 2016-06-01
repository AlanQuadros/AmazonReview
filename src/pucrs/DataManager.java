package pucrs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataManager {

	
	public void leitura(){
		Path path2 = Paths.get("Arts.txt");
		try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.forName("utf8")))) {
		  sc.useDelimiter("[\n]"); // separadores: nova linha
		  String productId, title, price;// atributos de Product
		  String summary, text, time, score; //atributos de Review
		  String userId, profileName;//atibutos de User
		  String positive, total;//atributos de Helpfulness
		  String next;
		  while (sc.hasNext()) {
			  next = sc.next();
			  productId = next.substring(next.indexOf(":")+2);
			  next = sc.next();
			  title = next.substring(next.indexOf(":")+2);
			  next = sc.next();
			  price = next.substring(next.indexOf(":")+2);
			  next = sc.next();
			  userId = next.substring(next.indexOf(":")+2);
			  next = sc.next();
			  profileName = next.substring(next.indexOf(":")+2);
			  next = sc.next();
			  String help = next.substring(next.indexOf(":")+2);
			  String[] helpArray = help.split("/");
			  positive = helpArray[0];
			  total = helpArray[1];
			  next = sc.next();
			  score = next.substring(next.indexOf(":")+2);
			  next = sc.next();
			  time = next.substring(next.indexOf(":")+2);
			  next = sc.next();
			  summary = next.substring(next.indexOf(":")+2);
			  next = sc.next();
			  text = next.substring(next.indexOf(":")+2);
			  sc.next();
			  
			  Product product = new Product(productId, title, Double.parseDouble(price));
			  Review review = new Review(Double.parseDouble(score), Long.parseLong(time), summary, text);
			  User user = new User(userId, profileName);
			  Helpfulness helpfulness = new Helpfulness(Integer.parseInt(positive), Integer.parseInt(total));
		  }
		}
		catch (IOException x) {
		  System.err.format("Erro de E/S: %s%n", x);
		}
	}
}
