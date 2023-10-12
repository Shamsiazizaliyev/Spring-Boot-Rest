package az.example.com.controller;


import az.example.com.dto.EmployeeDto;
import az.example.com.response.EmployeeResponse;
import az.example.com.response.PageResponse;
import az.example.com.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
@Tag(name = "Employee Service")
public class EmployeeController {
    private  final EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);





    @GetMapping("test")
    public String test(){

        logger.info("test muracieti qebul olundu");
        return "test";
    }


    @GetMapping("text")
    public String text(){

        return "text";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("admin")
    public String admin(){

        return "admin";
    }
  @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("user")
    public String user(){

        return "user";
    }


    @GetMapping("/employeList")
    @Operation(summary = "this gets employee list")
    public PageResponse getAllEmployee(@RequestParam(value="page") int page, @RequestParam(value="count") int count){


       return employeeService.getEmployeeResponse(page,count);


    }


    @GetMapping("/employe/{employeId}")
    public EmployeeDto getEmployee(@PathVariable("employeId") Long id){

        logger.info("request qebul oldu");




        return employeeService.getEmployee(id);

    }
    @GetMapping("/search")
    EmployeeResponse getEmployeByNameAndSurname(



            @RequestParam("name") String name,@RequestParam("surname") String surname){

        return employeeService.getEmployeByNameAndSurname(name,surname);

    }

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public  void insert(@Valid @RequestBody EmployeeDto employeeDto){
        System.out.printf("salam");
        employeeService.insert(employeeDto);
        System.out.printf("sagol");

    }

    @GetMapping("/update/{id}")
    public  void update(@RequestBody EmployeeDto employeeDto,@PathVariable Long id){

         employeeService.update(employeeDto,id);





    }

    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void delete(@PathVariable Long id){

        employeeService.delete(id);

    }

}
