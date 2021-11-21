package com.CC1.ProjetCC1.Controller;


import com.CC1.ProjetCC1.Api.ConnectDB;
import com.CC1.ProjetCC1.Api.Response;
import com.CC1.ProjetCC1.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    Response res = new Response();
    ConnectDB connectDB = new ConnectDB();


    @GetMapping(value = "/getAll")
    public String getAll() {
        return connectDB.connectDB("SELECT * FROM user", "SELECT");
    }

    @PostMapping(value = "/create")
    public String create(@RequestBody User user) {
        connectDB.connectDB("INSERT INTO user(Firstname, Lastname, Age, Email, Password) VALUES ('"+
                user.getFirstname()+ "','" +
                user.getLastname() + "','" +
                user.getAge() + "','" +
                user.getEmail() + "','" +
                user.getPassword() + "')"
                , "INSERT");
        return res.created("L'utilisateur "+user.getFirstname()+" "+user.getLastname());
    }

    @GetMapping(value = "/getPasswordByMail")
    public String getPasswordByMail(@RequestParam String mail) {
        String response = connectDB.connectDB("SELECT Password FROM user WHERE Email = '" + mail + "'", "PASSWORD");
        if(response != "") return response;
        res.notFound(mail);
        return "";
    }
}
