package Pr7FoodShortage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<Buyer> buyerSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            Buyer buyer = Factory.createBuyer(input);
            buyerSet.add(buyer);
        }

        while (true) {
            String name = reader.readLine();
            if ("End".equals(name)) {
                break;
            }
            for (Buyer buyer : buyerSet) {
                if (buyer.getName().equals(name)) {
                    buyer.buyFood();
                }
            }
        }

        int sum = 0;
        for (Buyer buyer : buyerSet) {
            sum += buyer.getFood();
        }
        System.out.println(sum);
    }
}
