package pl.sdacademy.customermanagement.model;




import lombok.*;
import pl.sdacademy.customermanagement.dto.UserDto;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstName;
    private String lastName;
    @Embedded
    private UserAddress address;
    private String company;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private Boolean state;
    private Date createDate;

    public UserDto toDto() {
        return UserDto.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .phoneNumber(phoneNumber)
                .email(email)
                .state(state)
                .createDate(createDate)
                .build();
    }
}
