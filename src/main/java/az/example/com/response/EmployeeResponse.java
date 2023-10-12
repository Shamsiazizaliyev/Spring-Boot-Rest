package az.example.com.response;


import az.example.com.dto.EmployeeDto;
import lombok.*;

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
