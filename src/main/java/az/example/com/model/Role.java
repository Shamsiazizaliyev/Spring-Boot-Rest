package az.example.com.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String role_name;





}
