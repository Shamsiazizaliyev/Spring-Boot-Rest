package az.example.com.mapper;

import az.example.com.dto.EmployeeDto;
import az.example.com.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeMapperTest {
   final EmployeMapper mapper=new EmployeMapperImpl();
    @Test
    void toEmployeeDto() {

        //given,Arrange
        var employe=new Employee();
        employe.setId(1l);
        employe.setName("shamsi");
        employe.setSurname("aliyev");
        employe.setAge(27);
        employe.setSalary(3000);

        var expected=new EmployeeDto();
        expected.setId(1l);
        expected.setName("shamsi");
        expected.setSurname("aliyev");
        expected.setAge(27);
        expected.setSalary(3000);




        //when,act

        var actual =mapper.toEmployeeDto(employe);

          //then,assert

          Assertions.assertThat(actual).isEqualTo(expected);
       //Assertions.assertEquals(expected,act);

    }

    @Test
    void toEmployee() {

        //given,Arrange
        var employeeDto=new EmployeeDto();
        employeeDto.setId(1l);
        employeeDto.setName("shamsi");
        employeeDto.setSurname("aliyev");
        employeeDto.setAge(27);
        employeeDto.setSalary(3000);

        var expected=new Employee();
        expected.setId(1l);
        expected.setName("shamsi");
        expected.setSurname("aliyev");
        expected.setAge(27);
        expected.setSalary(3000);




        //when,act

        var actual =mapper.toEmployee(employeeDto);

        //then,assert


        Assertions.assertThat(actual).isEqualTo(expected);
    }
}