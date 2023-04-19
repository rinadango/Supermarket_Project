package com.example.javafx_supermarket_project.controller;

import com.example.javafx_supermarket_project.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

public class GUIController {

    DatabaseController databaseController = new DatabaseController();
    SupermarketController supermarketController = new SupermarketController();

    @FXML
    private TextArea showStuff;
    @FXML
    private TextArea inputItem;
    @FXML
    private TextArea showBasketView;
    @FXML
    protected void onShowAllButtonClick() {

        try{
            databaseController.readDatabase();

            // Checks if the list is not empty
            // If not empty, clear and then read the txt file into a list again
            if(!DatabaseController.allProductsList.isEmpty()){
                DatabaseController.allProductsList.clear();
                databaseController.readDatabase();
            }

        } catch (IOException exception){
            exception.printStackTrace();
        }

        showStuff.setText(databaseController.showAllAsString(DatabaseController.allProductsList));
        
    }
    @FXML
    protected void onAddItemToBasketClick(){

        String item = inputItem.getText();

        for (Product product : DatabaseController.allProductsList) {

            if(Objects.equals(product.getName(), item) && product.getQuantity() <= 0){

                String message = item + "is sold out!";
                inputItem.setText(message);

            } else{
                break;
            }

            break;
        }

        supermarketController.addItemToBasket(item);
    }

    @FXML
    protected void onShowAllBasketItemsClick(){


        showBasketView.setText(supermarketController.showAllAsStringBasket());

    }


}
