package pucrs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataManager {

	
	public void leitura(){
		Path path2 = Paths.get("arts.txt");
		try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.forName("utf8")))) {
		  sc.useDelimiter("[\n]"); // separadores: nova linha
		  String productId, title;
		  double price;// atributos de Product
		  String summary, text; //atributos de Review
		  long time;//atributos de Review
		  double score;//atributos de Review
		  String userId, profileName;//atibutos de User
		  int positive, total;
		  while (sc.hasNext()) {
			  productId = sc.nextLine();
			  sc.next();
			  title = sc.nextLine();
			  sc.next();
			  price = Double.parseDouble(sc.next());
			  sc.next();
			  userId = sc.nextLine();
			  sc.next();
			  profileName = sc.nextLine();
			  sc.next();
			  String help = sc.next();
			  String[] helpArray = help.split("/");
			  positive = Integer.parseInt(helpArray[0]);
			  total = Integer.parseInt(helpArray[1]);
			  sc.next();
			  time = Long.parseLong(sc.next());
			  sc.next();
			  summary = sc.nextLine();
			  sc.next();
			  text = sc.nextLine();
			  sc.next();
		  }
		}
		catch (IOException x) {
		  System.err.format("Erro de E/S: %s%n", x);
		}
	}
}
