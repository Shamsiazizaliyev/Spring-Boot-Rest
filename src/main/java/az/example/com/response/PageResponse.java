package az.example.com.response;

import az.example.com.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResponse{

        List<EmployeeDto> employeeDtoList;
        long totalElements;
        int totalPages;

        boolean hasNextPage;





}
