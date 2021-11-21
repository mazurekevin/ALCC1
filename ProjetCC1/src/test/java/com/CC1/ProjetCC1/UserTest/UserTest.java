package com.CC1.ProjetCC1.UserTest;

import com.CC1.ProjetCC1.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user = new User( "Kevin", "MAZURE", "21", "kevin@gmail.fr", "jesuislemdp");;
    private User user2 = new User( "test", "test", "12", "user.testgmail.com", "bla");;


    @Test
    public void isValidTest(){
        Assert.assertTrue(this.user.isValid());
        Assert.assertFalse(this.user2.isValid());

    }
    @org.junit.Test
    public void isValidFirstname(){
        Assert.assertTrue(this.user.isFirstnameValid(this.user.getFirstname()));
    }

    @org.junit.Test
    public void isValidLastname(){
        Assert.assertTrue(this.user.isLastnameValid(this.user.getLastname()));
    }

    @org.junit.Test
    public void isValidMail(){
        Assert.assertTrue(this.user.isEmailValid(this.user.getEmail()));
    }

    @org.junit.Test
    public void isValidPassword() {
        Assert.assertTrue(this.user.isPasswordValid(this.user.getPassword()));
    }

    @org.junit.Test
    public void isNoValidFirstname(){
        Assert.assertFalse(this.user2.isFirstnameValid(this.user2.getFirstname()));
    }

    @org.junit.Test
    public void isNoValidLastname(){
        Assert.assertFalse(this.user2.isLastnameValid(this.user2.getLastname()));
    }

    @org.junit.Test
    public void isNoValidMail(){
        Assert.assertFalse(this.user2.isEmailValid(this.user2.getEmail()));
    }

    @org.junit.Test
    public void isNoValidPassword() {
        Assert.assertFalse(this.user2.isPasswordValid(this.user2.getPassword()));
    }
}
