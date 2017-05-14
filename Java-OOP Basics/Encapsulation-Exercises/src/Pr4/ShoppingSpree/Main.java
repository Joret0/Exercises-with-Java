package Pr4.ShoppingSpree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        try {
            String[] people = reader.readLine().split(";");
            for (String personData : people) {
                int index = personData.indexOf("=");
                String name = personData.substring(0, index);
                double money = Double.parseDouble(personData.substring(index + 1));
                Person person = new Person(name, money);
                personList.add(person);
            }
            String[] products = reader.readLine().split(";");
            for (String productData : products) {
                int index = productData.indexOf("=");
                String productName = productData.substring(0, index);
                double productCost = Double.parseDouble(productData.substring(index + 1));
                Product product = new Product(productName, productCost);
                productList.add(product);
            }

            while (true) {
                String[] params = reader.readLine().split("\\s+");
                if (params[0].equals("END")) {
                    break;
                }
                String personName = params[0];
                String productName = params[1];
                for (Person person : personList) {
                    if (person.getName().equals(personName)) {
                        for (Product product : productList) {
                            if (product.getName().equals(productName)) {
                                person.addProduct(product);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            personList.stream().forEach(System.out::println);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
