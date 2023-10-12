package az.example.com.controller;





import az.example.com.model.Role;
import az.example.com.model.User;
import az.example.com.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    UserService service;


    @GetMapping("/test")
    public String user(){

        return "test";
    }



    @PostMapping("/new")

    public String addNewUser(@RequestBody User user){


        Role role=new Role();
        role.setRole_name("ADMIN");
        List<Role>list=new ArrayList<>();
        list.add(role);
        user.setRoles(list);

        return service.addUser(user);
    }





}



