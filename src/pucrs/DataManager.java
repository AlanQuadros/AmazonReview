package pucrs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataManager {

	
	public void leitura(){
		Path path2 = Paths.get("dados.txt");
		try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.forName("utf8")))) {
		  sc.useDelimiter("[\n]"); // separadores: nova linha
		  String productId, title, price; // atributos de Product
		  while (sc.hasNext()) {
//		    nome = sc.next();
//		    data = sc.nextLine();
//		    cpf = sc.next();
//		    System.out.format("%s - %s (%s)%n", nome, data, cpf);
		  }
		}
		catch (IOException x) {
		  System.err.format("Erro de E/S: %s%n", x);
		}
	}
}
