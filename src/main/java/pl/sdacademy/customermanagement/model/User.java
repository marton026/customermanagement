package pl.sdacademy.customermanagement.model;




import lombok.*;
import pl.sdacademy.customermanagement.dto.UserDto;

import javax.persistence.*;
import java.time.LocalDateTime;


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
    private LocalDateTime createDate;

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
