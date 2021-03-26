package Tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static class Product {
        int id;
        String productName;
        String price;
        String quantity;

        public Product(int id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }


        @Override
        public String toString() {

            return String.format("%-8d%-30s%-8s%-4s", id, productName, price, quantity);
        }
    }


    public static Product getProduct(String string) {
        String id = string.substring(0, 8).trim();


        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);

    }

    public static void main(String[] args) throws Exception {

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "C:\\Users\\admin\\IdeaProjects\\TheFirstOne\\src\\someFile";

        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                Product product = getProduct(fileReader.readLine());
                products.add(product);
            }
            switch (args[0]) {
                case "-u":
                    int id = Integer.parseInt(args[1]);
                    String name = "";
                    for (int index = 2; index < args.length - 2; index++) {
                        name += args[index] + " ";
                        System.out.println(name);
                    }

            }
        }

    }

}
