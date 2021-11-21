package com.CC1.ProjetCC1.model;


public class Service {
    public String Email;
    public String Name;
    public int Price;

    public Service(String email, String name, int price){
        this.Email = email;
        this.Name = name;
        this.Price = price;
    }


    public String getEmail() {
        return Email;
    }

    public String getName() {
        return Name;
    }

    public int getPrice() {
        return Price;
    }


}
