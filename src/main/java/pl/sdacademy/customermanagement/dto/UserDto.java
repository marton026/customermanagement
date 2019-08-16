package pl.sdacademy.customermanagement.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class UserDto {


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


}
