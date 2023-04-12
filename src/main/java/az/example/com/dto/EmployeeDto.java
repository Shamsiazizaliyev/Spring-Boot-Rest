package az.example.com.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;


    @NotBlank(message = "ad daxil edin")
    @Size(min = 3,message = "3 herfden yuxari den yuxari daxil edin")
    private String name;


    @NotBlank(message = "soyad daxil edin")
    private String surname;



    @Min(value = 18,message = "18 den yuxari daxil edin")
    private int age;
    private double salary;

}
