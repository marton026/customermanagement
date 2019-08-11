package pl.sdacademy.customermanagement.dto;

import lombok.Getter;
import lombok.Setter;
import pl.sdacademy.customermanagement.model.ListAgreement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "agreements")
@Getter
@Setter
public class AgreementDto {

    @Id @GeneratedValue
    private long id;
    private Date createAgrement;
    private Date endAgreement;
    private ListAgreement listAgreement;

}
