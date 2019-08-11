package pl.sdacademy.customermanagement.dto;

import lombok.*;
import pl.sdacademy.customermanagement.model.ListAgreement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;


@Getter

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AgreementDto {


    private Long id;
    private LocalDateTime createAgrement;
    private LocalDateTime endAgreement;
    private ListAgreement listAgreement;

}
