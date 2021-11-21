package com.CC1.ProjetCC1.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    public String Firstname;
    public String Lastname;
    public String Age;
    public String Email;
    public String Password;

    public User(String firstName,String lastName, String age,String email,String password){
        this.Firstname = firstName;
        this.Lastname = lastName;
        this.Age = age;
        this.Email = email;
        this.Password = password;
    }

    public boolean isPasswordValid(String password) {
        return password.length() > 8 && password.length() < 40;
    }

    public boolean isFirstnameValid(String firstname) {
        String regex = "[A-Z][a-z]*";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(firstname);

        return matcher.matches();
    }

    public boolean isLastnameValid(String lastname) {
        String regex = "[A-Z]*";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(lastname);

        return matcher.matches();
    }

    public boolean isEmailValid(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public boolean isBirthdayValid(String birthday){
        int val = Integer.parseInt(birthday);
        if(val<=18){
            return false;
        }else{
            return true;
        }
    }


    public boolean isValid(){
        if((isFirstnameValid(this.Firstname)== true)&&(isLastnameValid(this.Lastname)==true)&&(isEmailValid(this.Email)==true)&&(isPasswordValid(this.Password)==true)) {
            return this.isEmailValid(this.Email) && this.isPasswordValid(this.Password) && Integer.parseInt(this.Age) >= 18;
        }
        return false;
    }
    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getAge() {
        return Age;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }
}
