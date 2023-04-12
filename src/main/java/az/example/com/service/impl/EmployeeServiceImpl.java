package az.example.com.service.impl;

import az.example.com.dto.EmployeeDto;
import az.example.com.enums.ErrorCodeEnum;
import az.example.com.exception.CustomNotFoundException;
import az.example.com.model.Employee;
import az.example.com.repository.EmployeeRepository;
import az.example.com.response.EmployeeResponse;
import az.example.com.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {


    private  final EmployeeRepository repository;
    @Override
    public EmployeeResponse getEmployeeResponse() {


      /*  Sort sort = Sort.by(Sort.Order.asc("name"));
        PageRequest pageRequest=PageRequest.of(0,5, sort);
        repository.findAll(pageRequest);*/

       List<EmployeeDto>employeeDtolIST=  repository.findAll()
                .stream()
                .map(employee -> convertToDto(employee))
                .collect(Collectors.toList());


       return EmployeeResponse.builder().employees(employeeDtolIST).build();


    }

    @Override

    public EmployeeDto getEmployee(Long id) {

        Supplier<CustomNotFoundException> c=()->{ return
                new CustomNotFoundException(ErrorCodeEnum.EMPLOYYE_NOT_FOUND);};

        return repository.findById(id).map(employee -> convertToDto(employee))
                .orElseThrow(c);
    }

    @Override
    public EmployeeResponse getEmployeByNameAndSurname(String name, String surname) {




        List<EmployeeDto> collect = repository.findByNameAndSurname(name, surname).stream().map((employee -> convertToDto(employee))).collect(Collectors.toList());


        EmployeeResponse em=new EmployeeResponse();
        em.setEmployees(collect);
        return em;

    }

    @Override
    public void insert(EmployeeDto employeeDto) {

         Employee em=new Employee();

         BeanUtils.copyProperties(employeeDto,em);
         repository.save(em);




    }

    @Override

    public void update(EmployeeDto employeeDto, Long id) {

//        Supplier<CustomRestException> c=()->{ return
//                new CustomRestException(ErrorCodeEnum.EMPLOYYE_NOT_FOUND);};

        Employee em=new Employee();
        BeanUtils.copyProperties(employeeDto,em);
        em.setId(id);


        repository.findById(id)
                .orElseThrow(()->new CustomNotFoundException(ErrorCodeEnum.EMPLOYYE_NOT_FOUND));


        repository.save(em);



    }

    @Override
    public void delete(Long id) {
        EmployeeDto emDt=getEmployee(id);
        Employee e=new Employee();
        BeanUtils.copyProperties(emDt,e);
        repository.delete(e);
    }




    private EmployeeDto convertToDto(Employee employee){
       /* qisa variant

        EmployeeDto employeeDto=new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        return employeeDto;*/


        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .salary(employee.getSalary())
                .age(employee.getAge())
                .build();

    };


}
