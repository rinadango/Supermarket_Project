package com.example.javafx_supermarket_project.controller;

import com.example.javafx_supermarket_project.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SupermarketController {

    DatabaseController databaseController = new DatabaseController();

    public static ArrayList<String> basket = new ArrayList<>();

    public static Double price = 0.0;

    public ArrayList<Product> allProducts = DatabaseController.allProductsList;

    public void addItemToBasket(String item){

        try{ // add logic to modify allProducts and basket lists

            for (Product product : allProducts) {

                if(product.getName().equalsIgnoreCase(item) && product.getQuantity() > 0){
                    basket.add(product.getName());
                    price = price + product.getPrice();
                    product.setQuantity(product.getQuantity()-1);
                }

            }

            System.out.println(basket);
            System.out.println(allProducts);

            databaseController.writeDatabase();

        } catch (IOException exception){
        exception.printStackTrace();
        }

    }


    public String showAllAsStringBasket(){

        String asStringProductsArray = basket.toString().replaceAll("\\[|\\]", "");

        return asStringProductsArray + "\n\n| Price: " +  String.format("%.2f", price) + " EUR";

    }

}
