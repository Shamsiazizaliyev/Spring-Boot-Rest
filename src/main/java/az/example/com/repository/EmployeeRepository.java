package az.example.com.repository;

import az.example.com.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {




     Optional<Employee> findAllById(Long id);



     List<Employee> findByNameAndSurname(String name,String surname);

   //  @Query(" select e from Employee e  where e.age>?1 and e.salary<?2")
    // @Query("select e from Employee e where e.age>: age ")

    // List<Employee> findSome(@Param("age") int age);











}
