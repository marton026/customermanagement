package pl.sdacademy.customermanagement.model;




import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sdacademy.customermanagement.dto.UserDto;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zipCode;
    private String company;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private Boolean state;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    public UserDto toDto() {
        return UserDto.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .street(street)
                .city(city)
                .zipCode(zipCode)
                .phoneNumber(phoneNumber)
                .email(email)
                .state(state)
                .createDate(createDate)
                .build();
    }
}
