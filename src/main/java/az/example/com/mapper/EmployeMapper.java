

package az.example.com.mapper;

import az.example.com.dto.EmployeeDto;
import az.example.com.model.Employee;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EmployeMapper {


    EmployeeDto toEmployeeDto(Employee employee);

    Employee toEmployee(EmployeeDto employeeDto);
}


