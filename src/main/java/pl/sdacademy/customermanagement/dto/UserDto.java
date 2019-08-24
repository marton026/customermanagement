package pl.sdacademy.customermanagement.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sdacademy.customermanagement.model.Invoice;

import java.time.LocalDate;
import java.util.List;


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
    private Boolean state=false;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractExpDate;
    private List<Invoice> invoices;


}
