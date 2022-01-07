package com.CC1.ProjetCC1.model;


public final class Service {
    public final String Email;
    public final String Name;
    public final int Price;

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
