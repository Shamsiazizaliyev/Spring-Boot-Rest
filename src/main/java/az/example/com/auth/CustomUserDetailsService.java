
package az.example.com.auth;



import az.example.com.model.User;
import az.example.com.repository.UserRepostory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepostory userRepostory;

    public CustomUserDetailsService(UserRepostory userRepostory) {
        this.userRepostory = userRepostory;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      User userByName = userRepostory.findUserByName(username);

        return new CustomUserDetail(userByName);

    }
}

