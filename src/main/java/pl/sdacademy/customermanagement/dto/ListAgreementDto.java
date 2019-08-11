package pl.sdacademy.customermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ListAgreementDto {

    private Long id;
    private String name;
    private Long agreementTime;
}
