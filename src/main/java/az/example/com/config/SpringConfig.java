package az.example.com.config;

import az.example.com.auth.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@EnableGlobalAuthentication
@AllArgsConstructor
public class SpringConfig {


    private final UserDetailsService userDetailsService;

 /*
    @Bean
    public UserDetailsService userDetailsService(){

      UserDetails admin= User.withUsername("shemsi")
                .password(passwordEncoder().encode("12345"))
                .roles("ADMIN")
                .build();


        UserDetails user= User.withUsername("mamed")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);



    

    }
    */



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

       return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/employee/**").permitAll()
                .and().authorizeHttpRequests().requestMatchers("/employee/test").authenticated()
                .and().httpBasic()
                .and().build();


    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;

    }
}
