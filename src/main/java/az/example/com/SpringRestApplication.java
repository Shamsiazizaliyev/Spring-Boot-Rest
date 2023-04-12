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
import org.springframework.security.crypto.password.PasswordEncoder;

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
public class SpringRestApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(SpringRestApplication.class, args);

    }


    @Autowired
    UserRepostory userRepostory;

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    private PasswordEncoder passwordConfig;


    @Override
    public void run(String... args) throws Exception {


        Role roleAdmin = Role.builder().role_name("ROLE_ADMIN").build();

        Role roleUser = Role.builder().role_name("ROLE_USER").build();
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        List<Role> adminRoleList = new ArrayList<>();
        adminRoleList.add(roleAdmin);

        User admin = User.builder().id(3).name("shemsi").password(passwordConfig.encode("12345")).roles(adminRoleList).build();
        userRepostory.save(admin);


        List<Role> userRoleList = new ArrayList<>();
        userRoleList.add(roleUser);

        User user = User.builder().id(3).name("ali").password(passwordConfig.encode("12345")).roles(userRoleList).build();
        userRepostory.save(user);


        System.out.println("_____Roleeee______");
        roleRepository.findAll().forEach(System.out::println);

        System.out.println("_____User________");
        userRepostory.findAll().forEach(System.out::println);

    }
}
