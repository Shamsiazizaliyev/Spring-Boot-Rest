package az.example.com.service;

import az.example.com.dto.EmployeeDto;
import az.example.com.response.EmployeeResponse;

public interface EmployeeService {


    EmployeeResponse getEmployeeResponse();

    EmployeeDto getEmployee(Long id);

    EmployeeResponse getEmployeByNameAndSurname(String name,String surname);

    void insert(EmployeeDto employeeDto);


    void update(EmployeeDto employeeDto, Long id);

    void delete(Long id);


}
