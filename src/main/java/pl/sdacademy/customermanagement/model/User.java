package pl.sdacademy.customermanagement.model;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id @GeneratedValue
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
