package com.CC1.ProjetCC1.Controller;

import com.CC1.ProjetCC1.Api.ConnectDB;
import com.CC1.ProjetCC1.Api.Response;
import com.CC1.ProjetCC1.model.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {
    Response res = new Response();
    ConnectDB connectDB = new ConnectDB();

    @GetMapping(value = "/getAll")
    public String getAll() {
        return connectDB.connectDB("SELECT * FROM service", "SELECT");
    }

    @PostMapping(value = "/create")
    public String create(@RequestBody Service service) {
        connectDB.connectDB("INSERT INTO service(Email, Name, Price) VALUES ('"+
                        service.getEmail()+ "','" +
                        service.getName() + "','" +
                        service.getPrice() + "')"
                , "INSERT");
        return res.created("Service");
    }
}
