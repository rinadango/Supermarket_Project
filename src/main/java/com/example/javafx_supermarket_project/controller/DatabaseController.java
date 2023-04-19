package com.example.javafx_supermarket_project.controller;

import com.example.javafx_supermarket_project.model.Product;
import org.apache.commons.configuration.ConfigurationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseController {

    public static ArrayList<Product> allProductsList = new ArrayList<>();

    public String filePath = "src/main/resources/databaseProducts.txt";

    public void readDatabase() throws IOException {

        // Read from file
        FileReader fileReader = new FileReader(this.filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String singleLine = bufferedReader.readLine(); // skaito tik pirma eilute is failo

        int productID = 1;
        while (singleLine != null) {
            String[] splitString = singleLine.split(",");
            String productName = splitString[0];
            Integer quantity = Integer.parseInt(splitString[1]); // comvert String to Integer
            Double price = Double.parseDouble(splitString[2]); // convert String to Double

            Product product = new Product(productID++, productName, quantity, price);

            allProductsList.add(product);

            singleLine = bufferedReader.readLine(); // Be sito neskaitys kitos eilutes, tad sitas kita eilute skaito
        }

        bufferedReader.close();
        //System.out.println("Database was created. " + (productID-1) + " products were added.");
        //System.out.println(products);

    }

    public void writeDatabase() throws IOException{

        // For test
        //FileWriter fileWriter = new FileWriter("src/main/resources/databaseProducts_copy.txt");

        FileWriter fileWriter = new FileWriter(this.filePath, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Product product : allProductsList) {
            bufferedWriter.write(product.getName()+","+product.getQuantity()+","+product.getPrice());
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();

    }

    public void showAllProducts(){
        for (Product product : allProductsList) {
            System.out.println(product);
        }
    }

    public String showAllAsString(ArrayList<Product> arrayList){

        String asStringProductsArray = arrayList.toString().replaceAll("\\[|\\]", "").replaceAll(", ","");

        return asStringProductsArray;

    }

    public static ArrayList<Product> getAllProductsList() {
        return allProductsList;
    }

    public static void setAllProductsList(ArrayList<Product> allProductsList) {
        DatabaseController.allProductsList = allProductsList;
    }
}
