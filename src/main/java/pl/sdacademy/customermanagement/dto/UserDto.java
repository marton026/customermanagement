package pl.sdacademy.customermanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sdacademy.customermanagement.model.UserAddress;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

public class UserDto {

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


}
