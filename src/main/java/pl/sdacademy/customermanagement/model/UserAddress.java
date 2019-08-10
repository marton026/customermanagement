package pl.sdacademy.customermanagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class UserAddress {
    private String street;
    private String city;
    private String zipCode;
}
