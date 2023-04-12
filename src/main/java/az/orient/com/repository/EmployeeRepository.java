package az.orient.com.repository;

import az.orient.com.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
