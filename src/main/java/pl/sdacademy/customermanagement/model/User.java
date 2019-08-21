package pl.sdacademy.customermanagement.model;




import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sdacademy.customermanagement.dto.UserDto;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")

public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotEmpty
    @Size(min=3,max=30)
    private String firstName;
    @NotEmpty
    @Size(min=3,max=30)
    private String lastName;
    private String street;
    private String city;
    @Pattern(message = "Nieporawny kod pocztowy",regexp = "\\d{2}(-\\d{3})?")
    private String zipCode;
    private String company;
    @Pattern(message = "Niepoprawny NIP lub PESEL",regexp = "\\d{10}|\\d{11}")
    private String idNumber;
    @Size(min=9,max = 12)
    private String phoneNumber;
    @Email
    private String email;
    private Boolean state=false;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractExpDate;

    @OneToMany(mappedBy = "luser")
    private List<Invoice> invoices;

    public UserDto toDto() {
        return UserDto.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .street(street)
                .city(city)
                .zipCode(zipCode)
                .company(company)
                .idNumber(idNumber)
                .phoneNumber(phoneNumber)
                .email(email)
                .state(state)
                .createDate(createDate)
                .contractExpDate(contractExpDate)
                .build();
    }
}
