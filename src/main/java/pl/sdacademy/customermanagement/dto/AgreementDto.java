package pl.sdacademy.customermanagement.dto;

import lombok.*;
import pl.sdacademy.customermanagement.model.ListAgreement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Getter

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AgreementDto {


    private Long id;
    private LocalDate createAgrement;
    private LocalDate endAgreement;
    private ListAgreement listAgreement;

}
