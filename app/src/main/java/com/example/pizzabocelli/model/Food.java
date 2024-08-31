package com.example.pizzabocelli.model;

public class Food {
    int imgFood;
    String foodName;
    String foodDescription;
    String price;
    int quantity; // Novo campo de quantidade

    public Food(int imgFood, String foodName, String foodDescription, String price) {
        this.imgFood = imgFood;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.price = price;
        this.quantity = 0; // Inicializa a quantidade com 0
    }

    public int getImgFood() {
        return imgFood;
    }

    public void setImgFood(int imgFood) {
        this.imgFood = imgFood;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
