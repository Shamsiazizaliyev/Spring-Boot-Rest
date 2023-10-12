package az.example.com;

import az.example.com.model.Role;
import az.example.com.model.User;
import az.example.com.repository.RoleRepository;
import az.example.com.repository.UserRepostory;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

@OpenAPIDefinition(

        info = @Info(
                title = "Employee Service API",
                description = " Employee crud services",
                version = "v1"

        )
)
public class SpringRestApplication{

    public static void main(String[] args) {

        SpringApplication.run(SpringRestApplication.class, args);

    }



}
