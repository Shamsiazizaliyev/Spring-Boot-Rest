package az.orient.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity //configurasiyani aktivlesdir
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
                .antMatchers("/employee/test")//bele url gelersen olarin kimliyini yoxlama
                .permitAll() //icaze ver
                .antMatchers("/employee/text")//bu url-i
                .hasRole("ADMIN")// bu role da olan aca biler
                .anyRequest()//baqa gelen requestler ucun
                .authenticated()//kimliyni yoxlamaq teleb olunur
                .and().httpBasic();

                //formLogin()//login forma yonlendirir
                 //.and().logout();

    }




}

