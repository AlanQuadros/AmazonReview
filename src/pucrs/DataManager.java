package pucrs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
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

                double doublePrice;
                if (!price.equalsIgnoreCase("unknown"))
                    doublePrice = Double.parseDouble(price);
                else
                    doublePrice = -1;// o importante é funcionar

                // insere os atributos
                Helpfulness help = new Helpfulness(Integer.parseInt(positive), Integer.parseInt(total));
                Review review = new Review(Double.parseDouble(score), Long.parseLong(time), summary, text);
                User user = new User(userId, profileName);
                Product product = new Product(productId, title, doublePrice);
                review.setHelp(help);
                review.setUser(user);
                review.setProducts(product);
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

    public ArrayList<Review> getReviewByUser(User user){
        return userReview.get(user);
    }
        
    public ArrayList<Review> getReviewByProduct(Product product){
        return productReview.get(product);
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

        productBestReview = productBestReview.entrySet().parallelStream()
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
        usefulUser = usefulUser.entrySet().parallelStream()
                        .sorted(Map.Entry.<User,Double> comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        ArrayList<User> usefulList = new ArrayList<>(usefulUser.keySet());

        while(usefulList.size() > 20){
            usefulList.remove(usefulList.size()-1);
        }

        return usefulList;
    }
	
    public HashMap<LocalDateTime, Integer> assessmentsPerMonth(LocalDateTime mesInicio, LocalDateTime mesFim){

        HashMap<LocalDateTime, Integer> assessments = new HashMap<>();

        LocalDate hora = LocalDate.now();
        for (Review review : allReview) {
            long time1 = review.getTime();
            LocalDateTime time2 = LocalDateTime.ofInstant(Instant.ofEpochSecond(time1), ZoneOffset.UTC);
            time2 = time2.minusDays(time2.getDayOfMonth()-1);
            time2 = time2.minusHours(time2.getHour());
            if (time2.isEqual(mesInicio)||time2.isEqual(mesFim)||(time2.isAfter(mesInicio)&&time2.isBefore(mesFim))) {
                if (assessments.containsKey(time2)) {
                    assessments.replace(time2, assessments.get(time2)+1);
                }else{
                    assessments.put(time2, 1);
                }
            }
        }

        assessments = assessments.entrySet().parallelStream()
                .sorted(Map.Entry.<LocalDateTime,Integer>comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return assessments;
    }
        
    public HashMap<Integer,Integer> amountReviewsByUser(){
        
        HashMap<Integer,Integer> amount = new HashMap<>();//<qtdAvaliações,numeroUsuarios>
        for (User user : userReview.keySet()) {
            int reviewsNumber = userReview.get(user).size();
            if (amount.containsKey(reviewsNumber)) {
                    amount.replace(reviewsNumber, amount.get(reviewsNumber)+1);
                }else{
                    amount.put(reviewsNumber, 1);
                }
        }
        amount = amount.entrySet().parallelStream()
                .sorted(Map.Entry.<Integer,Integer>comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        return amount;

    }
	
    public double averageReview(ArrayList<Review> reviews){
        double result = 0;

        for(Review r : reviews){
            result += r.getScore();
        }

        return result/reviews.size();
    }       
	
}
