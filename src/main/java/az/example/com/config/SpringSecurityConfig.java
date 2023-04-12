package az.example.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@EnableWebSecurity
@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {





    private UserDetailsService userDetailsService;



    public SpringSecurityConfig (UserDetailsService userDetailsService) {

        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(userDetailsService);





    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

                 http.authorizeRequests()
                .antMatchers("/employee/test")
                .permitAll() //icaze ver
                .antMatchers("/employee/text")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and().httpBasic();



    }




}

