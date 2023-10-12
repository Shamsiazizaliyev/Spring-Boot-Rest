package az.example.com.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;


    @NotBlank(message = "ad daxil edin")
    private String name;


    @NotBlank(message = "soyad daxil edin")
    private String surname;





    @Min(value = 18,message = "18 den yuxari daxil edin")
    private int age;
    private double salary;

}
