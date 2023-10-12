package az.example.com.controller;



import az.example.com.dto.EmployeeDto;
import az.example.com.exception.CustomNotFoundException;
import az.example.com.response.PageResponse;
import az.example.com.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class,excludeAutoConfiguration = SecurityAutoConfiguration.class)
class EmployeeControllerTest {

    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private EmployeeService employeeService;

     @Autowired
    private MockMvc mockMvc;

    @Test
    void saveInsert_Succes() throws Exception {
       var request=new EmployeeDto();
        request.setId(2l);
        request.setName("shamsi");
        request.setSurname("aliyev");
        request.setAge(24);
        request.setSalary(300);



        //act


          doNothing().when(employeeService).insert(request);
        mockMvc.perform(
                  get("/employee/add")
                 .contentType(MediaType.APPLICATION_JSON)
                          .content(mapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
//assert
        verify(employeeService,times(1)).insert(request);

    }
    @Test
    void saveInsert_WhenAgeSizeExceed_BadRequest ()throws Exception {
        var request=new EmployeeDto();
        request.setId(2l);
        request.setName("shamsi");
        request.setSurname("aliyev");
        request.setAge(2);
        request.setSalary(300);



        //act

        doNothing().when(employeeService).insert(request);
        mockMvc.perform(
                        get("/employee/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
//assert
        verify(employeeService,never()).insert(request);

    }

    @Test
    void saveInsert_WhenNameIsBlank_BadRequest ()throws Exception {
        var request=new EmployeeDto();
        request.setId(2l);
        request.setSurname("aliyev");
        request.setAge(22);
        request.setSalary(300);



        //act

        doNothing().when(employeeService).insert(request);
        mockMvc.perform(
                        get("/employee/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
        verifyNoInteractions(employeeService);

    }

    @Test
    void getEmployeeList_Succes() throws  Exception{
        //arange
        var response=new PageResponse();
        response.setHasNextPage(true);


        when(employeeService.getEmployeeResponse(1,3)).thenReturn(response);

        mockMvc.perform(get("/employee/employeList")
                .param("page","1")
                .param("count","3"))
              .andExpect(jsonPath("$.hasNextPage", Matchers.is(true)))
                .andExpect(status().isOk());


        verify(employeeService,times(1)).getEmployeeResponse(1,3);


    }

    @Test

    void getEmployee_Succes()throws Exception{
        var response=new EmployeeDto();
        response.setName("shamsi");


      when(employeeService.getEmployee(2l)).thenReturn(response);


        //act
        mockMvc.perform(
                        get("/employee/employe/{employeId}",2l))
               .andExpect(jsonPath("$.name",Matchers.is("shamsi")))
                .andExpect(status().isOk());
    }


    @Test

    void getEmployee_Bad()throws Exception{
        var response=new EmployeeDto();
        response.setName("shamsi");

       doThrow(CustomNotFoundException.class).when(employeeService).getEmployee(2l);
     //   when(employeeService.getEmployee(2l)).thenReturn(response);


        //act
        mockMvc.perform(
                        get("/employee/employe/{employeId}",2l))
                //.andExpect(jsonPath("$.name",Matchers.is("shamsi")))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateEmployee_Succes()throws Exception{
        var request=new EmployeeDto();
        request.setName("ali");

        doNothing().when(employeeService).update(request, 1L);

        //act
        mockMvc.perform(
                        get("/employee/update/{id}",1l)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
    @Test
    void deleteEmployee_Succes()throws Exception{
        var request=new EmployeeDto();
        request.setName("ali");

        doNothing().when(employeeService).delete( 1L);

        //act
        mockMvc.perform(
                        post("/employee/delete/{id}",1l))


                .andExpect(status().isNoContent());


    }



}