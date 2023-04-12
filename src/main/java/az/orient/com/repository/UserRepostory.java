package az.orient.com.repository;



import az.orient.com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostory extends JpaRepository<User,Integer> {



    User findUserByName(String s);


}
