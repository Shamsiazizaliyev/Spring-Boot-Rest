package az.orient.com.response;


import az.orient.com.dto.EmployeeDto;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeResponse {


    private List<EmployeeDto> employees;



}
