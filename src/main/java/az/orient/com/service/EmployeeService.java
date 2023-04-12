package az.orient.com.service;

import az.orient.com.dto.EmployeeDto;
import az.orient.com.model.Employee;
import az.orient.com.response.EmployeeResponse;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {


    EmployeeResponse getEmployeeResponse();

    EmployeeDto getEmployee(Long id);

    EmployeeResponse getEmployeByNameAndSurname(String name,String surname);

    void insert(EmployeeDto employeeDto);


    void update(EmployeeDto employeeDto, Long id);

    void delete(Long id);


}
