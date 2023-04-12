package az.orient.com.controller;


import az.orient.com.dto.EmployeeDto;
import az.orient.com.response.EmployeeResponse;
import az.orient.com.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
@Tag(name = "Employee Service")
public class EmployeeController {


    private  final EmployeeService employeeService;




    @GetMapping("test")
    public String test(){

        return "test";
    }


    @GetMapping("text")
    public String text(){

        return "text";
    }



    @GetMapping("/employeList")
    @Operation(summary = "this gets employee list")
    public EmployeeResponse getAllEmployee(){


       return employeeService.getEmployeeResponse();


    }


    @GetMapping("/employe/{employeId}")
    public EmployeeDto getEmployee(@PathVariable("employeId") Long id){


        return employeeService.getEmployee(id);

    }
    @GetMapping("/search")
    EmployeeResponse getEmployeByNameAndSurname(
            @RequestParam("name") String name,@RequestParam("surname") String surname){

        return employeeService.getEmployeByNameAndSurname(name,surname);

    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public  void insert(@Valid @RequestBody EmployeeDto employeeDto){

       employeeService.insert(employeeDto);

    }

    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  void update(@RequestBody EmployeeDto employeeDto,@PathVariable Long id){

         employeeService.update(employeeDto,id);

    }

    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void delete(@PathVariable Long id){

        employeeService.delete(id);

    }

}
