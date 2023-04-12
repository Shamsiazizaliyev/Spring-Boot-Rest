package az.orient.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {


    @GetMapping("/wel")
    public String welcome(){

        return "Welcome to";
    }
}
